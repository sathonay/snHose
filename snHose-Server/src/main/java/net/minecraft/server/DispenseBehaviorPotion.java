package net.minecraft.server.v1_7_R4;

final class DispenseBehaviorPotion implements IDispenseBehavior
{
    private final DispenseBehaviorItem b;
    
    DispenseBehaviorPotion() {
        this.b = new DispenseBehaviorItem();
    }
    
    @Override
    public ItemStack a(final ISourceBlock sourceBlock, final ItemStack itemStack) {
        if (ItemPotion.g(itemStack.getData())) {
            return new DispenseBehaviorThrownPotion(this, itemStack).a(sourceBlock, itemStack);
        }
        return this.b.a(sourceBlock, itemStack);
    }
}
