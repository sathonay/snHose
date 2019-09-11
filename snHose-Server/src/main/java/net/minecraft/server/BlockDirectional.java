package net.minecraft.server;

public abstract class BlockDirectional extends Block
{
    protected BlockDirectional(final Material material) {
        super(material);
    }
    
    public static int l(final int n) {
        return n & 0x3;
    }
}
