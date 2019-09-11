package net.minecraft.server;

final class EntitySelectorMonster implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof IMonster;
    }
}
