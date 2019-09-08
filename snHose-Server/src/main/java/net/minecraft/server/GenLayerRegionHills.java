package net.minecraft.server.v1_7_R4;

import org.apache.logging.log4j.*;

public class GenLayerRegionHills extends GenLayer
{
    private static final Logger c;
    private GenLayer d;
    
    public GenLayerRegionHills(final long n, final GenLayer a, final GenLayer d) {
        super(n);
        this.a = a;
        this.d = d;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.a.a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        final int[] a2 = this.d.a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        final int[] a3 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                final int n5 = a[j + 1 + (i + 1) * (n3 + 2)];
                final int n6 = a2[j + 1 + (i + 1) * (n3 + 2)];
                final boolean b = (n6 - 2) % 29 == 0;
                if (n5 > 255) {
                    GenLayerRegionHills.c.debug("old! " + n5);
                }
                if (n5 != 0 && n6 >= 2 && (n6 - 2) % 29 == 1 && n5 < 128) {
                    if (BiomeBase.getBiome(n5 + 128) != null) {
                        a3[j + i * n3] = n5 + 128;
                    }
                    else {
                        a3[j + i * n3] = n5;
                    }
                }
                else if (this.a(3) == 0 || b) {
                    int n7;
                    if ((n7 = n5) == BiomeBase.DESERT.id) {
                        n7 = BiomeBase.DESERT_HILLS.id;
                    }
                    else if (n5 == BiomeBase.FOREST.id) {
                        n7 = BiomeBase.FOREST_HILLS.id;
                    }
                    else if (n5 == BiomeBase.BIRCH_FOREST.id) {
                        n7 = BiomeBase.BIRCH_FOREST_HILLS.id;
                    }
                    else if (n5 == BiomeBase.ROOFED_FOREST.id) {
                        n7 = BiomeBase.PLAINS.id;
                    }
                    else if (n5 == BiomeBase.TAIGA.id) {
                        n7 = BiomeBase.TAIGA_HILLS.id;
                    }
                    else if (n5 == BiomeBase.MEGA_TAIGA.id) {
                        n7 = BiomeBase.MEGA_TAIGA_HILLS.id;
                    }
                    else if (n5 == BiomeBase.COLD_TAIGA.id) {
                        n7 = BiomeBase.COLD_TAIGA_HILLS.id;
                    }
                    else if (n5 == BiomeBase.PLAINS.id) {
                        if (this.a(3) == 0) {
                            n7 = BiomeBase.FOREST_HILLS.id;
                        }
                        else {
                            n7 = BiomeBase.FOREST.id;
                        }
                    }
                    else if (n5 == BiomeBase.ICE_PLAINS.id) {
                        n7 = BiomeBase.ICE_MOUNTAINS.id;
                    }
                    else if (n5 == BiomeBase.JUNGLE.id) {
                        n7 = BiomeBase.JUNGLE_HILLS.id;
                    }
                    else if (n5 == BiomeBase.OCEAN.id) {
                        n7 = BiomeBase.DEEP_OCEAN.id;
                    }
                    else if (n5 == BiomeBase.EXTREME_HILLS.id) {
                        n7 = BiomeBase.EXTREME_HILLS_PLUS.id;
                    }
                    else if (n5 == BiomeBase.SAVANNA.id) {
                        n7 = BiomeBase.SAVANNA_PLATEAU.id;
                    }
                    else if (GenLayer.a(n5, BiomeBase.MESA_PLATEAU_F.id)) {
                        n7 = BiomeBase.MESA.id;
                    }
                    else if (n5 == BiomeBase.DEEP_OCEAN.id && this.a(3) == 0) {
                        if (this.a(2) == 0) {
                            n7 = BiomeBase.PLAINS.id;
                        }
                        else {
                            n7 = BiomeBase.FOREST.id;
                        }
                    }
                    if (b && n7 != n5) {
                        if (BiomeBase.getBiome(n7 + 128) != null) {
                            n7 += 128;
                        }
                        else {
                            n7 = n5;
                        }
                    }
                    if (n7 == n5) {
                        a3[j + i * n3] = n5;
                    }
                    else {
                        final int n8 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                        final int n9 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                        final int n10 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                        final int n11 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                        int n12 = 0;
                        if (GenLayer.a(n8, n5)) {
                            ++n12;
                        }
                        if (GenLayer.a(n9, n5)) {
                            ++n12;
                        }
                        if (GenLayer.a(n10, n5)) {
                            ++n12;
                        }
                        if (GenLayer.a(n11, n5)) {
                            ++n12;
                        }
                        if (n12 >= 3) {
                            a3[j + i * n3] = n7;
                        }
                        else {
                            a3[j + i * n3] = n5;
                        }
                    }
                }
                else {
                    a3[j + i * n3] = n5;
                }
            }
        }
        return a3;
    }
    
    static {
        c = LogManager.getLogger();
    }
}
