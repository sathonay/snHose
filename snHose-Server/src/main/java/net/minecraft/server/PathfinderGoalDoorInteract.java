package net.minecraft.server;

public abstract class PathfinderGoalDoorInteract extends PathfinderGoal
{
    protected EntityInsentient a;
    protected int b;
    protected int c;
    protected int d;
    protected BlockDoor e;
    boolean f;
    float g;
    float h;
    
    public PathfinderGoalDoorInteract(final EntityInsentient a) {
        this.a = a;
    }
    
    @Override
    public boolean a() {
        if (!this.a.positionChanged) {
            return false;
        }
        final Navigation navigation = this.a.getNavigation();
        final PathEntity e = navigation.e();
        if (e == null || e.b() || !navigation.c()) {
            return false;
        }
        for (int i = 0; i < Math.min(e.e() + 2, e.d()); ++i) {
            final PathPoint a = e.a(i);
            this.b = a.a;
            this.c = a.b + 1;
            this.d = a.c;
            if (this.a.e(this.b, this.a.locY, this.d) <= 2.25) {
                this.e = this.a(this.b, this.c, this.d);
                if (this.e != null) {
                    return true;
                }
            }
        }
        this.b = MathHelper.floor(this.a.locX);
        this.c = MathHelper.floor(this.a.locY + 1.0);
        this.d = MathHelper.floor(this.a.locZ);
        this.e = this.a(this.b, this.c, this.d);
        return this.e != null;
    }
    
    @Override
    public boolean b() {
        return !this.f;
    }
    
    @Override
    public void c() {
        this.f = false;
        this.g = (float)(this.b + 0.5f - this.a.locX);
        this.h = (float)(this.d + 0.5f - this.a.locZ);
    }
    
    @Override
    public void e() {
        if (this.g * (float)(this.b + 0.5f - this.a.locX) + this.h * (float)(this.d + 0.5f - this.a.locZ) < 0.0f) {
            this.f = true;
        }
    }
    
    private BlockDoor a(final int i, final int j, final int k) {
        final Block type = this.a.world.getType(i, j, k);
        if (type != Blocks.WOODEN_DOOR) {
            return null;
        }
        return (BlockDoor)type;
    }
}
