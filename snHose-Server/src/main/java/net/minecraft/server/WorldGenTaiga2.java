package net.minecraft.server;

import java.util.*;

public class WorldGenTaiga2 extends WorldGenTreeAbstract
{
    public WorldGenTaiga2(final boolean b) {
        super(b);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        final int n4 = random.nextInt(4) + 6;
        final int n5 = 1 + random.nextInt(2);
        final int n6 = n4 - n5;
        final int n7 = 2 + random.nextInt(2);
        int n8 = 1;
        if (n2 < 1 || n2 + n4 + 1 > 256) {
            return false;
        }
        for (int j = n2; j <= n2 + 1 + n4 && n8 != 0; ++j) {
            int n9;
            if (j - n2 < n5) {
                n9 = 0;
            }
            else {
                n9 = n7;
            }
            for (int i = n - n9; i <= n + n9 && n8 != 0; ++i) {
                for (int k = n3 - n9; k <= n3 + n9 && n8 != 0; ++k) {
                    if (j >= 0 && j < 256) {
                        final Block type = world.getType(i, j, k);
                        if (type.getMaterial() != Material.AIR && type.getMaterial() != Material.LEAVES) {
                            n8 = 0;
                        }
                    }
                    else {
                        n8 = 0;
                    }
                }
            }
        }
        if (n8 == 0) {
            return false;
        }
        final Block type2 = world.getType(n, n2 - 1, n3);
        if ((type2 != Blocks.GRASS && type2 != Blocks.DIRT && type2 != Blocks.SOIL) || n2 >= 256 - n4 - 1) {
            return false;
        }
        this.setType(world, n, n2 - 1, n3, Blocks.DIRT);
        int nextInt = random.nextInt(2);
        int n10 = 1;
        int n11 = 0;
        for (int l = 0; l <= n6; ++l) {
            final int m = n2 + n4 - l;
            for (int i2 = n - nextInt; i2 <= n + nextInt; ++i2) {
                final int n12 = i2 - n;
                for (int k2 = n3 - nextInt; k2 <= n3 + nextInt; ++k2) {
                    final int n13 = k2 - n3;
                    if (Math.abs(n12) != nextInt || Math.abs(n13) != nextInt || nextInt <= 0) {
                        if (!world.getType(i2, m, k2).j()) {
                            this.setTypeAndData(world, i2, m, k2, Blocks.LEAVES, 1);
                        }
                    }
                }
            }
            if (nextInt >= n10) {
                nextInt = n11;
                n11 = 1;
                if (++n10 > n7) {
                    n10 = n7;
                }
            }
            else {
                ++nextInt;
            }
        }
        for (int nextInt2 = random.nextInt(3), n14 = 0; n14 < n4 - nextInt2; ++n14) {
            final Block type3 = world.getType(n, n2 + n14, n3);
            if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, n, n2 + n14, n3, Blocks.LOG, 1);
            }
        }
        return true;
    }
}
