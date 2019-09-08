package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenLakes extends WorldGenerator
{
    private Block a;
    
    public WorldGenLakes(final Block a) {
        this.a = a;
    }
    
    @Override
    public boolean generate(final World world, final Random random, int i, int j, int k) {
        for (i -= 8, k -= 8; j > 5 && world.isEmpty(i, j, k); --j) {}
        if (j <= 4) {
            return false;
        }
        j -= 4;
        final boolean[] array = new boolean[2048];
        for (int n = random.nextInt(4) + 4, l = 0; l < n; ++l) {
            final double n2 = random.nextDouble() * 6.0 + 3.0;
            final double n3 = random.nextDouble() * 4.0 + 2.0;
            final double n4 = random.nextDouble() * 6.0 + 3.0;
            final double n5 = random.nextDouble() * (16.0 - n2 - 2.0) + 1.0 + n2 / 2.0;
            final double n6 = random.nextDouble() * (8.0 - n3 - 4.0) + 2.0 + n3 / 2.0;
            final double n7 = random.nextDouble() * (16.0 - n4 - 2.0) + 1.0 + n4 / 2.0;
            for (int n8 = 1; n8 < 15; ++n8) {
                for (int n9 = 1; n9 < 15; ++n9) {
                    for (int n10 = 1; n10 < 7; ++n10) {
                        final double n11 = (n8 - n5) / (n2 / 2.0);
                        final double n12 = (n10 - n6) / (n3 / 2.0);
                        final double n13 = (n9 - n7) / (n4 / 2.0);
                        if (n11 * n11 + n12 * n12 + n13 * n13 < 1.0) {
                            array[(n8 * 16 + n9) * 8 + n10] = true;
                        }
                    }
                }
            }
        }
        for (int n14 = 0; n14 < 16; ++n14) {
            for (int n15 = 0; n15 < 16; ++n15) {
                for (int n16 = 0; n16 < 8; ++n16) {
                    if (!array[(n14 * 16 + n15) * 8 + n16] && ((n14 < 15 && array[((n14 + 1) * 16 + n15) * 8 + n16]) || (n14 > 0 && array[((n14 - 1) * 16 + n15) * 8 + n16]) || (n15 < 15 && array[(n14 * 16 + (n15 + 1)) * 8 + n16]) || (n15 > 0 && array[(n14 * 16 + (n15 - 1)) * 8 + n16]) || (n16 < 7 && array[(n14 * 16 + n15) * 8 + (n16 + 1)]) || (n16 > 0 && array[(n14 * 16 + n15) * 8 + (n16 - 1)]))) {
                        final Material material = world.getType(i + n14, j + n16, k + n15).getMaterial();
                        if (n16 >= 4 && material.isLiquid()) {
                            return false;
                        }
                        if (n16 < 4 && !material.isBuildable() && world.getType(i + n14, j + n16, k + n15) != this.a) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int n17 = 0; n17 < 16; ++n17) {
            for (int n18 = 0; n18 < 16; ++n18) {
                for (int n19 = 0; n19 < 8; ++n19) {
                    if (array[(n17 * 16 + n18) * 8 + n19]) {
                        world.setTypeAndData(i + n17, j + n19, k + n18, (n19 >= 4) ? Blocks.AIR : this.a, 0, 2);
                    }
                }
            }
        }
        for (int n20 = 0; n20 < 16; ++n20) {
            for (int n21 = 0; n21 < 16; ++n21) {
                for (int n22 = 4; n22 < 8; ++n22) {
                    if (array[(n20 * 16 + n21) * 8 + n22] && world.getType(i + n20, j + n22 - 1, k + n21) == Blocks.DIRT && world.b(EnumSkyBlock.SKY, i + n20, j + n22, k + n21) > 0) {
                        if (world.getBiome(i + n20, k + n21).ai == Blocks.MYCEL) {
                            world.setTypeAndData(i + n20, j + n22 - 1, k + n21, Blocks.MYCEL, 0, 2);
                        }
                        else {
                            world.setTypeAndData(i + n20, j + n22 - 1, k + n21, Blocks.GRASS, 0, 2);
                        }
                    }
                }
            }
        }
        if (this.a.getMaterial() == Material.LAVA) {
            for (int n23 = 0; n23 < 16; ++n23) {
                for (int n24 = 0; n24 < 16; ++n24) {
                    for (int n25 = 0; n25 < 8; ++n25) {
                        if (!array[(n23 * 16 + n24) * 8 + n25] && ((n23 < 15 && array[((n23 + 1) * 16 + n24) * 8 + n25]) || (n23 > 0 && array[((n23 - 1) * 16 + n24) * 8 + n25]) || (n24 < 15 && array[(n23 * 16 + (n24 + 1)) * 8 + n25]) || (n24 > 0 && array[(n23 * 16 + (n24 - 1)) * 8 + n25]) || (n25 < 7 && array[(n23 * 16 + n24) * 8 + (n25 + 1)]) || (n25 > 0 && array[(n23 * 16 + n24) * 8 + (n25 - 1)])) && (n25 < 4 || random.nextInt(2) != 0) && world.getType(i + n23, j + n25, k + n24).getMaterial().isBuildable()) {
                            world.setTypeAndData(i + n23, j + n25, k + n24, Blocks.STONE, 0, 2);
                        }
                    }
                }
            }
        }
        if (this.a.getMaterial() == Material.WATER) {
            for (int n26 = 0; n26 < 16; ++n26) {
                for (int n27 = 0; n27 < 16; ++n27) {
                    final int n28 = 4;
                    if (world.r(i + n26, j + n28, k + n27)) {
                        world.setTypeAndData(i + n26, j + n28, k + n27, Blocks.ICE, 0, 2);
                    }
                }
            }
        }
        return true;
    }
}
