package net.minecraft.server.v1_7_R4;

public class ItemPiston extends ItemBlock
{
    public ItemPiston(final Block block) {
        super(block);
    }
    
    @Override
    public int filterData(final int n) {
        return 7;
    }
}
