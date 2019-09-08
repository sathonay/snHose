package net.minecraft.server.v1_7_R4;

final class EntitySelectorLiving implements IEntitySelector
{
    @Override
    public boolean a(final Entity entity) {
        return entity.isAlive();
    }
}
