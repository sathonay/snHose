package net.minecraft.server.v1_7_R4;

public class SlotMerchantResult extends Slot
{
    private final InventoryMerchant a;
    private EntityHuman b;
    private int c;
    private final IMerchant d;
    
    public SlotMerchantResult(final EntityHuman b, final IMerchant d, final InventoryMerchant inventoryMerchant, final int i, final int j, final int k) {
        super(inventoryMerchant, i, j, k);
        this.b = b;
        this.d = d;
        this.a = inventoryMerchant;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return false;
    }
    
    @Override
    public ItemStack a(final int i) {
        if (this.hasItem()) {
            this.c += Math.min(i, this.getItem().count);
        }
        return super.a(i);
    }
    
    @Override
    protected void a(final ItemStack itemStack, final int n) {
        this.c += n;
        this.b(itemStack);
    }
    
    @Override
    protected void b(final ItemStack itemStack) {
        itemStack.a(this.b.world, this.b, this.c);
        this.c = 0;
    }
    
    @Override
    public void a(final EntityHuman entityHuman, final ItemStack itemStack) {
        this.b(itemStack);
        final MerchantRecipe recipe = this.a.getRecipe();
        if (recipe != null) {
            ItemStack item = this.a.getItem(0);
            ItemStack item2 = this.a.getItem(1);
            if (this.a(recipe, item, item2) || this.a(recipe, item2, item)) {
                this.d.a(recipe);
                if (item != null && item.count <= 0) {
                    item = null;
                }
                if (item2 != null && item2.count <= 0) {
                    item2 = null;
                }
                this.a.setItem(0, item);
                this.a.setItem(1, item2);
            }
        }
    }
    
    private boolean a(final MerchantRecipe merchantRecipe, final ItemStack itemStack, final ItemStack itemStack2) {
        final ItemStack buyItem1 = merchantRecipe.getBuyItem1();
        final ItemStack buyItem2 = merchantRecipe.getBuyItem2();
        if (itemStack != null && itemStack.getItem() == buyItem1.getItem()) {
            if (buyItem2 != null && itemStack2 != null && buyItem2.getItem() == itemStack2.getItem()) {
                itemStack.count -= buyItem1.count;
                itemStack2.count -= buyItem2.count;
                return true;
            }
            if (buyItem2 == null && itemStack2 == null) {
                itemStack.count -= buyItem1.count;
                return true;
            }
        }
        return false;
    }
}
