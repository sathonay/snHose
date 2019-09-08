package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenLargeFeatureStart extends StructureStart
{
    public WorldGenLargeFeatureStart() {
    }
    
    public WorldGenLargeFeatureStart(final World world, final Random random, final int n, final int n2) {
        super(n, n2);
        final BiomeBase biome = world.getBiome(n * 16 + 8, n2 * 16 + 8);
        if (biome == BiomeBase.JUNGLE || biome == BiomeBase.JUNGLE_HILLS) {
            this.a.add(new WorldGenJungleTemple(random, n * 16, n2 * 16));
        }
        else if (biome == BiomeBase.SWAMPLAND) {
            this.a.add(new WorldGenWitchHut(random, n * 16, n2 * 16));
        }
        else {
            this.a.add(new WorldGenPyramidPiece(random, n * 16, n2 * 16));
        }
        this.c();
    }
}
