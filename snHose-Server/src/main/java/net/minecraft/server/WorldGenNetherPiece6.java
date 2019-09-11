package net.minecraft.server;

import java.util.*;

public class WorldGenNetherPiece6 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece6() {
    }
    
    public WorldGenNetherPiece6(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenNetherPiece15)structurePiece, list, random, 5, 3, true);
    }
    
    public static WorldGenNetherPiece6 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece6(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 5, 0, 12, 13, 12, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 8, 0, 7, 8, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        for (int i = 1; i <= 11; i += 2) {
            this.a(world, structureBoundingBox, i, 10, 0, i, 11, 0, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
            this.a(world, structureBoundingBox, i, 10, 12, i, 11, 12, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
            this.a(world, structureBoundingBox, 0, 10, i, 0, 11, i, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
            this.a(world, structureBoundingBox, 12, 10, i, 12, 11, i, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
            this.a(world, Blocks.NETHER_BRICK, 0, i, 13, 0, structureBoundingBox);
            this.a(world, Blocks.NETHER_BRICK, 0, i, 13, 12, structureBoundingBox);
            this.a(world, Blocks.NETHER_BRICK, 0, 0, 13, i, structureBoundingBox);
            this.a(world, Blocks.NETHER_BRICK, 0, 12, 13, i, structureBoundingBox);
            this.a(world, Blocks.NETHER_FENCE, 0, i + 1, 13, 0, structureBoundingBox);
            this.a(world, Blocks.NETHER_FENCE, 0, i + 1, 13, 12, structureBoundingBox);
            this.a(world, Blocks.NETHER_FENCE, 0, 0, 13, i + 1, structureBoundingBox);
            this.a(world, Blocks.NETHER_FENCE, 0, 12, 13, i + 1, structureBoundingBox);
        }
        this.a(world, Blocks.NETHER_FENCE, 0, 0, 13, 0, structureBoundingBox);
        this.a(world, Blocks.NETHER_FENCE, 0, 0, 13, 12, structureBoundingBox);
        this.a(world, Blocks.NETHER_FENCE, 0, 0, 13, 0, structureBoundingBox);
        this.a(world, Blocks.NETHER_FENCE, 0, 12, 13, 0, structureBoundingBox);
        for (int j = 3; j <= 9; j += 2) {
            this.a(world, structureBoundingBox, 1, 7, j, 1, 8, j, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
            this.a(world, structureBoundingBox, 11, 7, j, 11, 8, j, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        }
        this.a(world, structureBoundingBox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int k = 4; k <= 8; ++k) {
            for (int l = 0; l <= 2; ++l) {
                this.b(world, Blocks.NETHER_BRICK, 0, k, -1, l, structureBoundingBox);
                this.b(world, Blocks.NETHER_BRICK, 0, k, -1, 12 - l, structureBoundingBox);
            }
        }
        for (int n = 0; n <= 2; ++n) {
            for (int n2 = 4; n2 <= 8; ++n2) {
                this.b(world, Blocks.NETHER_BRICK, 0, n, -1, n2, structureBoundingBox);
                this.b(world, Blocks.NETHER_BRICK, 0, 12 - n, -1, n2, structureBoundingBox);
            }
        }
        this.a(world, structureBoundingBox, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 1, 6, 6, 4, 6, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.NETHER_BRICK, 0, 6, 0, 6, structureBoundingBox);
        this.a(world, Blocks.LAVA, 0, 6, 5, 6, structureBoundingBox);
        final int a = this.a(6, 6);
        final int a2 = this.a(5);
        final int b = this.b(6, 6);
        if (structureBoundingBox.b(a, a2, b)) {
            world.d = true;
            Blocks.LAVA.a(world, a, a2, b, random);
            world.d = false;
        }
        return true;
    }
}
