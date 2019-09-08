package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVillageButcher extends WorldGenVillagePiece
{
    public WorldGenVillageButcher() {
    }
    
    public WorldGenVillageButcher(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
    }
    
    public static WorldGenVillageButcher a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 9, 7, 11, n4);
        if (!WorldGenVillagePiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageButcher(worldGenVillageStartPiece, n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureboundingbox) {
        if (this.k < 0) {
            this.k = this.b(world, structureboundingbox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 7 - 1, 0);
        }
        this.a(world, structureboundingbox, 1, 1, 1, 7, 4, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureboundingbox, 2, 1, 6, 8, 4, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureboundingbox, 2, 0, 6, 8, 0, 10, Blocks.DIRT, Blocks.DIRT, false);
        this.a(world, Blocks.COBBLESTONE, 0, 6, 0, 6, structureboundingbox);
        this.a(world, structureboundingbox, 2, 1, 6, 2, 1, 10, Blocks.FENCE, Blocks.FENCE, false);
        this.a(world, structureboundingbox, 8, 1, 6, 8, 1, 10, Blocks.FENCE, Blocks.FENCE, false);
        this.a(world, structureboundingbox, 3, 1, 10, 7, 1, 10, Blocks.FENCE, Blocks.FENCE, false);
        this.a(world, structureboundingbox, 1, 0, 1, 7, 0, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 8, 0, 0, 8, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 1, 0, 0, 7, 1, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 1, 0, 5, 7, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 1, 2, 0, 7, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 2, 5, 7, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 4, 1, 8, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 4, 4, 8, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 5, 2, 8, 5, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, Blocks.WOOD, 0, 0, 4, 2, structureboundingbox);
        this.a(world, Blocks.WOOD, 0, 0, 4, 3, structureboundingbox);
        this.a(world, Blocks.WOOD, 0, 8, 4, 2, structureboundingbox);
        this.a(world, Blocks.WOOD, 0, 8, 4, 3, structureboundingbox);
        final int a = this.a(Blocks.WOOD_STAIRS, 3);
        final int a2 = this.a(Blocks.WOOD_STAIRS, 2);
        for (int i = -1; i <= 2; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this.a(world, Blocks.WOOD_STAIRS, a, j, 4 + i, i, structureboundingbox);
                this.a(world, Blocks.WOOD_STAIRS, a2, j, 4 + i, 5 - i, structureboundingbox);
            }
        }
        this.a(world, Blocks.LOG, 0, 0, 2, 1, structureboundingbox);
        this.a(world, Blocks.LOG, 0, 0, 2, 4, structureboundingbox);
        this.a(world, Blocks.LOG, 0, 8, 2, 1, structureboundingbox);
        this.a(world, Blocks.LOG, 0, 8, 2, 4, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 5, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 3, 2, 5, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 2, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 6, 2, 5, structureboundingbox);
        this.a(world, Blocks.FENCE, 0, 2, 1, 3, structureboundingbox);
        this.a(world, Blocks.WOOD_PLATE, 0, 2, 2, 3, structureboundingbox);
        this.a(world, Blocks.WOOD, 0, 1, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, this.a(Blocks.WOOD_STAIRS, 3), 2, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, this.a(Blocks.WOOD_STAIRS, 1), 1, 1, 3, structureboundingbox);
        this.a(world, structureboundingbox, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STEP, Blocks.DOUBLE_STEP, false);
        this.a(world, Blocks.DOUBLE_STEP, 0, 6, 1, 1, structureboundingbox);
        this.a(world, Blocks.DOUBLE_STEP, 0, 6, 1, 2, structureboundingbox);
        this.a(world, Blocks.AIR, 0, 2, 1, 0, structureboundingbox);
        this.a(world, Blocks.AIR, 0, 2, 2, 0, structureboundingbox);
        this.a(world, Blocks.TORCH, 0, 2, 3, 1, structureboundingbox);
        this.a(world, structureboundingbox, random, 2, 1, 0, this.a(Blocks.WOODEN_DOOR, 1));
        if (this.a(world, 2, 0, -1, structureboundingbox).getMaterial() == Material.AIR && this.a(world, 2, -1, -1, structureboundingbox).getMaterial() != Material.AIR) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, this.a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, structureboundingbox);
        }
        this.a(world, Blocks.AIR, 0, 6, 1, 5, structureboundingbox);
        this.a(world, Blocks.AIR, 0, 6, 2, 5, structureboundingbox);
        this.a(world, Blocks.TORCH, 0, 6, 3, 4, structureboundingbox);
        this.a(world, structureboundingbox, random, 6, 1, 5, this.a(Blocks.WOODEN_DOOR, 1));
        for (int k = 0; k < 5; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.b(world, l, 7, k, structureboundingbox);
                this.b(world, Blocks.COBBLESTONE, 0, l, -1, k, structureboundingbox);
            }
        }
        this.a(world, structureboundingbox, 4, 1, 2, 2);
        return true;
    }
    
    @Override
    protected int b(final int n) {
        if (n == 0) {
            return 4;
        }
        return 0;
    }
}
