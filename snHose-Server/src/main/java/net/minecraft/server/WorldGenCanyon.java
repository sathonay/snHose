package net.minecraft.server;

import java.util.*;

public class WorldGenCanyon extends WorldGenBase
{
    private float[] d;
    
    public WorldGenCanyon() {
        this.d = new float[1024];
    }
    
    protected void a(final long n, final int n2, final int n3, final Block[] array, double n4, double n5, double n6, final float n7, float n8, float n9, int i, int n10, final double n11) {
        final Random random = new Random(n);
        final double n12 = n2 * 16 + 8;
        final double n13 = n3 * 16 + 8;
        float n14 = 0.0f;
        float n15 = 0.0f;
        if (n10 <= 0) {
            final int n16 = this.a * 16 - 16;
            n10 = n16 - random.nextInt(n16 / 4);
        }
        boolean b = false;
        if (i == -1) {
            i = n10 / 2;
            b = true;
        }
        float n17 = 1.0f;
        for (int j = 0; j < 256; ++j) {
            if (j == 0 || random.nextInt(3) == 0) {
                n17 = 1.0f + random.nextFloat() * random.nextFloat() * 1.0f;
            }
            this.d[j] = n17 * n17;
        }
        while (i < n10) {
            final double n18 = 1.5 + MathHelper.sin(i * 3.1415927f / n10) * n7 * 1.0f;
            final double n19 = n18 * n11;
            final double n20 = n18 * (random.nextFloat() * 0.25 + 0.75);
            final double n21 = n19 * (random.nextFloat() * 0.25 + 0.75);
            final float cos = MathHelper.cos(n9);
            final float sin = MathHelper.sin(n9);
            n4 += MathHelper.cos(n8) * cos;
            n5 += sin;
            n6 += MathHelper.sin(n8) * cos;
            n9 *= 0.7f;
            n9 += n15 * 0.05f;
            n8 += n14 * 0.05f;
            final float n22 = n15 * 0.8f;
            final float n23 = n14 * 0.5f;
            n15 = n22 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            n14 = n23 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (b || random.nextInt(4) != 0) {
                final double n24 = n4 - n12;
                final double n25 = n6 - n13;
                final double n26 = n10 - i;
                final double n27 = n7 + 2.0f + 16.0f;
                if (n24 * n24 + n25 * n25 - n26 * n26 > n27 * n27) {
                    return;
                }
                if (n4 >= n12 - 16.0 - n20 * 2.0 && n6 >= n13 - 16.0 - n20 * 2.0 && n4 <= n12 + 16.0 + n20 * 2.0) {
                    if (n6 <= n13 + 16.0 + n20 * 2.0) {
                        int n28 = MathHelper.floor(n4 - n20) - n2 * 16 - 1;
                        int n29 = MathHelper.floor(n4 + n20) - n2 * 16 + 1;
                        int n30 = MathHelper.floor(n5 - n21) - 1;
                        int n31 = MathHelper.floor(n5 + n21) + 1;
                        int n32 = MathHelper.floor(n6 - n20) - n3 * 16 - 1;
                        int n33 = MathHelper.floor(n6 + n20) - n3 * 16 + 1;
                        if (n28 < 0) {
                            n28 = 0;
                        }
                        if (n29 > 16) {
                            n29 = 16;
                        }
                        if (n30 < 1) {
                            n30 = 1;
                        }
                        if (n31 > 248) {
                            n31 = 248;
                        }
                        if (n32 < 0) {
                            n32 = 0;
                        }
                        if (n33 > 16) {
                            n33 = 16;
                        }
                        int n34 = 0;
                        for (int n35 = n28; n34 == 0 && n35 < n29; ++n35) {
                            for (int n36 = n32; n34 == 0 && n36 < n33; ++n36) {
                                for (int n37 = n31 + 1; n34 == 0 && n37 >= n30 - 1; --n37) {
                                    final int n38 = (n35 * 16 + n36) * 256 + n37;
                                    if (n37 >= 0) {
                                        if (n37 < 256) {
                                            final Block block = array[n38];
                                            if (block == Blocks.WATER || block == Blocks.STATIONARY_WATER) {
                                                n34 = 1;
                                            }
                                            if (n37 != n30 - 1 && n35 != n28 && n35 != n29 - 1 && n36 != n32 && n36 != n33 - 1) {
                                                n37 = n30;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (n34 == 0) {
                            for (int k = n28; k < n29; ++k) {
                                final double n39 = (k + n2 * 16 + 0.5 - n4) / n20;
                                for (int l = n32; l < n33; ++l) {
                                    final double n40 = (l + n3 * 16 + 0.5 - n6) / n20;
                                    int n41 = (k * 16 + l) * 256 + n31;
                                    boolean b2 = false;
                                    if (n39 * n39 + n40 * n40 < 1.0) {
                                        for (int n42 = n31 - 1; n42 >= n30; --n42) {
                                            final double n43 = (n42 + 0.5 - n5) / n21;
                                            if ((n39 * n39 + n40 * n40) * this.d[n42] + n43 * n43 / 6.0 < 1.0) {
                                                final Block block2 = array[n41];
                                                if (block2 == Blocks.GRASS) {
                                                    b2 = true;
                                                }
                                                if (block2 == Blocks.STONE || block2 == Blocks.DIRT || block2 == Blocks.GRASS) {
                                                    if (n42 < 10) {
                                                        array[n41] = Blocks.LAVA;
                                                    }
                                                    else {
                                                        array[n41] = null;
                                                        if (b2 && array[n41 - 1] == Blocks.DIRT) {
                                                            array[n41 - 1] = this.c.getBiome(k + n2 * 16, l + n3 * 16).ai;
                                                        }
                                                    }
                                                }
                                            }
                                            --n41;
                                        }
                                    }
                                }
                            }
                            if (b) {
                                break;
                            }
                        }
                    }
                }
            }
            ++i;
        }
    }
    
    @Override
    protected void a(final World world, final int n, final int n2, final int n3, final int n4, final Block[] array) {
        if (this.b.nextInt(50) != 0) {
            return;
        }
        final double n5 = n * 16 + this.b.nextInt(16);
        final double n6 = this.b.nextInt(this.b.nextInt(40) + 8) + 20;
        final double n7 = n2 * 16 + this.b.nextInt(16);
        for (int n8 = 1, i = 0; i < n8; ++i) {
            this.a(this.b.nextLong(), n3, n4, array, n5, n6, n7, (this.b.nextFloat() * 2.0f + this.b.nextFloat()) * 2.0f, this.b.nextFloat() * 3.1415927f * 2.0f, (this.b.nextFloat() - 0.5f) * 2.0f / 8.0f, 0, 0, 3.0);
        }
    }
}
