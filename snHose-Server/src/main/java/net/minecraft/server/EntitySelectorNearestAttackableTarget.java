package net.minecraft.server.v1_7_R4;

class EntitySelectorNearestAttackableTarget implements IEntitySelector
{
    final /* synthetic */ IEntitySelector d;
    final /* synthetic */ PathfinderGoalNearestAttackableTarget e;
    
    EntitySelectorNearestAttackableTarget(final PathfinderGoalNearestAttackableTarget e, final IEntitySelector d) {
        this.e = e;
        this.d = d;
    }
    
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof EntityLiving && (this.d == null || this.d.a(entity)) && this.e.a((EntityLiving)entity, false);
    }
}
