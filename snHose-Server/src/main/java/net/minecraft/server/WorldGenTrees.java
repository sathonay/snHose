package net.minecraft.server;

import java.util.*;

public class WorldGenTrees extends WorldGenTreeAbstract
{
    private final int a;
    private final boolean b;
    private final int c;
    private final int d;
    
    public WorldGenTrees(final boolean b) {
        this(b, 4, 0, 0, false);
    }
    
    public WorldGenTrees(final boolean b, final int a, final int c, final int d, final boolean b2) {
        super(b);
        this.a = a;
        this.c = c;
        this.d = d;
        this.b = b2;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        final int n4 = random.nextInt(3) + this.a;
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
        final int n7 = 3;
        final int n8 = 0;
        for (int l = n2 - n7 + n4; l <= n2 + n4; ++l) {
            final int n9 = l - (n2 + n4);
            for (int n10 = n8 + 1 - n9 / 2, m = n - n10; m <= n + n10; ++m) {
                final int n11 = m - n;
                for (int k2 = n3 - n10; k2 <= n3 + n10; ++k2) {
                    final int n12 = k2 - n3;
                    if (Math.abs(n11) == n10 && Math.abs(n12) == n10) {
                        if (random.nextInt(2) == 0) {
                            continue;
                        }
                        if (n9 == 0) {
                            continue;
                        }
                    }
                    final Block type2 = world.getType(m, l, k2);
                    if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                        this.setTypeAndData(world, m, l, k2, Blocks.LEAVES, this.d);
                    }
                }
            }
        }
        for (int n13 = 0; n13 < n4; ++n13) {
            final Block type3 = world.getType(n, n2 + n13, n3);
            if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, n, n2 + n13, n3, Blocks.LOG, this.c);
                if (this.b && n13 > 0) {
                    if (random.nextInt(3) > 0 && world.isEmpty(n - 1, n2 + n13, n3)) {
                        this.setTypeAndData(world, n - 1, n2 + n13, n3, Blocks.VINE, 8);
                    }
                    if (random.nextInt(3) > 0 && world.isEmpty(n + 1, n2 + n13, n3)) {
                        this.setTypeAndData(world, n + 1, n2 + n13, n3, Blocks.VINE, 2);
                    }
                    if (random.nextInt(3) > 0 && world.isEmpty(n, n2 + n13, n3 - 1)) {
                        this.setTypeAndData(world, n, n2 + n13, n3 - 1, Blocks.VINE, 1);
                    }
                    if (random.nextInt(3) > 0 && world.isEmpty(n, n2 + n13, n3 + 1)) {
                        this.setTypeAndData(world, n, n2 + n13, n3 + 1, Blocks.VINE, 4);
                    }
                }
            }
        }
        if (this.b) {
            for (int j2 = n2 - 3 + n4; j2 <= n2 + n4; ++j2) {
                for (int n14 = 2 - (j2 - (n2 + n4)) / 2, i2 = n - n14; i2 <= n + n14; ++i2) {
                    for (int k3 = n3 - n14; k3 <= n3 + n14; ++k3) {
                        if (world.getType(i2, j2, k3).getMaterial() == Material.LEAVES) {
                            if (random.nextInt(4) == 0 && world.getType(i2 - 1, j2, k3).getMaterial() == Material.AIR) {
                                this.a(world, i2 - 1, j2, k3, 8);
                            }
                            if (random.nextInt(4) == 0 && world.getType(i2 + 1, j2, k3).getMaterial() == Material.AIR) {
                                this.a(world, i2 + 1, j2, k3, 2);
                            }
                            if (random.nextInt(4) == 0 && world.getType(i2, j2, k3 - 1).getMaterial() == Material.AIR) {
                                this.a(world, i2, j2, k3 - 1, 1);
                            }
                            if (random.nextInt(4) == 0 && world.getType(i2, j2, k3 + 1).getMaterial() == Material.AIR) {
                                this.a(world, i2, j2, k3 + 1, 4);
                            }
                        }
                    }
                }
            }
            if (random.nextInt(5) == 0 && n4 > 5) {
                for (int n15 = 0; n15 < 2; ++n15) {
                    for (int n16 = 0; n16 < 4; ++n16) {
                        if (random.nextInt(4 - n15) == 0) {
                            this.setTypeAndData(world, n + Direction.a[Direction.f[n16]], n2 + n4 - 5 + n15, n3 + Direction.b[Direction.f[n16]], Blocks.COCOA, random.nextInt(3) << 2 | n16);
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
