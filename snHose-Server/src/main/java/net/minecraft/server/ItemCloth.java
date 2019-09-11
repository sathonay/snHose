package net.minecraft.server;

public class ItemCloth extends ItemBlock
{
    public ItemCloth(final Block block) {
        super(block);
        this.setMaxDurability(0);
        this.a(true);
    }
    
    @Override
    public int filterData(final int n) {
        return n;
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        return super.getName() + "." + ItemDye.a[BlockCloth.b(itemStack.getData())];
    }
}
