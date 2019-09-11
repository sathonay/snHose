package net.minecraft.server;

import java.util.*;

public class WorldGenDungeons extends WorldGenerator
{
    private static final StructurePieceTreasure[] a;
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int j, final int n2) {
        final int n3 = 3;
        final int n4 = random.nextInt(2) + 2;
        final int n5 = random.nextInt(2) + 2;
        int n6 = 0;
        for (int i = n - n4 - 1; i <= n + n4 + 1; ++i) {
            for (int k = j - 1; k <= j + n3 + 1; ++k) {
                for (int l = n2 - n5 - 1; l <= n2 + n5 + 1; ++l) {
                    final Material material = world.getType(i, k, l).getMaterial();
                    if (k == j - 1 && !material.isBuildable()) {
                        return false;
                    }
                    if (k == j + n3 + 1 && !material.isBuildable()) {
                        return false;
                    }
                    if ((i == n - n4 - 1 || i == n + n4 + 1 || l == n2 - n5 - 1 || l == n2 + n5 + 1) && k == j && world.isEmpty(i, k, l) && world.isEmpty(i, k + 1, l)) {
                        ++n6;
                    }
                }
            }
        }
        if (n6 < 1 || n6 > 5) {
            return false;
        }
        for (int n7 = n - n4 - 1; n7 <= n + n4 + 1; ++n7) {
            for (int m = j + n3; m >= j - 1; --m) {
                for (int n8 = n2 - n5 - 1; n8 <= n2 + n5 + 1; ++n8) {
                    if (n7 == n - n4 - 1 || m == j - 1 || n8 == n2 - n5 - 1 || n7 == n + n4 + 1 || m == j + n3 + 1 || n8 == n2 + n5 + 1) {
                        if (m >= 0 && !world.getType(n7, m - 1, n8).getMaterial().isBuildable()) {
                            world.setAir(n7, m, n8);
                        }
                        else if (world.getType(n7, m, n8).getMaterial().isBuildable()) {
                            if (m == j - 1 && random.nextInt(4) != 0) {
                                world.setTypeAndData(n7, m, n8, Blocks.MOSSY_COBBLESTONE, 0, 2);
                            }
                            else {
                                world.setTypeAndData(n7, m, n8, Blocks.COBBLESTONE, 0, 2);
                            }
                        }
                    }
                    else {
                        world.setAir(n7, m, n8);
                    }
                }
            }
        }
        for (int n9 = 0; n9 < 2; ++n9) {
            for (int n10 = 0; n10 < 3; ++n10) {
                final int i2 = n + random.nextInt(n4 * 2 + 1) - n4;
                final int k2 = n2 + random.nextInt(n5 * 2 + 1) - n5;
                if (world.isEmpty(i2, j, k2)) {
                    int n11 = 0;
                    if (world.getType(i2 - 1, j, k2).getMaterial().isBuildable()) {
                        ++n11;
                    }
                    if (world.getType(i2 + 1, j, k2).getMaterial().isBuildable()) {
                        ++n11;
                    }
                    if (world.getType(i2, j, k2 - 1).getMaterial().isBuildable()) {
                        ++n11;
                    }
                    if (world.getType(i2, j, k2 + 1).getMaterial().isBuildable()) {
                        ++n11;
                    }
                    if (n11 == 1) {
                        world.setTypeAndData(i2, j, k2, Blocks.CHEST, 0, 2);
                        final StructurePieceTreasure[] a = StructurePieceTreasure.a(WorldGenDungeons.a, Items.ENCHANTED_BOOK.b(random));
                        final TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(i2, j, k2);
                        if (tileEntityChest != null) {
                            StructurePieceTreasure.a(random, a, tileEntityChest, 8);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        world.setTypeAndData(n, j, n2, Blocks.MOB_SPAWNER, 0, 2);
        final TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)world.getTileEntity(n, j, n2);
        if (tileEntityMobSpawner != null) {
            tileEntityMobSpawner.getSpawner().setMobName(this.a(random));
        }
        else {
            System.err.println("Failed to fetch mob spawner entity at (" + n + ", " + j + ", " + n2 + ")");
        }
        return true;
    }
    
    private String a(final Random random) {
        final int nextInt = random.nextInt(4);
        if (nextInt == 0) {
            return "Skeleton";
        }
        if (nextInt == 1) {
            return "Zombie";
        }
        if (nextInt == 2) {
            return "Zombie";
        }
        if (nextInt == 3) {
            return "Spider";
        }
        return "";
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 10), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 4, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 1, 10), new StructurePieceTreasure(Items.WHEAT, 0, 1, 4, 10), new StructurePieceTreasure(Items.SULPHUR, 0, 1, 4, 10), new StructurePieceTreasure(Items.STRING, 0, 1, 4, 10), new StructurePieceTreasure(Items.BUCKET, 0, 1, 1, 10), new StructurePieceTreasure(Items.GOLDEN_APPLE, 0, 1, 1, 1), new StructurePieceTreasure(Items.REDSTONE, 0, 1, 4, 10), new StructurePieceTreasure(Items.RECORD_1, 0, 1, 1, 10), new StructurePieceTreasure(Items.RECORD_2, 0, 1, 1, 10), new StructurePieceTreasure(Items.NAME_TAG, 0, 1, 1, 10), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 2), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 5), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1) };
    }
}
