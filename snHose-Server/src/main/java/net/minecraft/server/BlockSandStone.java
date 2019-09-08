package net.minecraft.server.v1_7_R4;

public class BlockSandStone extends Block
{
    public static final String[] a;
    private static final String[] b;
    
    public BlockSandStone() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    static {
        a = new String[] { "default", "chiseled", "smooth" };
        b = new String[] { "normal", "carved", "smooth" };
    }
}
