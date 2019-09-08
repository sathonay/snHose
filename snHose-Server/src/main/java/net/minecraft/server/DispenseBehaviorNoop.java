package net.minecraft.server.v1_7_R4;

final class DispenseBehaviorNoop implements IDispenseBehavior
{
    @Override
    public ItemStack a(final ISourceBlock sourceBlock, final ItemStack itemStack) {
        return itemStack;
    }
}
