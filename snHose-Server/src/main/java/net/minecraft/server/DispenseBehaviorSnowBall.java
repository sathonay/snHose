package net.minecraft.server;

final class DispenseBehaviorSnowBall extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntitySnowball(world, position.getX(), position.getY(), position.getZ());
    }
}
