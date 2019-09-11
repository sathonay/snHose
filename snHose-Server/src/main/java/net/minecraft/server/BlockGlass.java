package net.minecraft.server;

import java.util.*;

public class BlockGlass extends BlockHalfTransparent
{
    public BlockGlass(final Material material, final boolean b) {
        super("glass", material, b);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int a(final Random random) {
        return 0;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    protected boolean E() {
        return true;
    }
}
