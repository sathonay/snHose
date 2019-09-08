package net.minecraft.server.v1_7_R4;

import java.util.*;

public class ChunkProviderTheEnd implements IChunkProvider
{
    private Random i;
    private NoiseGeneratorOctaves j;
    private NoiseGeneratorOctaves k;
    private NoiseGeneratorOctaves l;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    private World m;
    private double[] n;
    private BiomeBase[] o;
    double[] c;
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    int[][] h;
    
    public ChunkProviderTheEnd(final World m, final long n) {
        this.h = new int[32][32];
        this.m = m;
        this.i = new Random(n);
        this.j = new NoiseGeneratorOctaves(this.i, 16);
        this.k = new NoiseGeneratorOctaves(this.i, 16);
        this.l = new NoiseGeneratorOctaves(this.i, 8);
        this.a = new NoiseGeneratorOctaves(this.i, 10);
        this.b = new NoiseGeneratorOctaves(this.i, 16);
    }
    
    public void a(final int n, final int n2, final Block[] array, final BiomeBase[] array2) {
        final int n3 = 2;
        final int n4 = n3 + 1;
        final int n5 = 33;
        final int n6 = n3 + 1;
        this.n = this.a(this.n, n * n3, 0, n2 * n3, n4, n5, n6);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < 32; ++k) {
                    final double n7 = 0.25;
                    double n8 = this.n[((i + 0) * n6 + (j + 0)) * n5 + (k + 0)];
                    double n9 = this.n[((i + 0) * n6 + (j + 1)) * n5 + (k + 0)];
                    double n10 = this.n[((i + 1) * n6 + (j + 0)) * n5 + (k + 0)];
                    double n11 = this.n[((i + 1) * n6 + (j + 1)) * n5 + (k + 0)];
                    final double n12 = (this.n[((i + 0) * n6 + (j + 0)) * n5 + (k + 1)] - n8) * n7;
                    final double n13 = (this.n[((i + 0) * n6 + (j + 1)) * n5 + (k + 1)] - n9) * n7;
                    final double n14 = (this.n[((i + 1) * n6 + (j + 0)) * n5 + (k + 1)] - n10) * n7;
                    final double n15 = (this.n[((i + 1) * n6 + (j + 1)) * n5 + (k + 1)] - n11) * n7;
                    for (int l = 0; l < 4; ++l) {
                        final double n16 = 0.125;
                        double n17 = n8;
                        double n18 = n9;
                        final double n19 = (n10 - n8) * n16;
                        final double n20 = (n11 - n9) * n16;
                        for (int n21 = 0; n21 < 8; ++n21) {
                            int n22 = n21 + i * 8 << 11 | 0 + j * 8 << 7 | k * 4 + l;
                            final int n23 = 128;
                            final double n24 = 0.125;
                            double n25 = n17;
                            final double n26 = (n18 - n17) * n24;
                            for (int n27 = 0; n27 < 8; ++n27) {
                                Block whitestone = null;
                                if (n25 > 0.0) {
                                    whitestone = Blocks.WHITESTONE;
                                }
                                array[n22] = whitestone;
                                n22 += n23;
                                n25 += n26;
                            }
                            n17 += n19;
                            n18 += n20;
                        }
                        n8 += n12;
                        n9 += n13;
                        n10 += n14;
                        n11 += n15;
                    }
                }
            }
        }
    }
    
    public void b(final int n, final int n2, final Block[] array, final BiomeBase[] array2) {
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                final int n3 = 1;
                int n4 = -1;
                Block whitestone = Blocks.WHITESTONE;
                Block block = Blocks.WHITESTONE;
                for (int k = 127; k >= 0; --k) {
                    final int n5 = (j * 16 + i) * 128 + k;
                    final Block block2 = array[n5];
                    if (block2 == null || block2.getMaterial() == Material.AIR) {
                        n4 = -1;
                    }
                    else if (block2 == Blocks.STONE) {
                        if (n4 == -1) {
                            if (n3 <= 0) {
                                whitestone = null;
                                block = Blocks.WHITESTONE;
                            }
                            n4 = n3;
                            if (k >= 0) {
                                array[n5] = whitestone;
                            }
                            else {
                                array[n5] = block;
                            }
                        }
                        else if (n4 > 0) {
                            --n4;
                            array[n5] = block;
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public Chunk getChunkAt(final int n, final int n2) {
        return this.getOrCreateChunk(n, n2);
    }
    
    @Override
    public Chunk getOrCreateChunk(final int i, final int j) {
        this.i.setSeed(i * 341873128712L + j * 132897987541L);
        final Block[] ablock = new Block[32768];
        this.a(i, j, ablock, this.o = this.m.getWorldChunkManager().getBiomeBlock(this.o, i * 16, j * 16, 16, 16));
        this.b(i, j, ablock, this.o);
        final Chunk chunk = new Chunk(this.m, ablock, i, j);
        final byte[] m = chunk.m();
        for (int k = 0; k < m.length; ++k) {
            m[k] = (byte)this.o[k].id;
        }
        chunk.initLighting();
        return chunk;
    }
    
    private double[] a(double[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (array == null) {
            array = new double[n4 * n5 * n6];
        }
        final double n7 = 684.412;
        final double n8 = 684.412;
        this.f = this.a.a(this.f, n, n3, n4, n6, 1.121, 1.121, 0.5);
        this.g = this.b.a(this.g, n, n3, n4, n6, 200.0, 200.0, 0.5);
        final double n9 = n7 * 2.0;
        this.c = this.l.a(this.c, n, n2, n3, n4, n5, n6, n9 / 80.0, n8 / 160.0, n9 / 80.0);
        this.d = this.j.a(this.d, n, n2, n3, n4, n5, n6, n9, n8, n9);
        this.e = this.k.a(this.e, n, n2, n3, n4, n5, n6, n9, n8, n9);
        int n10 = 0;
        int n11 = 0;
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n6; ++j) {
                double n12 = (this.f[n11] + 256.0) / 512.0;
                if (n12 > 1.0) {
                    n12 = 1.0;
                }
                double n13 = this.g[n11] / 8000.0;
                if (n13 < 0.0) {
                    n13 = -n13 * 0.3;
                }
                double n14 = n13 * 3.0 - 2.0;
                final float n15 = (i + n - 0) / 1.0f;
                final float n16 = (j + n3 - 0) / 1.0f;
                float n17 = 100.0f - MathHelper.c(n15 * n15 + n16 * n16) * 8.0f;
                if (n17 > 80.0f) {
                    n17 = 80.0f;
                }
                if (n17 < -100.0f) {
                    n17 = -100.0f;
                }
                if (n14 > 1.0) {
                    n14 = 1.0;
                }
                final double n18 = 0.0;
                if (n12 < 0.0) {
                    n12 = 0.0;
                }
                final double n19 = n12 + 0.5;
                final double n20 = n18 * n5 / 16.0;
                ++n11;
                final double n21 = n5 / 2.0;
                for (int k = 0; k < n5; ++k) {
                    if ((k - n21) * 8.0 / n19 < 0.0) {}
                    final double n22 = this.d[n10] / 512.0;
                    final double n23 = this.e[n10] / 512.0;
                    final double n24 = (this.c[n10] / 10.0 + 1.0) / 2.0;
                    double n25;
                    if (n24 < 0.0) {
                        n25 = n22;
                    }
                    else if (n24 > 1.0) {
                        n25 = n23;
                    }
                    else {
                        n25 = n22 + (n23 - n22) * n24;
                    }
                    double n26 = n25 - 8.0 + n17;
                    final int n27 = 2;
                    if (k > n5 / 2 - n27) {
                        double n28 = (k - (n5 / 2 - n27)) / 64.0f;
                        if (n28 < 0.0) {
                            n28 = 0.0;
                        }
                        if (n28 > 1.0) {
                            n28 = 1.0;
                        }
                        n26 = n26 * (1.0 - n28) + -3000.0 * n28;
                    }
                    final int n29 = 8;
                    if (k < n29) {
                        final double n30 = (n29 - k) / (n29 - 1.0f);
                        n26 = n26 * (1.0 - n30) + -30.0 * n30;
                    }
                    array[n10] = n26;
                    ++n10;
                }
            }
        }
        return array;
    }
    
    @Override
    public boolean isChunkLoaded(final int n, final int n2) {
        return true;
    }
    
    @Override
    public void getChunkAt(final IChunkProvider chunkProvider, final int n, final int n2) {
        BlockFalling.instaFall = true;
        final int i = n * 16;
        final int j = n2 * 16;
        this.m.getBiome(i + 16, j + 16).a(this.m, this.m.random, i, j);
        BlockFalling.instaFall = false;
    }
    
    @Override
    public boolean saveChunks(final boolean b, final IProgressUpdate progressUpdate) {
        return true;
    }
    
    @Override
    public void c() {
    }
    
    @Override
    public boolean unloadChunks() {
        return false;
    }
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    @Override
    public String getName() {
        return "RandomLevelSource";
    }
    
    @Override
    public List getMobsFor(final EnumCreatureType enumcreaturetype, final int i, final int n, final int j) {
        return this.m.getBiome(i, j).getMobs(enumcreaturetype);
    }
    
    @Override
    public ChunkPosition findNearestMapFeature(final World world, final String s, final int n, final int n2, final int n3) {
        return null;
    }
    
    @Override
    public int getLoadedChunks() {
        return 0;
    }
    
    @Override
    public void recreateStructures(final int n, final int n2) {
    }
}
