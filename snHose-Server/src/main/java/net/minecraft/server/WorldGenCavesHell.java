package net.minecraft.server;

import java.util.*;

public class WorldGenCavesHell extends WorldGenBase
{
    protected void a(final long n, final int n2, final int n3, final Block[] array, final double n4, final double n5, final double n6) {
        this.a(n, n2, n3, array, n4, n5, n6, 1.0f + this.b.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    protected void a(final long n, final int n2, final int n3, final Block[] array, double n4, double n5, double n6, final float n7, float n8, float n9, int i, int n10, final double n11) {
        final double n12 = n2 * 16 + 8;
        final double n13 = n3 * 16 + 8;
        float n14 = 0.0f;
        float n15 = 0.0f;
        final Random random = new Random(n);
        if (n10 <= 0) {
            final int n16 = this.a * 16 - 16;
            n10 = n16 - random.nextInt(n16 / 4);
        }
        boolean b = false;
        if (i == -1) {
            i = n10 / 2;
            b = true;
        }
        final int n17 = random.nextInt(n10 / 2) + n10 / 4;
        final boolean b2 = random.nextInt(6) == 0;
        while (i < n10) {
            final double n18 = 1.5 + MathHelper.sin(i * 3.1415927f / n10) * n7 * 1.0f;
            final double n19 = n18 * n11;
            final float cos = MathHelper.cos(n9);
            final float sin = MathHelper.sin(n9);
            n4 += MathHelper.cos(n8) * cos;
            n5 += sin;
            n6 += MathHelper.sin(n8) * cos;
            if (b2) {
                n9 *= 0.92f;
            }
            else {
                n9 *= 0.7f;
            }
            n9 += n15 * 0.1f;
            n8 += n14 * 0.1f;
            final float n20 = n15 * 0.9f;
            final float n21 = n14 * 0.75f;
            n15 = n20 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            n14 = n21 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (!b && i == n17 && n7 > 1.0f) {
                this.a(random.nextLong(), n2, n3, array, n4, n5, n6, random.nextFloat() * 0.5f + 0.5f, n8 - 1.5707964f, n9 / 3.0f, i, n10, 1.0);
                this.a(random.nextLong(), n2, n3, array, n4, n5, n6, random.nextFloat() * 0.5f + 0.5f, n8 + 1.5707964f, n9 / 3.0f, i, n10, 1.0);
                return;
            }
            if (b || random.nextInt(4) != 0) {
                final double n22 = n4 - n12;
                final double n23 = n6 - n13;
                final double n24 = n10 - i;
                final double n25 = n7 + 2.0f + 16.0f;
                if (n22 * n22 + n23 * n23 - n24 * n24 > n25 * n25) {
                    return;
                }
                if (n4 >= n12 - 16.0 - n18 * 2.0 && n6 >= n13 - 16.0 - n18 * 2.0 && n4 <= n12 + 16.0 + n18 * 2.0) {
                    if (n6 <= n13 + 16.0 + n18 * 2.0) {
                        int n26 = MathHelper.floor(n4 - n18) - n2 * 16 - 1;
                        int n27 = MathHelper.floor(n4 + n18) - n2 * 16 + 1;
                        int n28 = MathHelper.floor(n5 - n19) - 1;
                        int n29 = MathHelper.floor(n5 + n19) + 1;
                        int n30 = MathHelper.floor(n6 - n18) - n3 * 16 - 1;
                        int n31 = MathHelper.floor(n6 + n18) - n3 * 16 + 1;
                        if (n26 < 0) {
                            n26 = 0;
                        }
                        if (n27 > 16) {
                            n27 = 16;
                        }
                        if (n28 < 1) {
                            n28 = 1;
                        }
                        if (n29 > 120) {
                            n29 = 120;
                        }
                        if (n30 < 0) {
                            n30 = 0;
                        }
                        if (n31 > 16) {
                            n31 = 16;
                        }
                        int n32 = 0;
                        for (int n33 = n26; n32 == 0 && n33 < n27; ++n33) {
                            for (int n34 = n30; n32 == 0 && n34 < n31; ++n34) {
                                for (int n35 = n29 + 1; n32 == 0 && n35 >= n28 - 1; --n35) {
                                    final int n36 = (n33 * 16 + n34) * 128 + n35;
                                    if (n35 >= 0) {
                                        if (n35 < 128) {
                                            final Block block = array[n36];
                                            if (block == Blocks.LAVA || block == Blocks.STATIONARY_LAVA) {
                                                n32 = 1;
                                            }
                                            if (n35 != n28 - 1 && n33 != n26 && n33 != n27 - 1 && n34 != n30 && n34 != n31 - 1) {
                                                n35 = n28;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (n32 == 0) {
                            for (int j = n26; j < n27; ++j) {
                                final double n37 = (j + n2 * 16 + 0.5 - n4) / n18;
                                for (int k = n30; k < n31; ++k) {
                                    final double n38 = (k + n3 * 16 + 0.5 - n6) / n18;
                                    int n39 = (j * 16 + k) * 128 + n29;
                                    for (int l = n29 - 1; l >= n28; --l) {
                                        final double n40 = (l + 0.5 - n5) / n19;
                                        if (n40 > -0.7 && n37 * n37 + n40 * n40 + n38 * n38 < 1.0) {
                                            final Block block2 = array[n39];
                                            if (block2 == Blocks.NETHERRACK || block2 == Blocks.DIRT || block2 == Blocks.GRASS) {
                                                array[n39] = null;
                                            }
                                        }
                                        --n39;
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
        int nextInt = this.b.nextInt(this.b.nextInt(this.b.nextInt(10) + 1) + 1);
        if (this.b.nextInt(5) != 0) {
            nextInt = 0;
        }
        for (int i = 0; i < nextInt; ++i) {
            final double n5 = n * 16 + this.b.nextInt(16);
            final double n6 = this.b.nextInt(128);
            final double n7 = n2 * 16 + this.b.nextInt(16);
            int n8 = 1;
            if (this.b.nextInt(4) == 0) {
                this.a(this.b.nextLong(), n3, n4, array, n5, n6, n7);
                n8 += this.b.nextInt(4);
            }
            for (int j = 0; j < n8; ++j) {
                this.a(this.b.nextLong(), n3, n4, array, n5, n6, n7, (this.b.nextFloat() * 2.0f + this.b.nextFloat()) * 2.0f, this.b.nextFloat() * 3.1415927f * 2.0f, (this.b.nextFloat() - 0.5f) * 2.0f / 8.0f, 0, 0, 0.5);
            }
        }
    }
}
