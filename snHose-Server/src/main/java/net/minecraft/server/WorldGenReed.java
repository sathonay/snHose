package net.minecraft.server;

import java.util.*;

public class WorldGenReed extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int n, final int j, final int n2) {
        for (int i = 0; i < 20; ++i) {
            final int k = n + random.nextInt(4) - random.nextInt(4);
            final int l = n2 + random.nextInt(4) - random.nextInt(4);
            if (world.isEmpty(k, j, l) && (world.getType(k - 1, j - 1, l).getMaterial() == Material.WATER || world.getType(k + 1, j - 1, l).getMaterial() == Material.WATER || world.getType(k, j - 1, l - 1).getMaterial() == Material.WATER || world.getType(k, j - 1, l + 1).getMaterial() == Material.WATER)) {
                for (int n3 = 2 + random.nextInt(random.nextInt(3) + 1), n4 = 0; n4 < n3; ++n4) {
                    if (Blocks.SUGAR_CANE_BLOCK.j(world, k, j + n4, l)) {
                        world.setTypeAndData(k, j + n4, l, Blocks.SUGAR_CANE_BLOCK, 0, 2);
                    }
                }
            }
        }
        return true;
    }
}
