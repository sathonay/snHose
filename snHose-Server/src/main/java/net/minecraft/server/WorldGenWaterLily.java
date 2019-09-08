package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenWaterLily extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = 0; i < 10; ++i) {
            final int j = n + random.nextInt(8) - random.nextInt(8);
            final int k = n2 + random.nextInt(4) - random.nextInt(4);
            final int l = n3 + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(j, k, l) && Blocks.WATER_LILY.canPlace(world, j, k, l)) {
                world.setTypeAndData(j, k, l, Blocks.WATER_LILY, 0, 2);
            }
        }
        return true;
    }
}
