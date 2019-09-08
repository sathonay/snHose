package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMelon extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = 0; i < 64; ++i) {
            final int j = n + random.nextInt(8) - random.nextInt(8);
            final int n4 = n2 + random.nextInt(4) - random.nextInt(4);
            final int k = n3 + random.nextInt(8) - random.nextInt(8);
            if (Blocks.MELON.canPlace(world, j, n4, k) && world.getType(j, n4 - 1, k) == Blocks.GRASS) {
                world.setTypeAndData(j, n4, k, Blocks.MELON, 0, 2);
            }
        }
        return true;
    }
}
