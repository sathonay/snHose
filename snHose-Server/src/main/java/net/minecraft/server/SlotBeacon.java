package net.minecraft.server.v1_7_R4;

class SlotBeacon extends Slot
{
    final /* synthetic */ ContainerBeacon a;
    
    public SlotBeacon(final ContainerBeacon a, final IInventory iinventory, final int i, final int j, final int k) {
        this.a = a;
        super(iinventory, i, j, k);
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return itemStack != null && (itemStack.getItem() == Items.EMERALD || itemStack.getItem() == Items.DIAMOND || itemStack.getItem() == Items.GOLD_INGOT || itemStack.getItem() == Items.IRON_INGOT);
    }
    
    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
