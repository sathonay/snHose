package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenNetherPiece5 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece5() {
    }
    
    public WorldGenNetherPiece5(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        int n = 1;
        if (this.g == 1 || this.g == 2) {
            n = 5;
        }
        this.b((WorldGenNetherPiece15)structurePiece, list, random, 0, n, random.nextInt(8) > 0);
        this.c((WorldGenNetherPiece15)structurePiece, list, random, 0, n, random.nextInt(8) > 0);
    }
    
    public static WorldGenNetherPiece5 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -3, 0, 0, 9, 7, 9, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece5(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 8, 5, 8, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 3, 0, 1, 4, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 7, 3, 0, 7, 4, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 1, 4, 2, 2, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 6, 1, 4, 7, 2, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 3, 8, 8, 3, 8, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 3, 6, 0, 3, 7, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 8, 3, 6, 8, 3, 7, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 4, 5, 1, 5, 5, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 7, 4, 5, 7, 5, 5, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, j, -1, i, structureBoundingBox);
            }
        }
        return true;
    }
}
