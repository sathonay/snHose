package net.minecraft.server.v1_7_R4;

class SlotEnchant extends Slot
{
    final /* synthetic */ ContainerEnchantTable a;
    
    SlotEnchant(final ContainerEnchantTable a, final IInventory iinventory, final int i, final int j, final int k) {
        this.a = a;
        super(iinventory, i, j, k);
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return true;
    }
}
