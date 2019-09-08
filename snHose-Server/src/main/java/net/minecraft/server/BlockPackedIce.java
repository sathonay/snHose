package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockPackedIce extends Block
{
    public BlockPackedIce() {
        super(Material.SNOW_LAYER);
        this.frictionFactor = 0.98f;
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int a(final Random random) {
        return 0;
    }
}
