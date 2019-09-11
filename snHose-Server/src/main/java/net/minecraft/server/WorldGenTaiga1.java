package net.minecraft.server;

import java.util.*;

public class WorldGenTaiga1 extends WorldGenTreeAbstract
{
    public WorldGenTaiga1() {
        super(false);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        final int n4 = random.nextInt(5) + 7;
        final int n5 = n4 - random.nextInt(2) - 3;
        final int n6 = 1 + random.nextInt(n4 - n5 + 1);
        int n7 = 1;
        if (n2 < 1 || n2 + n4 + 1 > 256) {
            return false;
        }
        for (int j = n2; j <= n2 + 1 + n4 && n7 != 0; ++j) {
            int n8;
            if (j - n2 < n5) {
                n8 = 0;
            }
            else {
                n8 = n6;
            }
            for (int i = n - n8; i <= n + n8 && n7 != 0; ++i) {
                for (int k = n3 - n8; k <= n3 + n8 && n7 != 0; ++k) {
                    if (j >= 0 && j < 256) {
                        if (!this.a(world.getType(i, j, k))) {
                            n7 = 0;
                        }
                    }
                    else {
                        n7 = 0;
                    }
                }
            }
        }
        if (n7 == 0) {
            return false;
        }
        final Block type = world.getType(n, n2 - 1, n3);
        if ((type != Blocks.GRASS && type != Blocks.DIRT) || n2 >= 256 - n4 - 1) {
            return false;
        }
        this.setType(world, n, n2 - 1, n3, Blocks.DIRT);
        int n9 = 0;
        for (int l = n2 + n4; l >= n2 + n5; --l) {
            for (int m = n - n9; m <= n + n9; ++m) {
                final int n10 = m - n;
                for (int k2 = n3 - n9; k2 <= n3 + n9; ++k2) {
                    final int n11 = k2 - n3;
                    if (Math.abs(n10) != n9 || Math.abs(n11) != n9 || n9 <= 0) {
                        if (!world.getType(m, l, k2).j()) {
                            this.setTypeAndData(world, m, l, k2, Blocks.LEAVES, 1);
                        }
                    }
                }
            }
            if (n9 >= 1 && l == n2 + n5 + 1) {
                --n9;
            }
            else if (n9 < n6) {
                ++n9;
            }
        }
        for (int n12 = 0; n12 < n4 - 1; ++n12) {
            final Block type2 = world.getType(n, n2 + n12, n3);
            if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, n, n2 + n12, n3, Blocks.LOG, 1);
            }
        }
        return true;
    }
}
