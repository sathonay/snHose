package net.minecraft.server;

public class BlockCloth extends Block
{
    public BlockCloth(final Material material) {
        super(material);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    public static int b(final int n) {
        return c(n);
    }
    
    public static int c(final int n) {
        return ~n & 0xF;
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return MaterialMapColor.a(n);
    }
}
