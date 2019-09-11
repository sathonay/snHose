package net.minecraft.server;

public class PathfinderGoalTempt extends PathfinderGoal
{
    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private EntityHuman h;
    private int i;
    private boolean j;
    private Item k;
    private boolean l;
    private boolean m;
    
    public PathfinderGoalTempt(final EntityCreature a, final double b, final Item k, final boolean l) {
        this.a = a;
        this.b = b;
        this.k = k;
        this.l = l;
        this.a(3);
    }
    
    @Override
    public boolean a() {
        if (this.i > 0) {
            --this.i;
            return false;
        }
        this.h = this.a.world.findNearbyPlayer(this.a, 10.0);
        if (this.h == null) {
            return false;
        }
        final ItemStack bf = this.h.bF();
        return bf != null && bf.getItem() == this.k;
    }
    
    @Override
    public boolean b() {
        if (this.l) {
            if (this.a.f(this.h) < 36.0) {
                if (this.h.e(this.c, this.d, this.e) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs(this.h.pitch - this.f) > 5.0 || Math.abs(this.h.yaw - this.g) > 5.0) {
                    return false;
                }
            }
            else {
                this.c = this.h.locX;
                this.d = this.h.locY;
                this.e = this.h.locZ;
            }
            this.f = this.h.pitch;
            this.g = this.h.yaw;
        }
        return this.a();
    }
    
    @Override
    public void c() {
        this.c = this.h.locX;
        this.d = this.h.locY;
        this.e = this.h.locZ;
        this.j = true;
        this.m = this.a.getNavigation().a();
        this.a.getNavigation().a(false);
    }
    
    @Override
    public void d() {
        this.h = null;
        this.a.getNavigation().h();
        this.i = 100;
        this.j = false;
        this.a.getNavigation().a(this.m);
    }
    
    @Override
    public void e() {
        this.a.getControllerLook().a(this.h, 30.0f, this.a.x());
        if (this.a.f(this.h) < 6.25) {
            this.a.getNavigation().h();
        }
        else {
            this.a.getNavigation().a(this.h, this.b);
        }
    }
    
    public boolean f() {
        return this.j;
    }
}
