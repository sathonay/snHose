package net.minecraft.server.v1_7_R4;

public class PathfinderGoalDefendVillage extends PathfinderGoalTarget
{
    EntityIronGolem a;
    EntityLiving b;
    
    public PathfinderGoalDefendVillage(final EntityIronGolem entityIronGolem) {
        super(entityIronGolem, false, true);
        this.a = entityIronGolem;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        final Village bz = this.a.bZ();
        if (bz == null) {
            return false;
        }
        this.b = bz.b(this.a);
        if (this.a(this.b, false)) {
            return true;
        }
        if (this.c.aI().nextInt(20) == 0) {
            this.b = bz.c(this.a);
            return this.a(this.b, false);
        }
        return false;
    }
    
    @Override
    public void c() {
        this.a.setGoalTarget(this.b);
        super.c();
    }
}
