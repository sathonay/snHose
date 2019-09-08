package net.minecraft.server.v1_7_R4;

final class DispenseBehaviorEgg extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntityEgg(world, position.getX(), position.getY(), position.getZ());
    }
}
