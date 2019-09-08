package net.minecraft.server.v1_7_R4;

public class GenLayerMushroomShore extends GenLayer
{
    public GenLayerMushroomShore(final long n, final GenLayer a) {
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
                final int k = a[j + 1 + (i + 1) * (n3 + 2)];
                final BiomeBase biome = BiomeBase.getBiome(k);
                if (k == BiomeBase.MUSHROOM_ISLAND.id) {
                    final int n5 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    final int n6 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    final int n7 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    final int n8 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n5 == BiomeBase.OCEAN.id || n6 == BiomeBase.OCEAN.id || n7 == BiomeBase.OCEAN.id || n8 == BiomeBase.OCEAN.id) {
                        a2[j + i * n3] = BiomeBase.MUSHROOM_SHORE.id;
                    }
                    else {
                        a2[j + i * n3] = k;
                    }
                }
                else if (biome != null && biome.l() == BiomeJungle.class) {
                    final int n9 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    final int n10 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    final int n11 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    final int n12 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (!this.c(n9) || !this.c(n10) || !this.c(n11) || !this.c(n12)) {
                        a2[j + i * n3] = BiomeBase.JUNGLE_EDGE.id;
                    }
                    else if (GenLayer.b(n9) || GenLayer.b(n10) || GenLayer.b(n11) || GenLayer.b(n12)) {
                        a2[j + i * n3] = BiomeBase.BEACH.id;
                    }
                    else {
                        a2[j + i * n3] = k;
                    }
                }
                else if (k == BiomeBase.EXTREME_HILLS.id || k == BiomeBase.EXTREME_HILLS_PLUS.id || k == BiomeBase.SMALL_MOUNTAINS.id) {
                    this.a(a, a2, j, i, n3, k, BiomeBase.STONE_BEACH.id);
                }
                else if (biome != null && biome.j()) {
                    this.a(a, a2, j, i, n3, k, BiomeBase.COLD_BEACH.id);
                }
                else if (k == BiomeBase.MESA.id || k == BiomeBase.MESA_PLATEAU_F.id) {
                    final int n13 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    final int n14 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    final int n15 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    final int n16 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (GenLayer.b(n13) || GenLayer.b(n14) || GenLayer.b(n15) || GenLayer.b(n16)) {
                        a2[j + i * n3] = k;
                    }
                    else if (!this.d(n13) || !this.d(n14) || !this.d(n15) || !this.d(n16)) {
                        a2[j + i * n3] = BiomeBase.DESERT.id;
                    }
                    else {
                        a2[j + i * n3] = k;
                    }
                }
                else if (k != BiomeBase.OCEAN.id && k != BiomeBase.DEEP_OCEAN.id && k != BiomeBase.RIVER.id && k != BiomeBase.SWAMPLAND.id) {
                    final int n17 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    final int n18 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    final int n19 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    final int n20 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (GenLayer.b(n17) || GenLayer.b(n18) || GenLayer.b(n19) || GenLayer.b(n20)) {
                        a2[j + i * n3] = BiomeBase.BEACH.id;
                    }
                    else {
                        a2[j + i * n3] = k;
                    }
                }
                else {
                    a2[j + i * n3] = k;
                }
            }
        }
        return a2;
    }
    
    private void a(final int[] array, final int[] array2, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (GenLayer.b(n4)) {
            array2[n + n2 * n3] = n4;
            return;
        }
        final int n6 = array[n + 1 + (n2 + 1 - 1) * (n3 + 2)];
        final int n7 = array[n + 1 + 1 + (n2 + 1) * (n3 + 2)];
        final int n8 = array[n + 1 - 1 + (n2 + 1) * (n3 + 2)];
        final int n9 = array[n + 1 + (n2 + 1 + 1) * (n3 + 2)];
        if (GenLayer.b(n6) || GenLayer.b(n7) || GenLayer.b(n8) || GenLayer.b(n9)) {
            array2[n + n2 * n3] = n5;
        }
        else {
            array2[n + n2 * n3] = n4;
        }
    }
    
    private boolean c(final int n) {
        return (BiomeBase.getBiome(n) != null && BiomeBase.getBiome(n).l() == BiomeJungle.class) || n == BiomeBase.JUNGLE_EDGE.id || n == BiomeBase.JUNGLE.id || n == BiomeBase.JUNGLE_HILLS.id || n == BiomeBase.FOREST.id || n == BiomeBase.TAIGA.id || GenLayer.b(n);
    }
    
    private boolean d(final int n) {
        return BiomeBase.getBiome(n) != null && BiomeBase.getBiome(n) instanceof BiomeMesa;
    }
}
