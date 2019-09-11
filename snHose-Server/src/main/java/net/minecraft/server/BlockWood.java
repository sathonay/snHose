package net.minecraft.server;

public class BlockWood extends Block
{
    public static final String[] a;
    
    public BlockWood() {
        super(Material.WOOD);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    static {
        a = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "big_oak" };
    }
}
