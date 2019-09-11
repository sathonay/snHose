package net.minecraft.server;

import java.util.concurrent.*;

public abstract class GenLayer
{
    private long c;
    protected GenLayer a;
    private long d;
    protected long b;
    
    public static GenLayer[] a(final long n, final WorldType worldType) {
        final boolean b = false;
        final GenLayer b2 = GenLayerZoom.b(1000L, new GenLayerDeepOcean(4L, new GenLayerMushroomIsland(5L, new GenLayerIsland(4L, new GenLayerZoom(2003L, new GenLayerZoom(2002L, new GenLayerSpecial(3L, new GenLayerSpecial(2L, new GenLayerSpecial(2L, new GenLayerIsland(3L, new GenLayerTopSoil(2L, new GenLayerIcePlains(2L, new GenLayerIsland(70L, new GenLayerIsland(50L, new GenLayerIsland(2L, new GenLayerZoom(2001L, new GenLayerIsland(1L, new GenLayerZoomFuzzy(2000L, new LayerIsland(1L)))))))))), EnumGenLayerSpecial.COOL_WARM), EnumGenLayerSpecial.HEAT_ICE), EnumGenLayerSpecial.PUFFERFISH)))))), 0);
        int n2 = 4;
        if (worldType == WorldType.LARGE_BIOMES) {
            n2 = 6;
        }
        if (b) {
            n2 = 4;
        }
        final GenLayerCleaner genLayerCleaner = new GenLayerCleaner(100L, GenLayerZoom.b(1000L, b2, 0));
        GenLayer genLayer = new GenLayerBiome(200L, b2, worldType);
        if (!b) {
            genLayer = new GenLayerDesert(1000L, GenLayerZoom.b(1000L, genLayer, 2));
        }
        final GenLayerRegionHills genLayerRegionHills = new GenLayerRegionHills(1000L, genLayer, GenLayerZoom.b(1000L, genLayerCleaner, 2));
        final GenLayerSmooth genLayerSmooth = new GenLayerSmooth(1000L, new GenLayerRiver(1L, GenLayerZoom.b(1000L, GenLayerZoom.b(1000L, genLayerCleaner, 2), n2)));
        GenLayer genLayer2 = new GenLayerPlains(1001L, genLayerRegionHills);
        for (int i = 0; i < n2; ++i) {
            genLayer2 = new GenLayerZoom(1000 + i, genLayer2);
            if (i == 0) {
                genLayer2 = new GenLayerIsland(3L, genLayer2);
            }
            if (i == 1) {
                genLayer2 = new GenLayerMushroomShore(1000L, genLayer2);
            }
        }
        final GenLayerRiverMix genLayerRiverMix2;
        final GenLayerRiverMix genLayerRiverMix = genLayerRiverMix2 = new GenLayerRiverMix(100L, new GenLayerSmooth(1000L, genLayer2), genLayerSmooth);
        final GenLayerZoomVoronoi genLayerZoomVoronoi = new GenLayerZoomVoronoi(10L, genLayerRiverMix);
        genLayerRiverMix.a(n);
        genLayerZoomVoronoi.a(n);
        return new GenLayer[] { genLayerRiverMix, genLayerZoomVoronoi, genLayerRiverMix2 };
    }
    
    public GenLayer(final long b) {
        this.b = b;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += b;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += b;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += b;
    }
    
    public void a(final long c) {
        this.c = c;
        if (this.a != null) {
            this.a.a(c);
        }
        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
    }
    
    public void a(final long n, final long n2) {
        this.d = this.c;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += n;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += n2;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += n;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += n2;
    }
    
    protected int a(final int n) {
        int n2 = (int)((this.d >> 24) % n);
        if (n2 < 0) {
            n2 += n;
        }
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += this.c;
        return n2;
    }
    
    public abstract int[] a(final int p0, final int p1, final int p2, final int p3);
    
    protected static boolean a(final int n, final int n2) {
        if (n == n2) {
            return true;
        }
        if (n == BiomeBase.MESA_PLATEAU_F.id || n == BiomeBase.MESA_PLATEAU.id) {
            return n2 == BiomeBase.MESA_PLATEAU_F.id || n2 == BiomeBase.MESA_PLATEAU.id;
        }
        try {
            if (BiomeBase.getBiome(n) != null && BiomeBase.getBiome(n2) != null) {
                return BiomeBase.getBiome(n).a(BiomeBase.getBiome(n2));
            }
        }
        catch (Throwable throwable) {
            final CrashReport a = CrashReport.a(throwable, "Comparing biomes");
            final CrashReportSystemDetails a2 = a.a("Biomes being compared");
            a2.a("Biome A ID", n);
            a2.a("Biome B ID", n2);
            a2.a("Biome A", new CrashReportGenLayer1(n));
            a2.a("Biome B", new CrashReportGenLayer2(n2));
            throw new ReportedException(a);
        }
        return false;
    }
    
    protected static boolean b(final int n) {
        return n == BiomeBase.OCEAN.id || n == BiomeBase.DEEP_OCEAN.id || n == BiomeBase.FROZEN_OCEAN.id;
    }
    
    protected int a(final int... array) {
        return array[this.a(array.length)];
    }
    
    protected int b(final int n, final int n2, final int n3, final int n4) {
        if (n2 == n3 && n3 == n4) {
            return n2;
        }
        if (n == n2 && n == n3) {
            return n;
        }
        if (n == n2 && n == n4) {
            return n;
        }
        if (n == n3 && n == n4) {
            return n;
        }
        if (n == n2 && n3 != n4) {
            return n;
        }
        if (n == n3 && n2 != n4) {
            return n;
        }
        if (n == n4 && n2 != n3) {
            return n;
        }
        if (n2 == n3 && n != n4) {
            return n2;
        }
        if (n2 == n4 && n != n3) {
            return n2;
        }
        if (n3 == n4 && n != n2) {
            return n3;
        }
        return this.a(new int[] { n, n2, n3, n4 });
    }
}
