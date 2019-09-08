package net.minecraft.server.v1_7_R4;

class DispenseBehaviorThrownPotion extends DispenseBehaviorProjectile
{
    final /* synthetic */ ItemStack b;
    final /* synthetic */ DispenseBehaviorPotion c;
    
    DispenseBehaviorThrownPotion(final DispenseBehaviorPotion c, final ItemStack b) {
        this.c = c;
        this.b = b;
    }
    
    @Override
    protected IProjectile a(final World world, final IPosition position) {
        return new EntityPotion(world, position.getX(), position.getY(), position.getZ(), this.b.cloneItemStack());
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
