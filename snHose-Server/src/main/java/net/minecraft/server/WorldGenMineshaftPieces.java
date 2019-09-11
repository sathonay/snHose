package net.minecraft.server;

import java.util.*;

public class WorldGenMineshaftPieces
{
    private static final StructurePieceTreasure[] a;
    
    public static void a() {
        WorldGenFactory.a(WorldGenMineshaftCorridor.class, "MSCorridor");
        WorldGenFactory.a(WorldGenMineshaftCross.class, "MSCrossing");
        WorldGenFactory.a(WorldGenMineshaftRoom.class, "MSRoom");
        WorldGenFactory.a(WorldGenMineshaftStairs.class, "MSStairs");
    }
    
    private static StructurePiece a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final int nextInt = random.nextInt(100);
        if (nextInt >= 80) {
            final StructureBoundingBox a = WorldGenMineshaftCross.a(list, random, n, n2, n3, n4);
            if (a != null) {
                return new WorldGenMineshaftCross(n5, random, a, n4);
            }
        }
        else if (nextInt >= 70) {
            final StructureBoundingBox a2 = WorldGenMineshaftStairs.a(list, random, n, n2, n3, n4);
            if (a2 != null) {
                return new WorldGenMineshaftStairs(n5, random, a2, n4);
            }
        }
        else {
            final StructureBoundingBox a3 = WorldGenMineshaftCorridor.a(list, random, n, n2, n3, n4);
            if (a3 != null) {
                return new WorldGenMineshaftCorridor(n5, random, a3, n4);
            }
        }
        return null;
    }
    
    private static StructurePiece b(final StructurePiece structurePiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 > 8) {
            return null;
        }
        if (Math.abs(n - structurePiece.c().a) > 80 || Math.abs(n3 - structurePiece.c().c) > 80) {
            return null;
        }
        final StructurePiece a = a(list, random, n, n2, n3, n4, n5 + 1);
        if (a != null) {
            list.add(a);
            a.a(structurePiece, list, random);
        }
        return a;
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.INK_SACK, 4, 4, 9, 5), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 2, 3), new StructurePieceTreasure(Items.COAL, 0, 3, 8, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 1), new StructurePieceTreasure(Item.getItemOf(Blocks.RAILS), 0, 4, 8, 1), new StructurePieceTreasure(Items.MELON_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.PUMPKIN_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1) };
    }
}
