package net.minecraft.server.v1_7_R4;

public class PathfinderGoalLeapAtTarget extends PathfinderGoal
{
    EntityInsentient a;
    EntityLiving b;
    float c;
    
    public PathfinderGoalLeapAtTarget(final EntityInsentient a, final float c) {
        this.a = a;
        this.c = c;
        this.a(5);
    }
    
    @Override
    public boolean a() {
        this.b = this.a.getGoalTarget();
        if (this.b == null) {
            return false;
        }
        final double f = this.a.f(this.b);
        return f >= 4.0 && f <= 16.0 && this.a.onGround && this.a.aI().nextInt(5) == 0;
    }
    
    @Override
    public boolean b() {
        return !this.a.onGround;
    }
    
    @Override
    public void c() {
        final double n = this.b.locX - this.a.locX;
        final double n2 = this.b.locZ - this.a.locZ;
        final float sqrt = MathHelper.sqrt(n * n + n2 * n2);
        final EntityInsentient a = this.a;
        a.motX += n / sqrt * 0.5 * 0.800000011920929 + this.a.motX * 0.20000000298023224;
        final EntityInsentient a2 = this.a;
        a2.motZ += n2 / sqrt * 0.5 * 0.800000011920929 + this.a.motZ * 0.20000000298023224;
        this.a.motY = this.c;
    }
}
