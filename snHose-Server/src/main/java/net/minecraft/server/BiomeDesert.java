package net.minecraft.server;

import java.util.*;

public class BiomeDesert extends BiomeBase
{
    public BiomeDesert(final int i) {
        super(i);
        this.at.clear();
        this.ai = Blocks.SAND;
        this.ak = Blocks.SAND;
        this.ar.x = -999;
        this.ar.A = 2;
        this.ar.C = 50;
        this.ar.D = 10;
        this.at.clear();
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        super.a(world, random, i, j);
        if (random.nextInt(1000) == 0) {
            final int k = i + random.nextInt(16) + 8;
            final int l = j + random.nextInt(16) + 8;
            new WorldGenDesertWell().generate(world, random, k, world.getHighestBlockYAt(k, l) + 1, l);
        }
    }
}
