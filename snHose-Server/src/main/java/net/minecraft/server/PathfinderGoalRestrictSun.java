package net.minecraft.server.v1_7_R4;

public class PathfinderGoalRestrictSun extends PathfinderGoal
{
    private EntityCreature a;
    
    public PathfinderGoalRestrictSun(final EntityCreature a) {
        this.a = a;
    }
    
    @Override
    public boolean a() {
        return this.a.world.w();
    }
    
    @Override
    public void c() {
        this.a.getNavigation().d(true);
    }
    
    @Override
    public void d() {
        this.a.getNavigation().d(false);
    }
}
