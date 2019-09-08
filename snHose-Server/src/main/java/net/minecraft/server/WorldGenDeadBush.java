package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenDeadBush extends WorldGenerator
{
    private Block a;
    
    public WorldGenDeadBush(final Block a) {
        this.a = a;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, int j, final int k) {
        Block type;
        while (((type = world.getType(i, j, k)).getMaterial() == Material.AIR || type.getMaterial() == Material.LEAVES) && j > 0) {
            --j;
        }
        for (int l = 0; l < 4; ++l) {
            final int m = i + random.nextInt(8) - random.nextInt(8);
            final int j2 = j + random.nextInt(4) - random.nextInt(4);
            final int k2 = k + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(m, j2, k2) && this.a.j(world, m, j2, k2)) {
                world.setTypeAndData(m, j2, k2, this.a, 0, 2);
            }
        }
        return true;
    }
}
