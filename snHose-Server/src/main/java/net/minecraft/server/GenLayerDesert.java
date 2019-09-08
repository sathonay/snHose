package net.minecraft.server.v1_7_R4;

public class GenLayerDesert extends GenLayer
{
    public GenLayerDesert(final long n, final GenLayer a) {
        super(n);
        this.a = a;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.a.a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                final int n5 = a[j + 1 + (i + 1) * (n3 + 2)];
                if (!this.a(a, a2, j, i, n3, n5, BiomeBase.EXTREME_HILLS.id, BiomeBase.SMALL_MOUNTAINS.id)) {
                    if (!this.b(a, a2, j, i, n3, n5, BiomeBase.MESA_PLATEAU_F.id, BiomeBase.MESA.id)) {
                        if (!this.b(a, a2, j, i, n3, n5, BiomeBase.MESA_PLATEAU.id, BiomeBase.MESA.id)) {
                            if (!this.b(a, a2, j, i, n3, n5, BiomeBase.MEGA_TAIGA.id, BiomeBase.TAIGA.id)) {
                                if (n5 == BiomeBase.DESERT.id) {
                                    final int n6 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                                    final int n7 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                                    final int n8 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                                    final int n9 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                                    if (n6 == BiomeBase.ICE_PLAINS.id || n7 == BiomeBase.ICE_PLAINS.id || n8 == BiomeBase.ICE_PLAINS.id || n9 == BiomeBase.ICE_PLAINS.id) {
                                        a2[j + i * n3] = BiomeBase.EXTREME_HILLS_PLUS.id;
                                    }
                                    else {
                                        a2[j + i * n3] = n5;
                                    }
                                }
                                else if (n5 == BiomeBase.SWAMPLAND.id) {
                                    final int n10 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                                    final int n11 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                                    final int n12 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                                    final int n13 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                                    if (n10 == BiomeBase.DESERT.id || n11 == BiomeBase.DESERT.id || n12 == BiomeBase.DESERT.id || n13 == BiomeBase.DESERT.id || n10 == BiomeBase.COLD_TAIGA.id || n11 == BiomeBase.COLD_TAIGA.id || n12 == BiomeBase.COLD_TAIGA.id || n13 == BiomeBase.COLD_TAIGA.id || n10 == BiomeBase.ICE_PLAINS.id || n11 == BiomeBase.ICE_PLAINS.id || n12 == BiomeBase.ICE_PLAINS.id || n13 == BiomeBase.ICE_PLAINS.id) {
                                        a2[j + i * n3] = BiomeBase.PLAINS.id;
                                    }
                                    else if (n10 == BiomeBase.JUNGLE.id || n13 == BiomeBase.JUNGLE.id || n11 == BiomeBase.JUNGLE.id || n12 == BiomeBase.JUNGLE.id) {
                                        a2[j + i * n3] = BiomeBase.JUNGLE_EDGE.id;
                                    }
                                    else {
                                        a2[j + i * n3] = n5;
                                    }
                                }
                                else {
                                    a2[j + i * n3] = n5;
                                }
                            }
                        }
                    }
                }
            }
        }
        return a2;
    }
    
    private boolean a(final int[] array, final int[] array2, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (GenLayer.a(n4, n5)) {
            final int n7 = array[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
            final int n8 = array[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
            final int n9 = array[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
            final int n10 = array[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
            if (!this.b(n7, n5) || !this.b(n8, n5) || !this.b(n9, n5) || !this.b(n10, n5)) {
                array2[n + n2 * n3] = n6;
            }
            else {
                array2[n + n2 * n3] = n4;
            }
            return true;
        }
        return false;
    }
    
    private boolean b(final int[] array, final int[] array2, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n4 == n5) {
            final int n7 = array[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
            final int n8 = array[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
            final int n9 = array[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
            final int n10 = array[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
            if (!GenLayer.a(n7, n5) || !GenLayer.a(n8, n5) || !GenLayer.a(n9, n5) || !GenLayer.a(n10, n5)) {
                array2[n + n2 * n3] = n6;
            }
            else {
                array2[n + n2 * n3] = n4;
            }
            return true;
        }
        return false;
    }
    
    private boolean b(final int n, final int n2) {
        if (GenLayer.a(n, n2)) {
            return true;
        }
        if (BiomeBase.getBiome(n) != null && BiomeBase.getBiome(n2) != null) {
            final EnumTemperature m = BiomeBase.getBiome(n).m();
            final EnumTemperature i = BiomeBase.getBiome(n2).m();
            return m == i || m == EnumTemperature.MEDIUM || i == EnumTemperature.MEDIUM;
        }
        return false;
    }
}
