package net.minecraft.server.v1_7_R4;

public class PathfinderGoalOfferFlower extends PathfinderGoal
{
    private EntityIronGolem a;
    private EntityVillager b;
    private int c;
    
    public PathfinderGoalOfferFlower(final EntityIronGolem a) {
        this.a = a;
        this.a(3);
    }
    
    @Override
    public boolean a() {
        if (!this.a.world.w()) {
            return false;
        }
        if (this.a.aI().nextInt(8000) != 0) {
            return false;
        }
        this.b = (EntityVillager)this.a.world.a(EntityVillager.class, this.a.boundingBox.grow(6.0, 2.0, 6.0), this.a);
        return this.b != null;
    }
    
    @Override
    public boolean b() {
        return this.c > 0;
    }
    
    @Override
    public void c() {
        this.c = 400;
        this.a.a(true);
    }
    
    @Override
    public void d() {
        this.a.a(false);
        this.b = null;
    }
    
    @Override
    public void e() {
        this.a.getControllerLook().a(this.b, 30.0f, 30.0f);
        --this.c;
    }
}
