package net.minecraft.server;

import java.util.*;

public class WorldGenFire extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = 0; i < 64; ++i) {
            final int j = n + random.nextInt(8) - random.nextInt(8);
            final int n4 = n2 + random.nextInt(4) - random.nextInt(4);
            final int k = n3 + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(j, n4, k)) {
                if (world.getType(j, n4 - 1, k) == Blocks.NETHERRACK) {
                    world.setTypeAndData(j, n4, k, Blocks.FIRE, 0, 2);
                }
            }
        }
        return true;
    }
}
