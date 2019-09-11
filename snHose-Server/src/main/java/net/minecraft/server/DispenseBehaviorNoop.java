package net.minecraft.server;

final class DispenseBehaviorNoop implements IDispenseBehavior
{
    @Override
    public ItemStack a(final ISourceBlock sourceBlock, final ItemStack itemStack) {
        return itemStack;
    }
}
