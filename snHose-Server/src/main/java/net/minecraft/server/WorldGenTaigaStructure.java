package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenTaigaStructure extends WorldGenerator
{
    private Block a;
    private int b;
    
    public WorldGenTaigaStructure(final Block a, final int b) {
        super(false);
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World world, final Random random, int n, int i, int n2) {
        while (i > 3) {
            if (!world.isEmpty(n, i - 1, n2)) {
                final Block type = world.getType(n, i - 1, n2);
                if (type == Blocks.GRASS || type == Blocks.DIRT) {
                    break;
                }
                if (type == Blocks.STONE) {
                    break;
                }
            }
            --i;
        }
        if (i <= 3) {
            return false;
        }
        for (int b = this.b, n3 = 0; b >= 0 && n3 < 3; ++n3) {
            final int n4 = b + random.nextInt(2);
            final int n5 = b + random.nextInt(2);
            final int n6 = b + random.nextInt(2);
            final float n7 = (n4 + n5 + n6) * 0.333f + 0.5f;
            for (int j = n - n4; j <= n + n4; ++j) {
                for (int k = n2 - n6; k <= n2 + n6; ++k) {
                    for (int l = i - n5; l <= i + n5; ++l) {
                        final float n8 = j - n;
                        final float n9 = k - n2;
                        final float n10 = l - i;
                        if (n8 * n8 + n9 * n9 + n10 * n10 <= n7 * n7) {
                            world.setTypeAndData(j, l, k, this.a, 0, 4);
                        }
                    }
                }
            }
            n += -(b + 1) + random.nextInt(2 + b * 2);
            n2 += -(b + 1) + random.nextInt(2 + b * 2);
            i += 0 - random.nextInt(2);
        }
        return true;
    }
}
