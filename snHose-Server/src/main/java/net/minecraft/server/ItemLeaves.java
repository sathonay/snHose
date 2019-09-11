package net.minecraft.server;

public class ItemLeaves extends ItemBlock
{
    private final BlockLeaves b;
    
    public ItemLeaves(final BlockLeaves blockLeaves) {
        super(blockLeaves);
        this.b = blockLeaves;
        this.setMaxDurability(0);
        this.a(true);
    }
    
    @Override
    public int filterData(final int n) {
        return n | 0x4;
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        int data = itemStack.getData();
        if (data < 0 || data >= this.b.e().length) {
            data = 0;
        }
        return super.getName() + "." + this.b.e()[data];
    }
}
