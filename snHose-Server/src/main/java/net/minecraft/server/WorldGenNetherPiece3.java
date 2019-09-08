package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenNetherPiece3 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece3() {
    }
    
    public WorldGenNetherPiece3(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenNetherPiece15)structurePiece, list, random, 1, 3, false);
    }
    
    public static WorldGenNetherPiece3 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -3, 0, 5, 10, 19, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece3(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 5, 0, 3, 7, 18, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 2; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, 18 - j, structureBoundingBox);
            }
        }
        this.a(world, structureBoundingBox, 0, 1, 1, 0, 4, 1, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 3, 4, 0, 4, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 3, 14, 0, 4, 14, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 1, 17, 0, 4, 17, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 4, 1, 1, 4, 4, 1, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 4, 3, 4, 4, 4, 4, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 4, 3, 14, 4, 4, 14, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 4, 1, 17, 4, 4, 17, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        return true;
    }
}
