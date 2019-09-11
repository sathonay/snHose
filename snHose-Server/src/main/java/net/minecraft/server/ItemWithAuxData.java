package net.minecraft.server;

public class ItemWithAuxData extends ItemBlock
{
    private final Block b;
    private String[] c;
    
    public ItemWithAuxData(final Block block, final boolean b) {
        super(block);
        this.b = block;
        if (b) {
            this.setMaxDurability(0);
            this.a(true);
        }
    }
    
    @Override
    public int filterData(final int n) {
        return n;
    }
    
    public ItemWithAuxData a(final String[] c) {
        this.c = c;
        return this;
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        if (this.c == null) {
            return super.a(itemStack);
        }
        final int data = itemStack.getData();
        if (data >= 0 && data < this.c.length) {
            return super.a(itemStack) + "." + this.c[data];
        }
        return super.a(itemStack);
    }
}
