package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockClay extends Block
{
    public BlockClay() {
        super(Material.CLAY);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.CLAY_BALL;
    }
    
    @Override
    public int a(final Random random) {
        return 4;
    }
}
