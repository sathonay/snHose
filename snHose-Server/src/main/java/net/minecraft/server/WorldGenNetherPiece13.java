package net.minecraft.server;

import java.util.*;

public class WorldGenNetherPiece13 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece13() {
    }
    
    public WorldGenNetherPiece13(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenNetherPiece15)structurePiece, list, random, 2, 0, false);
        this.b((WorldGenNetherPiece15)structurePiece, list, random, 0, 2, false);
        this.c((WorldGenNetherPiece15)structurePiece, list, random, 0, 2, false);
    }
    
    public static WorldGenNetherPiece13 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -2, 0, 0, 7, 9, 7, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece13(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 6, 7, 6, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 5, 0, 4, 5, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 5, 6, 4, 5, 6, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 5, 2, 0, 5, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 5, 2, 6, 5, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
