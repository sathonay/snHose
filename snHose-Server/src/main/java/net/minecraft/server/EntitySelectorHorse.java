package net.minecraft.server;

final class EntitySelectorHorse implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof EntityHorse && ((EntityHorse)entity).co();
    }
}
