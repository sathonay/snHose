package net.minecraft.server.v1_7_R4;

public class PathfinderGoalMoveTowardsTarget extends PathfinderGoal
{
    private EntityCreature a;
    private EntityLiving b;
    private double c;
    private double d;
    private double e;
    private double f;
    private float g;
    
    public PathfinderGoalMoveTowardsTarget(final EntityCreature a, final double f, final float g) {
        this.a = a;
        this.f = f;
        this.g = g;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        this.b = this.a.getGoalTarget();
        if (this.b == null) {
            return false;
        }
        if (this.b.f(this.a) > this.g * this.g) {
            return false;
        }
        final Vec3D a = RandomPositionGenerator.a(this.a, 16, 7, Vec3D.a(this.b.locX, this.b.locY, this.b.locZ));
        if (a == null) {
            return false;
        }
        this.c = a.a;
        this.d = a.b;
        this.e = a.c;
        return true;
    }
    
    @Override
    public boolean b() {
        return !this.a.getNavigation().g() && this.b.isAlive() && this.b.f(this.a) < this.g * this.g;
    }
    
    @Override
    public void d() {
        this.b = null;
    }
    
    @Override
    public void c() {
        this.a.getNavigation().a(this.c, this.d, this.e, this.f);
    }
}
