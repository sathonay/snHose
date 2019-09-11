package net.minecraft.server;

public class PathfinderGoalRandomLookaround extends PathfinderGoal
{
    private EntityInsentient a;
    private double b;
    private double c;
    private int d;
    
    public PathfinderGoalRandomLookaround(final EntityInsentient a) {
        this.a = a;
        this.a(3);
    }
    
    @Override
    public boolean a() {
        return this.a.aI().nextFloat() < 0.02f;
    }
    
    @Override
    public boolean b() {
        return this.d >= 0;
    }
    
    @Override
    public void c() {
        final double n = 6.283185307179586 * this.a.aI().nextDouble();
        this.b = Math.cos(n);
        this.c = Math.sin(n);
        this.d = 20 + this.a.aI().nextInt(20);
    }
    
    @Override
    public void e() {
        --this.d;
        this.a.getControllerLook().a(this.a.locX + this.b, this.a.locY + this.a.getHeadHeight(), this.a.locZ + this.c, 10.0f, this.a.x());
    }
}
