package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenSwampTree extends WorldGenTreeAbstract
{
    public WorldGenSwampTree() {
        super(false);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, int n, final int k) {
        final int n2 = random.nextInt(4) + 5;
        while (world.getType(i, n - 1, k).getMaterial() == Material.WATER) {
            --n;
        }
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
                n4 = 3;
            }
            for (int l = i - n4; l <= i + n4 && n3 != 0; ++l) {
                for (int m = k - n4; m <= k + n4 && n3 != 0; ++m) {
                    if (j >= 0 && j < 256) {
                        final Block type = world.getType(l, j, m);
                        if (type.getMaterial() != Material.AIR && type.getMaterial() != Material.LEAVES) {
                            if (type == Blocks.STATIONARY_WATER || type == Blocks.WATER) {
                                if (j > n) {
                                    n3 = 0;
                                }
                            }
                            else {
                                n3 = 0;
                            }
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
        final Block type2 = world.getType(i, n - 1, k);
        if ((type2 != Blocks.GRASS && type2 != Blocks.DIRT) || n >= 256 - n2 - 1) {
            return false;
        }
        this.setType(world, i, n - 1, k, Blocks.DIRT);
        for (int j2 = n - 3 + n2; j2 <= n + n2; ++j2) {
            final int n5 = j2 - (n + n2);
            for (int n6 = 2 - n5 / 2, i2 = i - n6; i2 <= i + n6; ++i2) {
                final int n7 = i2 - i;
                for (int k2 = k - n6; k2 <= k + n6; ++k2) {
                    final int n8 = k2 - k;
                    if (Math.abs(n7) == n6 && Math.abs(n8) == n6) {
                        if (random.nextInt(2) == 0) {
                            continue;
                        }
                        if (n5 == 0) {
                            continue;
                        }
                    }
                    if (!world.getType(i2, j2, k2).j()) {
                        this.setType(world, i2, j2, k2, Blocks.LEAVES);
                    }
                }
            }
        }
        for (int n9 = 0; n9 < n2; ++n9) {
            final Block type3 = world.getType(i, n + n9, k);
            if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES || type3 == Blocks.WATER || type3 == Blocks.STATIONARY_WATER) {
                this.setType(world, i, n + n9, k, Blocks.LOG);
            }
        }
        for (int j3 = n - 3 + n2; j3 <= n + n2; ++j3) {
            for (int n10 = 2 - (j3 - (n + n2)) / 2, i3 = i - n10; i3 <= i + n10; ++i3) {
                for (int k3 = k - n10; k3 <= k + n10; ++k3) {
                    if (world.getType(i3, j3, k3).getMaterial() == Material.LEAVES) {
                        if (random.nextInt(4) == 0 && world.getType(i3 - 1, j3, k3).getMaterial() == Material.AIR) {
                            this.a(world, i3 - 1, j3, k3, 8);
                        }
                        if (random.nextInt(4) == 0 && world.getType(i3 + 1, j3, k3).getMaterial() == Material.AIR) {
                            this.a(world, i3 + 1, j3, k3, 2);
                        }
                        if (random.nextInt(4) == 0 && world.getType(i3, j3, k3 - 1).getMaterial() == Material.AIR) {
                            this.a(world, i3, j3, k3 - 1, 1);
                        }
                        if (random.nextInt(4) == 0 && world.getType(i3, j3, k3 + 1).getMaterial() == Material.AIR) {
                            this.a(world, i3, j3, k3 + 1, 4);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private void a(final World world, final int i, int n, final int k, final int n2) {
        this.setTypeAndData(world, i, n, k, Blocks.VINE, n2);
        for (int n3 = 4; world.getType(i, --n, k).getMaterial() == Material.AIR && n3 > 0; --n3) {
            this.setTypeAndData(world, i, n, k, Blocks.VINE, n2);
        }
    }
}
