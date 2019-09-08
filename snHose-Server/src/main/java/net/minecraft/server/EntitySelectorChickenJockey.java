package net.minecraft.server.v1_7_R4;

final class EntitySelectorChickenJockey implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity.isAlive() && entity.passenger == null && entity.vehicle == null;
    }
}
