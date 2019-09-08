package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldChunkManagerHell extends WorldChunkManager
{
    private BiomeBase c;
    private float d;
    
    public WorldChunkManagerHell(final BiomeBase c, final float d) {
        this.c = c;
        this.d = d;
    }
    
    @Override
    public BiomeBase getBiome(final int n, final int n2) {
        return this.c;
    }
    
    @Override
    public BiomeBase[] getBiomes(BiomeBase[] array, final int n, final int n2, final int n3, final int n4) {
        if (array == null || array.length < n3 * n4) {
            array = new BiomeBase[n3 * n4];
        }
        Arrays.fill(array, 0, n3 * n4, this.c);
        return array;
    }
    
    @Override
    public float[] getWetness(float[] array, final int n, final int n2, final int n3, final int n4) {
        if (array == null || array.length < n3 * n4) {
            array = new float[n3 * n4];
        }
        Arrays.fill(array, 0, n3 * n4, this.d);
        return array;
    }
    
    @Override
    public BiomeBase[] getBiomeBlock(BiomeBase[] array, final int n, final int n2, final int n3, final int n4) {
        if (array == null || array.length < n3 * n4) {
            array = new BiomeBase[n3 * n4];
        }
        Arrays.fill(array, 0, n3 * n4, this.c);
        return array;
    }
    
    @Override
    public BiomeBase[] a(final BiomeBase[] array, final int n, final int n2, final int n3, final int n4, final boolean b) {
        return this.getBiomeBlock(array, n, n2, n3, n4);
    }
    
    @Override
    public ChunkPosition a(final int n, final int n2, final int n3, final List list, final Random random) {
        if (list.contains(this.c)) {
            return new ChunkPosition(n - n3 + random.nextInt(n3 * 2 + 1), 0, n2 - n3 + random.nextInt(n3 * 2 + 1));
        }
        return null;
    }
    
    @Override
    public boolean a(final int n, final int n2, final int n3, final List list) {
        return list.contains(this.c);
    }
}
