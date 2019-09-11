package net.minecraft.server;

import java.util.*;

public class BiomeSavannaSub extends BiomeBaseSub
{
    public BiomeSavannaSub(final int n, final BiomeBase biomeBase) {
        super(n, biomeBase);
        this.ar.x = 2;
        this.ar.y = 2;
        this.ar.z = 5;
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        this.ai = Blocks.GRASS;
        this.aj = 0;
        this.ak = Blocks.DIRT;
        if (d0 > 1.75) {
            this.ai = Blocks.STONE;
            this.ak = Blocks.STONE;
        }
        else if (d0 > -0.5) {
            this.ai = Blocks.DIRT;
            this.aj = 1;
        }
        this.b(world, random, ablock, abyte, i, j, d0);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        this.ar.a(world, random, this, i, j);
    }
}
