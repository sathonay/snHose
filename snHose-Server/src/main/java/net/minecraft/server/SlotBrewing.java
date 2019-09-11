package net.minecraft.server;

class SlotBrewing extends Slot
{
    final /* synthetic */ ContainerBrewingStand a;
    
    public SlotBrewing(final ContainerBrewingStand a, final IInventory iinventory, final int i, final int j, final int k) {
        this.a = a;
        super(iinventory, i, j, k);
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemstack) {
        return itemstack != null && itemstack.getItem().m(itemstack);
    }
    
    @Override
    public int getMaxStackSize() {
        return 64;
    }
}
