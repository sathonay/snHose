package net.minecraft.server.v1_7_R4;

public class SlotResult extends Slot
{
    private final IInventory a;
    private EntityHuman b;
    private int c;
    
    public SlotResult(final EntityHuman b, final IInventory a, final IInventory iinventory, final int i, final int j, final int k) {
        super(iinventory, i, j, k);
        this.b = b;
        this.a = a;
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
        if (itemStack.getItem() == Item.getItemOf(Blocks.WORKBENCH)) {
            this.b.a(AchievementList.h, 1);
        }
        if (itemStack.getItem() instanceof ItemPickaxe) {
            this.b.a(AchievementList.i, 1);
        }
        if (itemStack.getItem() == Item.getItemOf(Blocks.FURNACE)) {
            this.b.a(AchievementList.j, 1);
        }
        if (itemStack.getItem() instanceof ItemHoe) {
            this.b.a(AchievementList.l, 1);
        }
        if (itemStack.getItem() == Items.BREAD) {
            this.b.a(AchievementList.m, 1);
        }
        if (itemStack.getItem() == Items.CAKE) {
            this.b.a(AchievementList.n, 1);
        }
        if (itemStack.getItem() instanceof ItemPickaxe && ((ItemPickaxe)itemStack.getItem()).i() != EnumToolMaterial.WOOD) {
            this.b.a(AchievementList.o, 1);
        }
        if (itemStack.getItem() instanceof ItemSword) {
            this.b.a(AchievementList.r, 1);
        }
        if (itemStack.getItem() == Item.getItemOf(Blocks.ENCHANTMENT_TABLE)) {
            this.b.a(AchievementList.E, 1);
        }
        if (itemStack.getItem() == Item.getItemOf(Blocks.BOOKSHELF)) {
            this.b.a(AchievementList.G, 1);
        }
    }
    
    @Override
    public void a(final EntityHuman entityHuman, final ItemStack itemStack) {
        this.b(itemStack);
        for (int i = 0; i < this.a.getSize(); ++i) {
            final ItemStack item = this.a.getItem(i);
            if (item != null) {
                this.a.splitStack(i, 1);
                if (item.getItem().u()) {
                    final ItemStack itemStack2 = new ItemStack(item.getItem().t());
                    if (!item.getItem().l(item) || !this.b.inventory.pickup(itemStack2)) {
                        if (this.a.getItem(i) == null) {
                            this.a.setItem(i, itemStack2);
                        }
                        else {
                            this.b.drop(itemStack2, false);
                        }
                    }
                }
            }
        }
    }
}
