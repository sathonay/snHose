package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenFlowers extends WorldGenerator
{
    private Block a;
    private int b;
    
    public WorldGenFlowers(final Block a) {
        this.a = a;
    }
    
    public void a(final Block a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        for (int i = 0; i < 64; ++i) {
            final int j = n + random.nextInt(8) - random.nextInt(8);
            final int k = n2 + random.nextInt(4) - random.nextInt(4);
            final int l = n3 + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(j, k, l) && (!world.worldProvider.g || k < 255) && this.a.j(world, j, k, l)) {
                world.setTypeAndData(j, k, l, this.a, this.b, 2);
            }
        }
        return true;
    }
}
