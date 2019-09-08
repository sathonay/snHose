package net.minecraft.server.v1_7_R4;

final class DispenseBehaviorSnowBall extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntitySnowball(world, position.getX(), position.getY(), position.getZ());
    }
}
