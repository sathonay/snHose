package net.minecraft.server.v1_7_R4;

final class EntitySelectorNotUndead implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof EntityLiving && ((EntityLiving)entity).getMonsterType() != EnumMonsterType.UNDEAD;
    }
}
