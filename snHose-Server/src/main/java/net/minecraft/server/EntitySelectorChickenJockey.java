package net.minecraft.server;

final class EntitySelectorChickenJockey implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity.isAlive() && entity.passenger == null && entity.vehicle == null;
    }
}
