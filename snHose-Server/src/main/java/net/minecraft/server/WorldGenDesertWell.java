package net.minecraft.server;

import java.util.*;

public class WorldGenDesertWell extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int i, int j, final int k) {
        while (world.isEmpty(i, j, k) && j > 2) {
            --j;
        }
        if (world.getType(i, j, k) != Blocks.SAND) {
            return false;
        }
        for (int l = -2; l <= 2; ++l) {
            for (int n = -2; n <= 2; ++n) {
                if (world.isEmpty(i + l, j - 1, k + n) && world.isEmpty(i + l, j - 2, k + n)) {
                    return false;
                }
            }
        }
        for (int n2 = -1; n2 <= 0; ++n2) {
            for (int n3 = -2; n3 <= 2; ++n3) {
                for (int n4 = -2; n4 <= 2; ++n4) {
                    world.setTypeAndData(i + n3, j + n2, k + n4, Blocks.SANDSTONE, 0, 2);
                }
            }
        }
        world.setTypeAndData(i, j, k, Blocks.WATER, 0, 2);
        world.setTypeAndData(i - 1, j, k, Blocks.WATER, 0, 2);
        world.setTypeAndData(i + 1, j, k, Blocks.WATER, 0, 2);
        world.setTypeAndData(i, j, k - 1, Blocks.WATER, 0, 2);
        world.setTypeAndData(i, j, k + 1, Blocks.WATER, 0, 2);
        for (int n5 = -2; n5 <= 2; ++n5) {
            for (int n6 = -2; n6 <= 2; ++n6) {
                if (n5 == -2 || n5 == 2 || n6 == -2 || n6 == 2) {
                    world.setTypeAndData(i + n5, j + 1, k + n6, Blocks.SANDSTONE, 0, 2);
                }
            }
        }
        world.setTypeAndData(i + 2, j + 1, k, Blocks.STEP, 1, 2);
        world.setTypeAndData(i - 2, j + 1, k, Blocks.STEP, 1, 2);
        world.setTypeAndData(i, j + 1, k + 2, Blocks.STEP, 1, 2);
        world.setTypeAndData(i, j + 1, k - 2, Blocks.STEP, 1, 2);
        for (int n7 = -1; n7 <= 1; ++n7) {
            for (int n8 = -1; n8 <= 1; ++n8) {
                if (n7 == 0 && n8 == 0) {
                    world.setTypeAndData(i + n7, j + 4, k + n8, Blocks.SANDSTONE, 0, 2);
                }
                else {
                    world.setTypeAndData(i + n7, j + 4, k + n8, Blocks.STEP, 1, 2);
                }
            }
        }
        for (int n9 = 1; n9 <= 3; ++n9) {
            world.setTypeAndData(i - 1, j + n9, k - 1, Blocks.SANDSTONE, 0, 2);
            world.setTypeAndData(i - 1, j + n9, k + 1, Blocks.SANDSTONE, 0, 2);
            world.setTypeAndData(i + 1, j + n9, k - 1, Blocks.SANDSTONE, 0, 2);
            world.setTypeAndData(i + 1, j + n9, k + 1, Blocks.SANDSTONE, 0, 2);
        }
        return true;
    }
}
