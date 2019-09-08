package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMinable extends WorldGenerator
{
    private Block a;
    private int b;
    private Block c;
    
    public WorldGenMinable(final Block block, final int n) {
        this(block, n, Blocks.STONE);
    }
    
    public WorldGenMinable(final Block a, final int b, final Block c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        final float n4 = random.nextFloat() * 3.1415927f;
        final double n5 = n + 8 + MathHelper.sin(n4) * this.b / 8.0f;
        final double n6 = n + 8 - MathHelper.sin(n4) * this.b / 8.0f;
        final double n7 = n3 + 8 + MathHelper.cos(n4) * this.b / 8.0f;
        final double n8 = n3 + 8 - MathHelper.cos(n4) * this.b / 8.0f;
        final double n9 = n2 + random.nextInt(3) - 2;
        final double n10 = n2 + random.nextInt(3) - 2;
        for (int i = 0; i <= this.b; ++i) {
            final double n11 = n5 + (n6 - n5) * i / this.b;
            final double n12 = n9 + (n10 - n9) * i / this.b;
            final double n13 = n7 + (n8 - n7) * i / this.b;
            final double n14 = random.nextDouble() * this.b / 16.0;
            final double n15 = (MathHelper.sin(i * 3.1415927f / this.b) + 1.0f) * n14 + 1.0;
            final double n16 = (MathHelper.sin(i * 3.1415927f / this.b) + 1.0f) * n14 + 1.0;
            final int floor = MathHelper.floor(n11 - n15 / 2.0);
            final int floor2 = MathHelper.floor(n12 - n16 / 2.0);
            final int floor3 = MathHelper.floor(n13 - n15 / 2.0);
            final int floor4 = MathHelper.floor(n11 + n15 / 2.0);
            final int floor5 = MathHelper.floor(n12 + n16 / 2.0);
            final int floor6 = MathHelper.floor(n13 + n15 / 2.0);
            for (int j = floor; j <= floor4; ++j) {
                final double n17 = (j + 0.5 - n11) / (n15 / 2.0);
                if (n17 * n17 < 1.0) {
                    for (int k = floor2; k <= floor5; ++k) {
                        final double n18 = (k + 0.5 - n12) / (n16 / 2.0);
                        if (n17 * n17 + n18 * n18 < 1.0) {
                            for (int l = floor3; l <= floor6; ++l) {
                                final double n19 = (l + 0.5 - n13) / (n15 / 2.0);
                                if (n17 * n17 + n18 * n18 + n19 * n19 < 1.0 && world.getType(j, k, l) == this.c) {
                                    world.setTypeAndData(j, k, l, this.a, 0, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
