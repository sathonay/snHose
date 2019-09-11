package net.minecraft.server;

import java.util.*;

public class BiomeJungle extends BiomeBase
{
    private boolean aC;
    
    public BiomeJungle(final int i, final boolean ac) {
        super(i);
        this.aC = ac;
        if (ac) {
            this.ar.x = 2;
        }
        else {
            this.ar.x = 50;
        }
        this.ar.z = 25;
        this.ar.y = 4;
        if (!ac) {
            this.as.add(new BiomeMeta(EntityOcelot.class, 2, 1, 1));
        }
        this.at.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if (random.nextInt(10) == 0) {
            return this.aA;
        }
        if (random.nextInt(2) == 0) {
            return new WorldGenGroundBush(3, 0);
        }
        if (!this.aC && random.nextInt(3) == 0) {
            return new WorldGenJungleTree(false, 10, 20, 3, 3);
        }
        return new WorldGenTrees(false, 4 + random.nextInt(7), 3, 3, true);
    }
    
    @Override
    public WorldGenerator b(final Random random) {
        if (random.nextInt(4) == 0) {
            return new WorldGenGrass(Blocks.LONG_GRASS, 2);
        }
        return new WorldGenGrass(Blocks.LONG_GRASS, 1);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        super.a(world, random, i, j);
        final int k = i + random.nextInt(16) + 8;
        final int l = j + random.nextInt(16) + 8;
        new WorldGenMelon().generate(world, random, k, random.nextInt(world.getHighestBlockYAt(k, l) * 2), l);
        final WorldGenVines worldGenVines = new WorldGenVines();
        for (int n = 0; n < 50; ++n) {
            worldGenVines.generate(world, random, i + random.nextInt(16) + 8, 128, j + random.nextInt(16) + 8);
        }
    }
}
