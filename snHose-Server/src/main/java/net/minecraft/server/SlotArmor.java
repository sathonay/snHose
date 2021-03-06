package net.minecraft.server;

class SlotArmor extends Slot
{
    final /* synthetic */ int a;
    final /* synthetic */ ContainerPlayer b;
    
    SlotArmor(final ContainerPlayer b, final IInventory iinventory, final int i, final int j, final int k, final int a) {
        super(iinventory, i, j, k);
        this.b = b;
        this.a = a;
    }
    
    @Override
    public int getMaxStackSize() {
        return 1;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.getItem() instanceof ItemArmor) {
            return ((ItemArmor)itemStack.getItem()).b == this.a;
        }
        return (itemStack.getItem() == Item.getItemOf(Blocks.PUMPKIN) || itemStack.getItem() == Items.SKULL) && this.a == 0;
    }
}
