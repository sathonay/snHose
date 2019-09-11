package net.minecraft.server;

public class BlockSand extends BlockFalling
{
    public static final String[] a;
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        if (n == 1) {
            return MaterialMapColor.l;
        }
        return MaterialMapColor.d;
    }
    
    static {
        a = new String[] { "default", "red" };
    }
}
