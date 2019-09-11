package net.minecraft.server;

import java.util.*;

public class WorldGenLightStone2 extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int i, final int n, final int k) {
        if (!world.isEmpty(i, n, k)) {
            return false;
        }
        if (world.getType(i, n + 1, k) != Blocks.NETHERRACK) {
            return false;
        }
        world.setTypeAndData(i, n, k, Blocks.GLOWSTONE, 0, 2);
        for (int j = 0; j < 1500; ++j) {
            final int n2 = i + random.nextInt(8) - random.nextInt(8);
            final int n3 = n - random.nextInt(12);
            final int n4 = k + random.nextInt(8) - random.nextInt(8);
            if (world.getType(n2, n3, n4).getMaterial() == Material.AIR) {
                int n5 = 0;
                for (int l = 0; l < 6; ++l) {
                    Block block = null;
                    if (l == 0) {
                        block = world.getType(n2 - 1, n3, n4);
                    }
                    if (l == 1) {
                        block = world.getType(n2 + 1, n3, n4);
                    }
                    if (l == 2) {
                        block = world.getType(n2, n3 - 1, n4);
                    }
                    if (l == 3) {
                        block = world.getType(n2, n3 + 1, n4);
                    }
                    if (l == 4) {
                        block = world.getType(n2, n3, n4 - 1);
                    }
                    if (l == 5) {
                        block = world.getType(n2, n3, n4 + 1);
                    }
                    if (block == Blocks.GLOWSTONE) {
                        ++n5;
                    }
                }
                if (n5 == 1) {
                    world.setTypeAndData(n2, n3, n4, Blocks.GLOWSTONE, 0, 2);
                }
            }
        }
        return true;
    }
}
