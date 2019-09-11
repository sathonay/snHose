package net.minecraft.server;

import java.util.*;

public class WorldGenTallPlant extends WorldGenerator
{
    private int a;
    
    public void a(final int a) {
        this.a = a;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        boolean b = false;
        for (int i = 0; i < 64; ++i) {
            final int j = n + random.nextInt(8) - random.nextInt(8);
            final int k = n2 + random.nextInt(4) - random.nextInt(4);
            final int l = n3 + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(j, k, l) && (!world.worldProvider.g || k < 254) && Blocks.DOUBLE_PLANT.canPlace(world, j, k, l)) {
                Blocks.DOUBLE_PLANT.c(world, j, k, l, this.a, 2);
                b = true;
            }
        }
        return b;
    }
}
