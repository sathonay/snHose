package net.minecraft.server.v1_7_R4;

public class PathfinderGoalMoveIndoors extends PathfinderGoal
{
    private EntityCreature a;
    private VillageDoor b;
    private int c;
    private int d;
    
    public PathfinderGoalMoveIndoors(final EntityCreature a) {
        this.c = -1;
        this.d = -1;
        this.a = a;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        final int floor = MathHelper.floor(this.a.locX);
        final int floor2 = MathHelper.floor(this.a.locY);
        final int floor3 = MathHelper.floor(this.a.locZ);
        if ((this.a.world.w() && !this.a.world.Q() && this.a.world.getBiome(floor, floor3).e()) || this.a.world.worldProvider.g) {
            return false;
        }
        if (this.a.aI().nextInt(50) != 0) {
            return false;
        }
        if (this.c != -1 && this.a.e(this.c, this.a.locY, this.d) < 4.0) {
            return false;
        }
        final Village closestVillage = this.a.world.villages.getClosestVillage(floor, floor2, floor3, 14);
        if (closestVillage == null) {
            return false;
        }
        this.b = closestVillage.c(floor, floor2, floor3);
        return this.b != null;
    }
    
    @Override
    public boolean b() {
        return !this.a.getNavigation().g();
    }
    
    @Override
    public void c() {
        this.c = -1;
        if (this.a.e(this.b.getIndoorsX(), this.b.locY, this.b.getIndoorsZ()) > 256.0) {
            final Vec3D a = RandomPositionGenerator.a(this.a, 14, 3, Vec3D.a(this.b.getIndoorsX() + 0.5, this.b.getIndoorsY(), this.b.getIndoorsZ() + 0.5));
            if (a != null) {
                this.a.getNavigation().a(a.a, a.b, a.c, 1.0);
            }
        }
        else {
            this.a.getNavigation().a(this.b.getIndoorsX() + 0.5, this.b.getIndoorsY(), this.b.getIndoorsZ() + 0.5, 1.0);
        }
    }
    
    @Override
    public void d() {
        this.c = this.b.getIndoorsX();
        this.d = this.b.getIndoorsZ();
        this.b = null;
    }
}
