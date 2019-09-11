package net.minecraft.server;

final class EntitySelectorContainer implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof IInventory && entity.isAlive();
    }
}
