package net.minecraft.server.v1_7_R4;

public class PathfinderGoalBeg extends PathfinderGoal
{
    private EntityWolf a;
    private EntityHuman b;
    private World c;
    private float d;
    private int e;
    
    public PathfinderGoalBeg(final EntityWolf a, final float d) {
        this.a = a;
        this.c = a.world;
        this.d = d;
        this.a(2);
    }
    
    @Override
    public boolean a() {
        this.b = this.c.findNearbyPlayer(this.a, this.d);
        return this.b != null && this.a(this.b);
    }
    
    @Override
    public boolean b() {
        return this.b.isAlive() && this.a.f(this.b) <= this.d * this.d && this.e > 0 && this.a(this.b);
    }
    
    @Override
    public void c() {
        this.a.m(true);
        this.e = 40 + this.a.aI().nextInt(40);
    }
    
    @Override
    public void d() {
        this.a.m(false);
        this.b = null;
    }
    
    @Override
    public void e() {
        this.a.getControllerLook().a(this.b.locX, this.b.locY + this.b.getHeadHeight(), this.b.locZ, 10.0f, this.a.x());
        --this.e;
    }
    
    private boolean a(final EntityHuman entityHuman) {
        final ItemStack itemInHand = entityHuman.inventory.getItemInHand();
        return itemInHand != null && ((!this.a.isTamed() && itemInHand.getItem() == Items.BONE) || this.a.c(itemInHand));
    }
}
