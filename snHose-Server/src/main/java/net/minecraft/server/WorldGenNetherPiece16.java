package net.minecraft.server;

import java.util.*;

public class WorldGenNetherPiece16 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece16() {
    }
    
    public WorldGenNetherPiece16(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.c((WorldGenNetherPiece15)structurePiece, list, random, 6, 2, false);
    }
    
    public static WorldGenNetherPiece16 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -2, 0, 0, 7, 11, 7, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece16(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 6, 10, 6, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 3, 2, 0, 5, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 6, 3, 2, 6, 5, 2, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 6, 3, 4, 6, 5, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, Blocks.NETHER_BRICK, 0, 5, 2, 5, structureBoundingBox);
        this.a(world, structureBoundingBox, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 8, 2, 6, 8, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 5, 0, 4, 5, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
