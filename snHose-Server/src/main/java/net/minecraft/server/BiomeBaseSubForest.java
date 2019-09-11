package net.minecraft.server;

import java.util.*;

class BiomeBaseSubForest extends BiomeBaseSub
{
    final /* synthetic */ BiomeForest aC;
    
    BiomeBaseSubForest(final BiomeForest ac, final int n, final BiomeBase biomeBase) {
        this.aC = ac;
        super(n, biomeBase);
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if (random.nextBoolean()) {
            return BiomeForest.aC;
        }
        return BiomeForest.aD;
    }
}
