package net.minecraft.server;

import java.util.*;

public class WorldGenVillageLibrary extends WorldGenVillagePiece
{
    public WorldGenVillageLibrary() {
    }
    
    public WorldGenVillageLibrary(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
    }
    
    public static WorldGenVillageLibrary a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 9, 9, 6, n4);
        if (!WorldGenVillagePiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageLibrary(worldGenVillageStartPiece, n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureboundingbox) {
        if (this.k < 0) {
            this.k = this.b(world, structureboundingbox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 9 - 1, 0);
        }
        this.a(world, structureboundingbox, 1, 1, 1, 7, 5, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureboundingbox, 0, 0, 0, 8, 0, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 5, 0, 8, 5, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 6, 1, 8, 6, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 7, 2, 8, 7, 3, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        final int a = this.a(Blocks.WOOD_STAIRS, 3);
        final int a2 = this.a(Blocks.WOOD_STAIRS, 2);
        for (int i = -1; i <= 2; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this.a(world, Blocks.WOOD_STAIRS, a, j, 6 + i, i, structureboundingbox);
                this.a(world, Blocks.WOOD_STAIRS, a2, j, 6 + i, 5 - i, structureboundingbox);
            }
        }
        this.a(world, structureboundingbox, 0, 1, 0, 0, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 1, 1, 5, 8, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 8, 1, 0, 8, 1, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 2, 1, 0, 7, 1, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 2, 0, 0, 4, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 2, 5, 0, 4, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 8, 2, 5, 8, 4, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 8, 2, 0, 8, 4, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 2, 1, 0, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 2, 5, 7, 4, 5, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 8, 2, 1, 8, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 2, 0, 7, 4, 0, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, Blocks.THIN_GLASS, 0, 4, 2, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 2, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 6, 2, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 4, 3, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 3, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 6, 3, 0, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 3, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 3, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 2, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 3, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 8, 3, 3, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 5, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 3, 2, 5, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 5, 2, 5, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 6, 2, 5, structureboundingbox);
        this.a(world, structureboundingbox, 1, 4, 1, 7, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 4, 4, 7, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
        this.a(world, Blocks.WOOD, 0, 7, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, this.a(Blocks.WOOD_STAIRS, 0), 7, 1, 3, structureboundingbox);
        final int a3 = this.a(Blocks.WOOD_STAIRS, 3);
        this.a(world, Blocks.WOOD_STAIRS, a3, 6, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, a3, 5, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, a3, 4, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, a3, 3, 1, 4, structureboundingbox);
        this.a(world, Blocks.FENCE, 0, 6, 1, 3, structureboundingbox);
        this.a(world, Blocks.WOOD_PLATE, 0, 6, 2, 3, structureboundingbox);
        this.a(world, Blocks.FENCE, 0, 4, 1, 3, structureboundingbox);
        this.a(world, Blocks.WOOD_PLATE, 0, 4, 2, 3, structureboundingbox);
        this.a(world, Blocks.WORKBENCH, 0, 7, 1, 1, structureboundingbox);
        this.a(world, Blocks.AIR, 0, 1, 1, 0, structureboundingbox);
        this.a(world, Blocks.AIR, 0, 1, 2, 0, structureboundingbox);
        this.a(world, structureboundingbox, random, 1, 1, 0, this.a(Blocks.WOODEN_DOOR, 1));
        if (this.a(world, 1, 0, -1, structureboundingbox).getMaterial() == Material.AIR && this.a(world, 1, -1, -1, structureboundingbox).getMaterial() != Material.AIR) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, this.a(Blocks.COBBLESTONE_STAIRS, 3), 1, 0, -1, structureboundingbox);
        }
        for (int k = 0; k < 6; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.b(world, l, 9, k, structureboundingbox);
                this.b(world, Blocks.COBBLESTONE, 0, l, -1, k, structureboundingbox);
            }
        }
        this.a(world, structureboundingbox, 2, 1, 2, 1);
        return true;
    }
    
    @Override
    protected int b(final int n) {
        return 1;
    }
}
