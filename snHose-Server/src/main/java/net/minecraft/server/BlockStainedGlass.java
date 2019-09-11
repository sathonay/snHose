package net.minecraft.server;

import java.util.*;

public class BlockStainedGlass extends BlockHalfTransparent
{
    private static final IIcon[] a;
    
    public BlockStainedGlass(final Material material) {
        super("glass", material, false);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    @Override
    public int a(final Random random) {
        return 0;
    }
    
    @Override
    protected boolean E() {
        return true;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    static {
        a = new IIcon[16];
    }
}
