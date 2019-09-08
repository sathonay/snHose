package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenAcaciaTree extends WorldGenTreeAbstract
{
    public WorldGenAcaciaTree(final boolean b) {
        super(b);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int n, final int k) {
        final int n2 = random.nextInt(3) + random.nextInt(3) + 5;
        int n3 = 1;
        if (n < 1 || n + n2 + 1 > 256) {
            return false;
        }
        for (int j = n; j <= n + 1 + n2; ++j) {
            int n4 = 1;
            if (j == n) {
                n4 = 0;
            }
            if (j >= n + 1 + n2 - 2) {
                n4 = 2;
            }
            for (int l = i - n4; l <= i + n4 && n3 != 0; ++l) {
                for (int m = k - n4; m <= k + n4 && n3 != 0; ++m) {
                    if (j >= 0 && j < 256) {
                        if (!this.a(world.getType(l, j, m))) {
                            n3 = 0;
                        }
                    }
                    else {
                        n3 = 0;
                    }
                }
            }
        }
        if (n3 == 0) {
            return false;
        }
        final Block type = world.getType(i, n - 1, k);
        if ((type != Blocks.GRASS && type != Blocks.DIRT) || n >= 256 - n2 - 1) {
            return false;
        }
        this.setType(world, i, n - 1, k, Blocks.DIRT);
        final int nextInt = random.nextInt(4);
        final int n5 = n2 - random.nextInt(4) - 1;
        int n6 = 3 - random.nextInt(3);
        int i2 = i;
        int k2 = k;
        int n7 = 0;
        for (int n8 = 0; n8 < n2; ++n8) {
            final int j2 = n + n8;
            if (n8 >= n5 && n6 > 0) {
                i2 += Direction.a[nextInt];
                k2 += Direction.b[nextInt];
                --n6;
            }
            final Block type2 = world.getType(i2, j2, k2);
            if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, i2, j2, k2, Blocks.LOG2, 0);
                n7 = j2;
            }
        }
        for (int n9 = -1; n9 <= 1; ++n9) {
            for (int n10 = -1; n10 <= 1; ++n10) {
                this.a(world, i2 + n9, n7 + 1, k2 + n10);
            }
        }
        this.a(world, i2 + 2, n7 + 1, k2);
        this.a(world, i2 - 2, n7 + 1, k2);
        this.a(world, i2, n7 + 1, k2 + 2);
        this.a(world, i2, n7 + 1, k2 - 2);
        for (int n11 = -3; n11 <= 3; ++n11) {
            for (int n12 = -3; n12 <= 3; ++n12) {
                if (Math.abs(n11) != 3 || Math.abs(n12) != 3) {
                    this.a(world, i2 + n11, n7, k2 + n12);
                }
            }
        }
        int i3 = i;
        int k3 = k;
        final int nextInt2 = random.nextInt(4);
        if (nextInt2 != nextInt) {
            final int n13 = n5 - random.nextInt(2) - 1;
            int n14 = 1 + random.nextInt(3);
            int n15 = 0;
            for (int n16 = n13; n16 < n2 && n14 > 0; ++n16, --n14) {
                if (n16 >= 1) {
                    final int j3 = n + n16;
                    i3 += Direction.a[nextInt2];
                    k3 += Direction.b[nextInt2];
                    final Block type3 = world.getType(i3, j3, k3);
                    if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                        this.setTypeAndData(world, i3, j3, k3, Blocks.LOG2, 0);
                        n15 = j3;
                    }
                }
            }
            if (n15 > 0) {
                for (int n17 = -1; n17 <= 1; ++n17) {
                    for (int n18 = -1; n18 <= 1; ++n18) {
                        this.a(world, i3 + n17, n15 + 1, k3 + n18);
                    }
                }
                for (int n19 = -2; n19 <= 2; ++n19) {
                    for (int n20 = -2; n20 <= 2; ++n20) {
                        if (Math.abs(n19) != 2 || Math.abs(n20) != 2) {
                            this.a(world, i3 + n19, n15, k3 + n20);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private void a(final World world, final int i, final int j, final int k) {
        final Block type = world.getType(i, j, k);
        if (type.getMaterial() == Material.AIR || type.getMaterial() == Material.LEAVES) {
            this.setTypeAndData(world, i, j, k, Blocks.LEAVES2, 0);
        }
    }
}
