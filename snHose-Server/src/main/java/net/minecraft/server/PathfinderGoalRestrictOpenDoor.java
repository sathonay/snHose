package net.minecraft.server;

public class PathfinderGoalRestrictOpenDoor extends PathfinderGoal
{
    private EntityCreature a;
    private VillageDoor b;
    
    public PathfinderGoalRestrictOpenDoor(final EntityCreature a) {
        this.a = a;
    }
    
    @Override
    public boolean a() {
        if (this.a.world.w()) {
            return false;
        }
        final Village closestVillage = this.a.world.villages.getClosestVillage(MathHelper.floor(this.a.locX), MathHelper.floor(this.a.locY), MathHelper.floor(this.a.locZ), 16);
        if (closestVillage == null) {
            return false;
        }
        this.b = closestVillage.b(MathHelper.floor(this.a.locX), MathHelper.floor(this.a.locY), MathHelper.floor(this.a.locZ));
        return this.b != null && this.b.c(MathHelper.floor(this.a.locX), MathHelper.floor(this.a.locY), MathHelper.floor(this.a.locZ)) < 2.25;
    }
    
    @Override
    public boolean b() {
        return !this.a.world.w() && !this.b.removed && this.b.a(MathHelper.floor(this.a.locX), MathHelper.floor(this.a.locZ));
    }
    
    @Override
    public void c() {
        this.a.getNavigation().b(false);
        this.a.getNavigation().c(false);
    }
    
    @Override
    public void d() {
        this.a.getNavigation().b(true);
        this.a.getNavigation().c(true);
        this.b = null;
    }
    
    @Override
    public void e() {
        this.b.e();
    }
}
