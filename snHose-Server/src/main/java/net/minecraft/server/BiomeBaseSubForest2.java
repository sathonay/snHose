package net.minecraft.server.v1_7_R4;

import java.util.*;

class BiomeBaseSubForest2 extends BiomeBaseSub
{
    final /* synthetic */ BiomeForest aC;
    
    BiomeBaseSubForest2(final BiomeForest ac, final int n, final BiomeBase biomeBase) {
        this.aC = ac;
        super(n, biomeBase);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        this.aD.a(world, random, i, j);
    }
}
