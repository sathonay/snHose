package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMegaTree extends WorldGenMegaTreeAbstract
{
    private boolean e;
    
    public WorldGenMegaTree(final boolean flag, final boolean e) {
        super(flag, 13, 15, 1, 1);
        this.e = e;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        final int a = this.a(random);
        if (!this.a(world, random, i, j, k, a)) {
            return false;
        }
        this.c(world, i, k, j + a, 0, random);
        for (int l = 0; l < a; ++l) {
            final Block type = world.getType(i, j + l, k);
            if (type.getMaterial() == Material.AIR || type.getMaterial() == Material.LEAVES) {
                this.setTypeAndData(world, i, j + l, k, Blocks.LOG, this.b);
            }
            if (l < a - 1) {
                final Block type2 = world.getType(i + 1, j + l, k);
                if (type2.getMaterial() == Material.AIR || type2.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i + 1, j + l, k, Blocks.LOG, this.b);
                }
                final Block type3 = world.getType(i + 1, j + l, k + 1);
                if (type3.getMaterial() == Material.AIR || type3.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i + 1, j + l, k + 1, Blocks.LOG, this.b);
                }
                final Block type4 = world.getType(i, j + l, k + 1);
                if (type4.getMaterial() == Material.AIR || type4.getMaterial() == Material.LEAVES) {
                    this.setTypeAndData(world, i, j + l, k + 1, Blocks.LOG, this.b);
                }
            }
        }
        return true;
    }
    
    private void c(final World world, final int i, final int k, final int n, final int n2, final Random random) {
        int nextInt = random.nextInt(5);
        if (this.e) {
            nextInt += this.a;
        }
        else {
            nextInt += 3;
        }
        int n3 = 0;
        for (int j = n - nextInt; j <= n; ++j) {
            final int n4 = n - j;
            final int n5 = n2 + MathHelper.d(n4 / nextInt * 3.5f);
            this.a(world, i, j, k, n5 + ((n4 > 0 && n5 == n3 && (j & 0x1) == 0x0) ? 1 : 0), random);
            n3 = n5;
        }
    }
    
    @Override
    public void b(final World world, final Random random, final int n, final int n2, final int n3) {
        this.c(world, random, n - 1, n2, n3 - 1);
        this.c(world, random, n + 2, n2, n3 - 1);
        this.c(world, random, n - 1, n2, n3 + 2);
        this.c(world, random, n + 2, n2, n3 + 2);
        for (int i = 0; i < 5; ++i) {
            final int nextInt = random.nextInt(64);
            final int n4 = nextInt % 8;
            final int n5 = nextInt / 8;
            if (n4 == 0 || n4 == 7 || n5 == 0 || n5 == 7) {
                this.c(world, random, n - 3 + n4, n2, n3 - 3 + n5);
            }
        }
    }
    
    private void c(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                if (Math.abs(i) != 2 || Math.abs(j) != 2) {
                    this.a(world, n + i, n2, n3 + j);
                }
            }
        }
    }
    
    private void a(final World world, final int i, final int n, final int k) {
        for (int j = n + 2; j >= n - 3; --j) {
            final Block type = world.getType(i, j, k);
            if (type == Blocks.GRASS || type == Blocks.DIRT) {
                this.setTypeAndData(world, i, j, k, Blocks.DIRT, 2);
                break;
            }
            if (type.getMaterial() != Material.AIR && j < n) {
                break;
            }
        }
    }
}
