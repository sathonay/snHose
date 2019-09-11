package net.minecraft.server;

import java.util.*;

public class WorldGenPumpkin extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = 0; i < 64; ++i) {
            final int n4 = n + random.nextInt(8) - random.nextInt(8);
            final int j = n2 + random.nextInt(4) - random.nextInt(4);
            final int n5 = n3 + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(n4, j, n5) && world.getType(n4, j - 1, n5) == Blocks.GRASS && Blocks.PUMPKIN.canPlace(world, n4, j, n5)) {
                world.setTypeAndData(n4, j, n5, Blocks.PUMPKIN, random.nextInt(4), 2);
            }
        }
        return true;
    }
}
