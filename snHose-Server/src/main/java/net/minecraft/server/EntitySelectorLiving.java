package net.minecraft.server;

final class EntitySelectorLiving implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity.isAlive();
    }
}
