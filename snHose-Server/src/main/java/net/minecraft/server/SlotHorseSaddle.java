package net.minecraft.server.v1_7_R4;

class SlotHorseSaddle extends Slot
{
    final /* synthetic */ ContainerHorse a;
    
    SlotHorseSaddle(final ContainerHorse a, final IInventory iinventory, final int i, final int j, final int k) {
        this.a = a;
        super(iinventory, i, j, k);
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemstack) {
        return super.isAllowed(itemstack) && itemstack.getItem() == Items.SADDLE && !this.hasItem();
    }
}
