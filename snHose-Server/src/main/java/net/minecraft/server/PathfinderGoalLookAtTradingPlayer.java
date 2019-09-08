package net.minecraft.server.v1_7_R4;

public class PathfinderGoalLookAtTradingPlayer extends PathfinderGoalLookAtPlayer
{
    private final EntityVillager b;
    
    public PathfinderGoalLookAtTradingPlayer(final EntityVillager b) {
        super(b, EntityHuman.class, 8.0f);
        this.b = b;
    }
    
    @Override
    public boolean a() {
        if (this.b.cc()) {
            this.a = this.b.b();
            return true;
        }
        return false;
    }
}
