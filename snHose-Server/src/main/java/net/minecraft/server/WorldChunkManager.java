package net.minecraft.server;

import java.util.*;

public class WorldChunkManager
{
    private GenLayer c;
    private GenLayer d;
    private BiomeCache e;
    private List f;
    
    protected WorldChunkManager() {
        this.e = new BiomeCache(this);
        (this.f = new ArrayList()).add(BiomeBase.FOREST);
        this.f.add(BiomeBase.PLAINS);
        this.f.add(BiomeBase.TAIGA);
        this.f.add(BiomeBase.TAIGA_HILLS);
        this.f.add(BiomeBase.FOREST_HILLS);
        this.f.add(BiomeBase.JUNGLE);
        this.f.add(BiomeBase.JUNGLE_HILLS);
    }
    
    public WorldChunkManager(final long n, final WorldType worldType) {
        this();
        final GenLayer[] a = GenLayer.a(n, worldType);
        this.c = a[0];
        this.d = a[1];
    }
    
    public WorldChunkManager(final World world) {
        this(world.getSeed(), world.getWorldData().getType());
    }
    
    public List a() {
        return this.f;
    }
    
    public BiomeBase getBiome(final int n, final int n2) {
        return this.e.b(n, n2);
    }
    
    public float[] getWetness(float[] array, final int n, final int n2, final int n3, final int n4) {
        IntCache.a();
        if (array == null || array.length < n3 * n4) {
            array = new float[n3 * n4];
        }
        final int[] a = this.d.a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            try {
                float n5 = BiomeBase.getBiome(a[i]).h() / 65536.0f;
                if (n5 > 1.0f) {
                    n5 = 1.0f;
                }
                array[i] = n5;
            }
            catch (Throwable throwable) {
                final CrashReport a2 = CrashReport.a(throwable, "Invalid Biome id");
                final CrashReportSystemDetails a3 = a2.a("DownfallBlock");
                a3.a("biome id", i);
                a3.a("downfalls[] size", array.length);
                a3.a("x", n);
                a3.a("z", n2);
                a3.a("w", n3);
                a3.a("h", n4);
                throw new ReportedException(a2);
            }
        }
        return array;
    }
    
    public BiomeBase[] getBiomes(BiomeBase[] array, final int n, final int n2, final int n3, final int n4) {
        IntCache.a();
        if (array == null || array.length < n3 * n4) {
            array = new BiomeBase[n3 * n4];
        }
        final int[] a = this.c.a(n, n2, n3, n4);
        try {
            for (int i = 0; i < n3 * n4; ++i) {
                array[i] = BiomeBase.getBiome(a[i]);
            }
        }
        catch (Throwable throwable) {
            final CrashReport a2 = CrashReport.a(throwable, "Invalid Biome id");
            final CrashReportSystemDetails a3 = a2.a("RawBiomeBlock");
            a3.a("biomes[] size", array.length);
            a3.a("x", n);
            a3.a("z", n2);
            a3.a("w", n3);
            a3.a("h", n4);
            throw new ReportedException(a2);
        }
        return array;
    }
    
    public BiomeBase[] getBiomeBlock(final BiomeBase[] array, final int n, final int n2, final int n3, final int n4) {
        return this.a(array, n, n2, n3, n4, true);
    }
    
    public BiomeBase[] a(BiomeBase[] array, final int n, final int n2, final int n3, final int n4, final boolean b) {
        IntCache.a();
        if (array == null || array.length < n3 * n4) {
            array = new BiomeBase[n3 * n4];
        }
        if (b && n3 == 16 && n4 == 16 && (n & 0xF) == 0x0 && (n2 & 0xF) == 0x0) {
            System.arraycopy(this.e.d(n, n2), 0, array, 0, n3 * n4);
            return array;
        }
        final int[] a = this.d.a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            array[i] = BiomeBase.getBiome(a[i]);
        }
        return array;
    }
    
    public boolean a(final int n, final int n2, final int n3, final List list) {
        IntCache.a();
        final int n4 = n - n3 >> 2;
        final int n5 = n2 - n3 >> 2;
        final int n6 = n + n3 >> 2;
        final int n7 = n2 + n3 >> 2;
        final int n8 = n6 - n4 + 1;
        final int n9 = n7 - n5 + 1;
        final int[] a = this.c.a(n4, n5, n8, n9);
        try {
            for (int i = 0; i < n8 * n9; ++i) {
                if (!list.contains(BiomeBase.getBiome(a[i]))) {
                    return false;
                }
            }
        }
        catch (Throwable throwable) {
            final CrashReport a2 = CrashReport.a(throwable, "Invalid Biome id");
            final CrashReportSystemDetails a3 = a2.a("Layer");
            a3.a("Layer", this.c.toString());
            a3.a("x", n);
            a3.a("z", n2);
            a3.a("radius", n3);
            a3.a("allowed", list);
            throw new ReportedException(a2);
        }
        return true;
    }
    
    public ChunkPosition a(final int n, final int n2, final int n3, final List list, final Random random) {
        IntCache.a();
        final int n4 = n - n3 >> 2;
        final int n5 = n2 - n3 >> 2;
        final int n6 = n + n3 >> 2;
        final int n7 = n2 + n3 >> 2;
        final int n8 = n6 - n4 + 1;
        final int n9 = n7 - n5 + 1;
        final int[] a = this.c.a(n4, n5, n8, n9);
        ChunkPosition chunkPosition = null;
        int n10 = 0;
        for (int i = 0; i < n8 * n9; ++i) {
            final int n11 = n4 + i % n8 << 2;
            final int n12 = n5 + i / n8 << 2;
            if (list.contains(BiomeBase.getBiome(a[i])) && (chunkPosition == null || random.nextInt(n10 + 1) == 0)) {
                chunkPosition = new ChunkPosition(n11, 0, n12);
                ++n10;
            }
        }
        return chunkPosition;
    }
    
    public void b() {
        this.e.a();
    }
}
