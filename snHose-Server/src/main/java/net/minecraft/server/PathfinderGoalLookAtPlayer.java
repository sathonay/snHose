package net.minecraft.server;

public class PathfinderGoalLookAtPlayer extends PathfinderGoal
{
    private EntityInsentient b;
    protected Entity a;
    private float c;
    private int d;
    private float e;
    private Class f;
    
    public PathfinderGoalLookAtPlayer(final EntityInsentient b, final Class f, final float c) {
        this.b = b;
        this.f = f;
        this.c = c;
        this.e = 0.02f;
        this.a(2);
    }
    
    public PathfinderGoalLookAtPlayer(final EntityInsentient b, final Class f, final float c, final float e) {
        this.b = b;
        this.f = f;
        this.c = c;
        this.e = e;
        this.a(2);
    }
    
    @Override
    public boolean a() {
        if (this.b.aI().nextFloat() >= this.e) {
            return false;
        }
        if (this.b.getGoalTarget() != null) {
            this.a = this.b.getGoalTarget();
        }
        if (this.f == EntityHuman.class) {
            this.a = this.b.world.findNearbyPlayer(this.b, this.c);
        }
        else {
            this.a = this.b.world.a(this.f, this.b.boundingBox.grow(this.c, 3.0, this.c), this.b);
        }
        return this.a != null;
    }
    
    @Override
    public boolean b() {
        return this.a.isAlive() && this.b.f(this.a) <= this.c * this.c && this.d > 0;
    }
    
    @Override
    public void c() {
        this.d = 40 + this.b.aI().nextInt(40);
    }
    
    @Override
    public void d() {
        this.a = null;
    }
    
    @Override
    public void e() {
        this.b.getControllerLook().a(this.a.locX, this.a.locY + this.a.getHeadHeight(), this.a.locZ, 10.0f, this.b.x());
        --this.d;
    }
}
