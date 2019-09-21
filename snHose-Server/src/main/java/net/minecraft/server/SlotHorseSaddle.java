package net.minecraft.server;

class SlotHorseSaddle extends Slot
{
    final /* synthetic */ ContainerHorse a;
    
    SlotHorseSaddle(final ContainerHorse a, final IInventory iinventory, final int i, final int j, final int k) {
        super(iinventory, i, j, k);
        this.a = a;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemstack) {
        return super.isAllowed(itemstack) && itemstack.getItem() == Items.SADDLE && !this.hasItem();
    }
}
