package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVines extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, int i, int j, int k) {
        final int n = i;
        final int n2 = k;
        while (j < 128) {
            if (world.isEmpty(i, j, k)) {
                for (int l = 2; l <= 5; ++l) {
                    if (Blocks.VINE.canPlace(world, i, j, k, l)) {
                        world.setTypeAndData(i, j, k, Blocks.VINE, 1 << Direction.e[Facing.OPPOSITE_FACING[l]], 2);
                        break;
                    }
                }
            }
            else {
                i = n + random.nextInt(4) - random.nextInt(4);
                k = n2 + random.nextInt(4) - random.nextInt(4);
            }
            ++j;
        }
        return true;
    }
}
