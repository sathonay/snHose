package net.minecraft.server;

public class ItemAnvil extends ItemMultiTexture
{
    public ItemAnvil(final Block block) {
        super(block, block, BlockAnvil.a);
    }
    
    @Override
    public int filterData(final int n) {
        return n << 2;
    }
}
