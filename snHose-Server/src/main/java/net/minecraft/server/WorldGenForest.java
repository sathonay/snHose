package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenForest extends WorldGenTreeAbstract
{
    private boolean a;
    
    public WorldGenForest(final boolean b, final boolean a) {
        super(b);
        this.a = a;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        int n4 = random.nextInt(3) + 5;
        if (this.a) {
            n4 += random.nextInt(7);
        }
        int n5 = 1;
        if (n2 < 1 || n2 + n4 + 1 > 256) {
            return false;
        }
        for (int i = n2; i <= n2 + 1 + n4; ++i) {
            int n6 = 1;
            if (i == n2) {
                n6 = 0;
            }
            if (i >= n2 + 1 + n4 - 2) {
                n6 = 2;
            }
            for (int j = n - n6; j <= n + n6 && n5 != 0; ++j) {
                for (int k = n3 - n6; k <= n3 + n6 && n5 != 0; ++k) {
                    if (i >= 0 && i < 256) {
                        if (!this.a(world.getType(j, i, k))) {
                            n5 = 0;
                        }
                    }
                    else {
                        n5 = 0;
                    }
                }
            }
        }
        if (n5 == 0) {
            return false;
        }
        final Block type = world.getType(n, n2 - 1, n3);
        if ((type != Blocks.GRASS && type != Blocks.DIRT && type != Blocks.SOIL) || n2 >= 256 - n4 - 1) {
            return false;
        }
        this.setType(world, n, n2 - 1, n3, Blocks.DIRT);
        for (int l = n2 - 3 + n4; l <= n2 + n4; ++l) {
            final int n7 = l - (n2 + n4);
            for (int n8 = 1 - n7 / 2, m = n - n8; m <= n + n8; ++m) {
                final int n9 = m - n;
                for (int k2 = n3 - n8; k2 <= n3 + n8; ++k2) {
                    final int n10 = k2 - n3;
                    if (Math.abs(n9) == n8 && Math.abs(n10) == n8) {
                        if (random.nextInt(2) == 0) {
                            continue;
                        }
                        if (n7 == 0) {
                            continue;
                        }
                    }
                    final Block type2 = world.getType(m, l, k2);
                    if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                        this.setTypeAndData(world, m, l, k2, Blocks.LEAVES, 2);
                    }
                }
            }
        }
        for (int n11 = 0; n11 < n4; ++n11) {
            final Block type3 = world.getType(n, n2 + n11, n3);
            if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, n, n2 + n11, n3, Blocks.LOG, 2);
            }
        }
        return true;
    }
}
