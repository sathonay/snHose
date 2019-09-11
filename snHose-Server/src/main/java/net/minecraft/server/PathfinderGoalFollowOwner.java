package net.minecraft.server;

public class PathfinderGoalFollowOwner extends PathfinderGoal
{
    private EntityTameableAnimal d;
    private EntityLiving e;
    World a;
    private double f;
    private Navigation g;
    private int h;
    float b;
    float c;
    private boolean i;
    
    public PathfinderGoalFollowOwner(final EntityTameableAnimal d, final double f, final float c, final float b) {
        this.d = d;
        this.a = d.world;
        this.f = f;
        this.g = d.getNavigation();
        this.c = c;
        this.b = b;
        this.a(3);
    }
    
    @Override
    public boolean a() {
        final EntityLiving owner = this.d.getOwner();
        if (owner == null) {
            return false;
        }
        if (this.d.isSitting()) {
            return false;
        }
        if (this.d.f(owner) < this.c * this.c) {
            return false;
        }
        this.e = owner;
        return true;
    }
    
    @Override
    public boolean b() {
        return !this.g.g() && this.d.f(this.e) > this.b * this.b && !this.d.isSitting();
    }
    
    @Override
    public void c() {
        this.h = 0;
        this.i = this.d.getNavigation().a();
        this.d.getNavigation().a(false);
    }
    
    @Override
    public void d() {
        this.e = null;
        this.g.h();
        this.d.getNavigation().a(this.i);
    }
    
    @Override
    public void e() {
        this.d.getControllerLook().a(this.e, 10.0f, this.d.x());
        if (this.d.isSitting()) {
            return;
        }
        if (--this.h > 0) {
            return;
        }
        this.h = 10;
        if (this.g.a(this.e, this.f)) {
            return;
        }
        if (this.d.bN()) {
            return;
        }
        if (this.d.f(this.e) < 144.0) {
            return;
        }
        final int n = MathHelper.floor(this.e.locX) - 2;
        final int n2 = MathHelper.floor(this.e.locZ) - 2;
        final int floor = MathHelper.floor(this.e.boundingBox.b);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                if (i < 1 || j < 1 || i > 3 || j > 3) {
                    if (World.a(this.a, n + i, floor - 1, n2 + j) && !this.a.getType(n + i, floor, n2 + j).r() && !this.a.getType(n + i, floor + 1, n2 + j).r()) {
                        this.d.setPositionRotation(n + i + 0.5f, floor, n2 + j + 0.5f, this.d.yaw, this.d.pitch);
                        this.g.h();
                        return;
                    }
                }
            }
        }
    }
}
