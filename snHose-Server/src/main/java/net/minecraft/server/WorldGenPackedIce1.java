package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenPackedIce1 extends WorldGenerator
{
    private Block a;
    private int b;
    
    public WorldGenPackedIce1(final int b) {
        this.a = Blocks.PACKED_ICE;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, int n2, final int n3) {
        while (world.isEmpty(n, n2, n3) && n2 > 2) {
            --n2;
        }
        if (world.getType(n, n2, n3) != Blocks.SNOW_BLOCK) {
            return false;
        }
        final int n4 = random.nextInt(this.b - 2) + 2;
        final int n5 = 1;
        for (int i = n - n4; i <= n + n4; ++i) {
            for (int j = n3 - n4; j <= n3 + n4; ++j) {
                final int n6 = i - n;
                final int n7 = j - n3;
                if (n6 * n6 + n7 * n7 <= n4 * n4) {
                    for (int k = n2 - n5; k <= n2 + n5; ++k) {
                        final Block type = world.getType(i, k, j);
                        if (type == Blocks.DIRT || type == Blocks.SNOW_BLOCK || type == Blocks.ICE) {
                            world.setTypeAndData(i, k, j, this.a, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
