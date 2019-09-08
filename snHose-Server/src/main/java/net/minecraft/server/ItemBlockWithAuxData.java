package net.minecraft.server.v1_7_R4;

public class ItemBlockWithAuxData extends ItemBlock
{
    private Block b;
    
    public ItemBlockWithAuxData(final Block block, final Block b) {
        super(block);
        this.b = b;
        this.setMaxDurability(0);
        this.a(true);
    }
    
    @Override
    public int filterData(final int n) {
        return n;
    }
}
