package net.minecraft.server.v1_7_R4;

public class ItemMultiTexture extends ItemBlock
{
    protected final Block b;
    protected final String[] c;
    
    public ItemMultiTexture(final Block block, final Block b, final String[] c) {
        super(block);
        this.b = b;
        this.c = c;
        this.setMaxDurability(0);
        this.a(true);
    }
    
    @Override
    public int filterData(final int n) {
        return n;
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        int data = itemStack.getData();
        if (data < 0 || data >= this.c.length) {
            data = 0;
        }
        return super.getName() + "." + this.c[data];
    }
}
