package net.minecraft.server;

class SlotPotionBottle extends Slot
{
    private EntityHuman a;
    
    public SlotPotionBottle(final EntityHuman a, final IInventory iinventory, final int i, final int j, final int k) {
        super(iinventory, i, j, k);
        this.a = a;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return b_(itemStack);
    }
    
    @Override
    public int getMaxStackSize() {
        return 1;
    }
    
    @Override
    public void a(final EntityHuman entityhuman, final ItemStack itemstack) {
        if (itemstack.getItem() == Items.POTION && itemstack.getData() > 0) {
            this.a.a(AchievementList.B, 1);
        }
        super.a(entityhuman, itemstack);
    }
    
    public static boolean b_(final ItemStack itemStack) {
        return itemStack != null && (itemStack.getItem() == Items.POTION || itemStack.getItem() == Items.GLASS_BOTTLE);
    }
}
