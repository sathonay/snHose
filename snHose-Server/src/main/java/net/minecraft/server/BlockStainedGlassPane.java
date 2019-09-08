package net.minecraft.server.v1_7_R4;

public class BlockStainedGlassPane extends BlockThin
{
    private static final IIcon[] a;
    private static final IIcon[] b;
    
    public BlockStainedGlassPane() {
        super("glass", "glass_pane_top", Material.SHATTERABLE, false);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    static {
        a = new IIcon[16];
        b = new IIcon[16];
    }
}
