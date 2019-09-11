package net.minecraft.server;

import java.util.*;

public class BiomeOcean extends BiomeBase
{
    public BiomeOcean(final int i) {
        super(i);
        this.at.clear();
    }
    
    @Override
    public EnumTemperature m() {
        return EnumTemperature.OCEAN;
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        super.a(world, random, ablock, abyte, i, j, d0);
    }
}
