package net.minecraft.server.v1_7_R4;

final class EntitySelectorContainer implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity instanceof IInventory && entity.isAlive();
    }
}
