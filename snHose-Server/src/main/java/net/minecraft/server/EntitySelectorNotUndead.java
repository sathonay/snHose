package net.minecraft.server;

final class EntitySelectorNotUndead implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof EntityLiving && ((EntityLiving)entity).getMonsterType() != EnumMonsterType.UNDEAD;
    }
}
