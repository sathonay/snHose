package net.minecraft.server.v1_7_R4;

public class BlockSmoothBrick extends Block
{
    public static final String[] a;
    public static final String[] b;
    
    public BlockSmoothBrick() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    static {
        a = new String[] { "default", "mossy", "cracked", "chiseled" };
        b = new String[] { null, "mossy", "cracked", "carved" };
    }
}
