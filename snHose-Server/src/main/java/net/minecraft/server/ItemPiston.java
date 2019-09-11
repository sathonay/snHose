package net.minecraft.server;

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
