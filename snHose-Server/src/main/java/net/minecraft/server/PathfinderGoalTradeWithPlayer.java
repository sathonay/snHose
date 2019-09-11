package net.minecraft.server;

public class PathfinderGoalTradeWithPlayer extends PathfinderGoal
{
    private EntityVillager a;
    
    public PathfinderGoalTradeWithPlayer(final EntityVillager a) {
        this.a = a;
        this.a(5);
    }
    
    @Override
    public boolean a() {
        if (!this.a.isAlive()) {
            return false;
        }
        if (this.a.M()) {
            return false;
        }
        if (!this.a.onGround) {
            return false;
        }
        if (this.a.velocityChanged) {
            return false;
        }
        final EntityHuman b = this.a.b();
        return b != null && this.a.f(b) <= 16.0 && b.activeContainer instanceof Container;
    }
    
    @Override
    public void c() {
        this.a.getNavigation().h();
    }
    
    @Override
    public void d() {
        this.a.a_((EntityHuman)null);
    }
}
