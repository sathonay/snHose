package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenJungleTree extends WorldGenMegaTreeAbstract
{
    public WorldGenJungleTree(final boolean flag, final int i, final int j, final int k, final int l) {
        super(flag, i, j, k, l);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        final int a = this.a(random);
        if (!this.a(world, random, i, j, k, a)) {
            return false;
        }
        this.c(world, i, k, j + a, 2, random);
        for (int l = j + a - 2 - random.nextInt(4); l > j + a / 2; l -= 2 + random.nextInt(4)) {
            final float n = random.nextFloat() * 3.1415927f * 2.0f;
            int m = i + (int)(0.5f + MathHelper.cos(n) * 4.0f);
            int k2 = k + (int)(0.5f + MathHelper.sin(n) * 4.0f);
            for (int n2 = 0; n2 < 5; ++n2) {
                m = i + (int)(1.5f + MathHelper.cos(n) * n2);
                k2 = k + (int)(1.5f + MathHelper.sin(n) * n2);
                this.setTypeAndData(world, m, l - 3 + n2 / 2, k2, Blocks.LOG, this.b);
            }
            final int n3 = 1 + random.nextInt(2);
            for (int n4 = l, j2 = n4 - n3; j2 <= n4; ++j2) {
                this.b(world, m, j2, k2, 1 - (j2 - n4), random);
            }
        }
        for (int n5 = 0; n5 < a; ++n5) {
            final Block type = world.getType(i, j + n5, k);
            if (type.getMaterial() == Material.AIR || type.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, i, j + n5, k, Blocks.LOG, this.b);
                if (n5 > 0) {
                    if (random.nextInt(3) > 0 && world.isEmpty(i - 1, j + n5, k)) {
                        this.setTypeAndData(world, i - 1, j + n5, k, Blocks.VINE, 8);
                    }
                    if (random.nextInt(3) > 0 && world.isEmpty(i, j + n5, k - 1)) {
                        this.setTypeAndData(world, i, j + n5, k - 1, Blocks.VINE, 1);
                    }
                }
            }
            if (n5 < a - 1) {
                final Block type2 = world.getType(i + 1, j + n5, k);
                if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i + 1, j + n5, k, Blocks.LOG, this.b);
                    if (n5 > 0) {
                        if (random.nextInt(3) > 0 && world.isEmpty(i + 2, j + n5, k)) {
                            this.setTypeAndData(world, i + 2, j + n5, k, Blocks.VINE, 2);
                        }
                        if (random.nextInt(3) > 0 && world.isEmpty(i + 1, j + n5, k - 1)) {
                            this.setTypeAndData(world, i + 1, j + n5, k - 1, Blocks.VINE, 1);
                        }
                    }
                }
                final Block type3 = world.getType(i + 1, j + n5, k + 1);
                if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i + 1, j + n5, k + 1, Blocks.LOG, this.b);
                    if (n5 > 0) {
                        if (random.nextInt(3) > 0 && world.isEmpty(i + 2, j + n5, k + 1)) {
                            this.setTypeAndData(world, i + 2, j + n5, k + 1, Blocks.VINE, 2);
                        }
                        if (random.nextInt(3) > 0 && world.isEmpty(i + 1, j + n5, k + 2)) {
                            this.setTypeAndData(world, i + 1, j + n5, k + 2, Blocks.VINE, 4);
                        }
                    }
                }
                final Block type4 = world.getType(i, j + n5, k + 1);
                if (type4.getMaterial() == Material.AIR || type4.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i, j + n5, k + 1, Blocks.LOG, this.b);
                    if (n5 > 0) {
                        if (random.nextInt(3) > 0 && world.isEmpty(i - 1, j + n5, k + 1)) {
                            this.setTypeAndData(world, i - 1, j + n5, k + 1, Blocks.VINE, 8);
                        }
                        if (random.nextInt(3) > 0 && world.isEmpty(i, j + n5, k + 2)) {
                            this.setTypeAndData(world, i, j + n5, k + 2, Blocks.VINE, 4);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private void c(final World world, final int i, final int k, final int n, final int n2, final Random random) {
        for (int j = n - 2; j <= n; ++j) {
            this.a(world, i, j, k, n2 + 1 - (j - n), random);
        }
    }
}
