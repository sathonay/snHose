package net.minecraft.server.v1_7_R4;

public class PathfinderGoalRandomTargetNonTamed extends PathfinderGoalNearestAttackableTarget
{
    private EntityTameableAnimal a;
    
    public PathfinderGoalRandomTargetNonTamed(final EntityTameableAnimal entityTameableAnimal, final Class oclass, final int i, final boolean flag) {
        super(entityTameableAnimal, oclass, i, flag);
        this.a = entityTameableAnimal;
    }
    
    @Override
    public boolean a() {
        return !this.a.isTamed() && super.a();
    }
}
