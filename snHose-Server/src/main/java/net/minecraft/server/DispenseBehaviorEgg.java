package net.minecraft.server;

final class DispenseBehaviorEgg extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntityEgg(world, position.getX(), position.getY(), position.getZ());
    }
}
