package net.minecraft.server.v1_7_R4;

final class DispenseBehaviorArrow extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        final EntityArrow entityArrow = new EntityArrow(world, position.getX(), position.getY(), position.getZ());
        entityArrow.fromPlayer = 1;
        return entityArrow;
    }
}
