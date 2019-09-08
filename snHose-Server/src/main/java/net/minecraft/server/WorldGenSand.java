package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenSand extends WorldGenerator
{
    private Block a;
    private int b;
    
    public WorldGenSand(final Block a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        if (world.getType(i, j, k).getMaterial() != Material.WATER) {
            return false;
        }
        final int n = random.nextInt(this.b - 2) + 2;
        final int n2 = 2;
        for (int l = i - n; l <= i + n; ++l) {
            for (int n3 = k - n; n3 <= k + n; ++n3) {
                final int n4 = l - i;
                final int n5 = n3 - k;
                if (n4 * n4 + n5 * n5 <= n * n) {
                    for (int n6 = j - n2; n6 <= j + n2; ++n6) {
                        final Block type = world.getType(l, n6, n3);
                        if (type == Blocks.DIRT || type == Blocks.GRASS) {
                            world.setTypeAndData(l, n6, n3, this.a, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
