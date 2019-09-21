package net.minecraft.server;

class SlotEnchant extends Slot
{
    final /* synthetic */ ContainerEnchantTable a;
    
    SlotEnchant(final ContainerEnchantTable a, final IInventory iinventory, final int i, final int j, final int k) {
        super(iinventory, i, j, k);
        this.a = a;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return true;
    }
}
