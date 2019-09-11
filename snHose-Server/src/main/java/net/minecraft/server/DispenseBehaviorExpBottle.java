package net.minecraft.server;

final class DispenseBehaviorExpBottle extends DispenseBehaviorProjectile
{
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntityThrownExpBottle(world, position.getX(), position.getY(), position.getZ());
    }
    
    @Override
    protected float a() {
        return super.a() * 0.5f;
    }
    
    @Override
    protected float b() {
        return super.b() * 1.25f;
    }
}
