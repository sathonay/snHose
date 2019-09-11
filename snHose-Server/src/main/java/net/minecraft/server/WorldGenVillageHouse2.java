package net.minecraft.server;

import java.util.*;

public class WorldGenVillageHouse2 extends WorldGenVillagePiece
{
    public WorldGenVillageHouse2() {
    }
    
    public WorldGenVillageHouse2(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
    }
    
    public static WorldGenVillageHouse2 a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 9, 7, 12, n4);
        if (!WorldGenVillagePiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageHouse2(worldGenVillageStartPiece, n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.k < 0) {
            this.k = this.b(world, structureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 7 - 1, 0);
        }
        this.a(world, structureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 2, 0, 5, 8, 0, 10, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 8, 0, 0, 8, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 1, 0, 0, 7, 2, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 1, 0, 5, 2, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 2, 0, 6, 2, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 3, 0, 10, 7, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 1, 2, 5, 2, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 0, 4, 1, 8, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 0, 4, 4, 3, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 0, 5, 2, 8, 5, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, Blocks.WOOD, 0, 0, 4, 2, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 0, 4, 3, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 8, 4, 2, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 8, 4, 3, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 8, 4, 4, structureBoundingBox);
        final int a = this.a(Blocks.WOOD_STAIRS, 3);
        final int a2 = this.a(Blocks.WOOD_STAIRS, 2);
        for (int i = -1; i <= 2; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this.a(world, Blocks.WOOD_STAIRS, a, j, 4 + i, i, structureBoundingBox);
                if ((i > -1 || j <= 1) && (i > 0 || j <= 3) && (i > 1 || j <= 4 || j >= 6)) {
                    this.a(world, Blocks.WOOD_STAIRS, a2, j, 4 + i, 5 - i, structureBoundingBox);
                }
            }
        }
        this.a(world, structureBoundingBox, 3, 4, 5, 3, 4, 10, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 7, 4, 2, 7, 4, 10, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 4, 5, 4, 4, 5, 10, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 6, 5, 4, 6, 5, 10, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 5, 6, 3, 5, 6, 10, Blocks.WOOD, Blocks.WOOD, false);
        final int a3 = this.a(Blocks.WOOD_STAIRS, 0);
        for (int k = 4; k >= 1; --k) {
            this.a(world, Blocks.WOOD, 0, k, 2 + k, 7 - k, structureBoundingBox);
            for (int l = 8 - k; l <= 10; ++l) {
                this.a(world, Blocks.WOOD_STAIRS, a3, k, 2 + k, l, structureBoundingBox);
            }
        }
        final int a4 = this.a(Blocks.WOOD_STAIRS, 1);
        this.a(world, Blocks.WOOD, 0, 6, 6, 3, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 7, 5, 4, structureBoundingBox);
        this.a(world, Blocks.WOOD_STAIRS, a4, 6, 6, 4, structureBoundingBox);
        for (int m = 6; m <= 8; ++m) {
            for (int l2 = 5; l2 <= 10; ++l2) {
                this.a(world, Blocks.WOOD_STAIRS, a4, m, 12 - m, l2, structureBoundingBox);
            }
        }
        this.a(world, Blocks.LOG, 0, 0, 2, 1, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 0, 2, 4, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 3, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 4, 2, 0, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 2, 0, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 6, 2, 0, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 8, 2, 1, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 2, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 3, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 8, 2, 4, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 8, 2, 5, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 8, 2, 6, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 7, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 8, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 8, 2, 9, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 2, 2, 6, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 7, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 8, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 2, 2, 9, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 4, 4, 10, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 4, 10, structureBoundingBox);
        this.a(world, Blocks.LOG, 0, 6, 4, 10, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 5, 5, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 2, 1, 0, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 2, 2, 0, structureBoundingBox);
        this.a(world, Blocks.TORCH, 0, 2, 3, 1, structureBoundingBox);
        this.a(world, structureBoundingBox, random, 2, 1, 0, this.a(Blocks.WOODEN_DOOR, 1));
        this.a(world, structureBoundingBox, 1, 0, -1, 3, 2, -1, Blocks.AIR, Blocks.AIR, false);
        if (this.a(world, 2, 0, -1, structureBoundingBox).getMaterial() == Material.AIR && this.a(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.AIR) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, this.a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, structureBoundingBox);
        }
        for (int l3 = 0; l3 < 5; ++l3) {
            for (int j2 = 0; j2 < 9; ++j2) {
                this.b(world, j2, 7, l3, structureBoundingBox);
                this.b(world, Blocks.COBBLESTONE, 0, j2, -1, l3, structureBoundingBox);
            }
        }
        for (int l4 = 5; l4 < 11; ++l4) {
            for (int j3 = 2; j3 < 9; ++j3) {
                this.b(world, j3, 7, l4, structureBoundingBox);
                this.b(world, Blocks.COBBLESTONE, 0, j3, -1, l4, structureBoundingBox);
            }
        }
        this.a(world, structureBoundingBox, 4, 1, 2, 2);
        return true;
    }
}
