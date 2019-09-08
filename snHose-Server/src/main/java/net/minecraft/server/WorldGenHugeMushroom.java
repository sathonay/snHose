package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenHugeMushroom extends WorldGenerator
{
    private int a;
    
    public WorldGenHugeMushroom(final int a) {
        super(true);
        this.a = -1;
        this.a = a;
    }
    
    public WorldGenHugeMushroom() {
        super(false);
        this.a = -1;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        int n4 = random.nextInt(2);
        if (this.a >= 0) {
            n4 = this.a;
        }
        final int n5 = random.nextInt(3) + 4;
        int n6 = 1;
        if (n2 < 1 || n2 + n5 + 1 >= 256) {
            return false;
        }
        for (int i = n2; i <= n2 + 1 + n5; ++i) {
            int n7 = 3;
            if (i <= n2 + 3) {
                n7 = 0;
            }
            for (int j = n - n7; j <= n + n7 && n6 != 0; ++j) {
                for (int k = n3 - n7; k <= n3 + n7 && n6 != 0; ++k) {
                    if (i >= 0 && i < 256) {
                        final Block type = world.getType(j, i, k);
                        if (type.getMaterial() != Material.AIR && type.getMaterial() != Material.LEAVES) {
                            n6 = 0;
                        }
                    }
                    else {
                        n6 = 0;
                    }
                }
            }
        }
        if (n6 == 0) {
            return false;
        }
        final Block type2 = world.getType(n, n2 - 1, n3);
        if (type2 != Blocks.DIRT && type2 != Blocks.GRASS && type2 != Blocks.MYCEL) {
            return false;
        }
        int n8 = n2 + n5;
        if (n4 == 1) {
            n8 = n2 + n5 - 3;
        }
        for (int l = n8; l <= n2 + n5; ++l) {
            int n9 = 1;
            if (l < n2 + n5) {
                ++n9;
            }
            if (n4 == 0) {
                n9 = 3;
            }
            for (int m = n - n9; m <= n + n9; ++m) {
                for (int k2 = n3 - n9; k2 <= n3 + n9; ++k2) {
                    int n10 = 5;
                    if (m == n - n9) {
                        --n10;
                    }
                    if (m == n + n9) {
                        ++n10;
                    }
                    if (k2 == n3 - n9) {
                        n10 -= 3;
                    }
                    if (k2 == n3 + n9) {
                        n10 += 3;
                    }
                    if (n4 == 0 || l < n2 + n5) {
                        if (m == n - n9 || m == n + n9) {
                            if (k2 == n3 - n9) {
                                continue;
                            }
                            if (k2 == n3 + n9) {
                                continue;
                            }
                        }
                        if (m == n - (n9 - 1) && k2 == n3 - n9) {
                            n10 = 1;
                        }
                        if (m == n - n9 && k2 == n3 - (n9 - 1)) {
                            n10 = 1;
                        }
                        if (m == n + (n9 - 1) && k2 == n3 - n9) {
                            n10 = 3;
                        }
                        if (m == n + n9 && k2 == n3 - (n9 - 1)) {
                            n10 = 3;
                        }
                        if (m == n - (n9 - 1) && k2 == n3 + n9) {
                            n10 = 7;
                        }
                        if (m == n - n9 && k2 == n3 + (n9 - 1)) {
                            n10 = 7;
                        }
                        if (m == n + (n9 - 1) && k2 == n3 + n9) {
                            n10 = 9;
                        }
                        if (m == n + n9 && k2 == n3 + (n9 - 1)) {
                            n10 = 9;
                        }
                    }
                    if (n10 == 5 && l < n2 + n5) {
                        n10 = 0;
                    }
                    if ((n10 != 0 || n2 >= n2 + n5 - 1) && !world.getType(m, l, k2).j()) {
                        this.setTypeAndData(world, m, l, k2, Block.getById(Block.getId(Blocks.BIG_MUSHROOM_1) + n4), n10);
                    }
                }
            }
        }
        for (int n11 = 0; n11 < n5; ++n11) {
            if (!world.getType(n, n2 + n11, n3).j()) {
                this.setTypeAndData(world, n, n2 + n11, n3, Block.getById(Block.getId(Blocks.BIG_MUSHROOM_1) + n4), 10);
            }
        }
        return true;
    }
}
