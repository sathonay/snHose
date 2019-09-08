package net.minecraft.server.v1_7_R4;

public class PathfinderGoalRandomStroll extends PathfinderGoal
{
    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private double e;
    
    public PathfinderGoalRandomStroll(final EntityCreature a, final double e) {
        this.a = a;
        this.e = e;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        if (this.a.aN() >= 100) {
            return false;
        }
        if (this.a.aI().nextInt(120) != 0) {
            return false;
        }
        final Vec3D a = RandomPositionGenerator.a(this.a, 10, 7);
        if (a == null) {
            return false;
        }
        this.b = a.a;
        this.c = a.b;
        this.d = a.c;
        return true;
    }
    
    @Override
    public boolean b() {
        return !this.a.getNavigation().g();
    }
    
    @Override
    public void c() {
        this.a.getNavigation().a(this.b, this.c, this.d, this.e);
    }
}
