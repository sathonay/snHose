package net.minecraft.server;

public class GenLayerBiome extends GenLayer
{
    private BiomeBase[] c;
    private BiomeBase[] d;
    private BiomeBase[] e;
    private BiomeBase[] f;
    
    public GenLayerBiome(final long n, final GenLayer a, final WorldType worldType) {
        super(n);
        this.c = new BiomeBase[] { BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.SAVANNA, BiomeBase.SAVANNA, BiomeBase.PLAINS };
        this.d = new BiomeBase[] { BiomeBase.FOREST, BiomeBase.ROOFED_FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.PLAINS, BiomeBase.BIRCH_FOREST, BiomeBase.SWAMPLAND };
        this.e = new BiomeBase[] { BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.TAIGA, BiomeBase.PLAINS };
        this.f = new BiomeBase[] { BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.COLD_TAIGA };
        this.a = a;
        if (worldType == WorldType.NORMAL_1_1) {
            this.c = new BiomeBase[] { BiomeBase.DESERT, BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.SWAMPLAND, BiomeBase.PLAINS, BiomeBase.TAIGA };
        }
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.a.a(n, n2, n3, n4);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                final int n5 = a[j + i * n3];
                final int n6 = (n5 & 0xF00) >> 8;
                final int n7 = n5 & 0xFFFFF0FF;
                if (GenLayer.b(n7)) {
                    a2[j + i * n3] = n7;
                }
                else if (n7 == BiomeBase.MUSHROOM_ISLAND.id) {
                    a2[j + i * n3] = n7;
                }
                else if (n7 == 1) {
                    if (n6 > 0) {
                        if (this.a(3) == 0) {
                            a2[j + i * n3] = BiomeBase.MESA_PLATEAU.id;
                        }
                        else {
                            a2[j + i * n3] = BiomeBase.MESA_PLATEAU_F.id;
                        }
                    }
                    else {
                        a2[j + i * n3] = this.c[this.a(this.c.length)].id;
                    }
                }
                else if (n7 == 2) {
                    if (n6 > 0) {
                        a2[j + i * n3] = BiomeBase.JUNGLE.id;
                    }
                    else {
                        a2[j + i * n3] = this.d[this.a(this.d.length)].id;
                    }
                }
                else if (n7 == 3) {
                    if (n6 > 0) {
                        a2[j + i * n3] = BiomeBase.MEGA_TAIGA.id;
                    }
                    else {
                        a2[j + i * n3] = this.e[this.a(this.e.length)].id;
                    }
                }
                else if (n7 == 4) {
                    a2[j + i * n3] = this.f[this.a(this.f.length)].id;
                }
                else {
                    a2[j + i * n3] = BiomeBase.MUSHROOM_ISLAND.id;
                }
            }
        }
        return a2;
    }
}
