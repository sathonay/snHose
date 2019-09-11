package net.minecraft.server;

import java.util.*;

public class WorldGenNetherPiece1 extends WorldGenNetherPiece
{
    public WorldGenNetherPiece1() {
    }
    
    public WorldGenNetherPiece1(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    protected WorldGenNetherPiece1(final Random random, final int n, final int n2) {
        super(0);
        switch (this.g = random.nextInt(4)) {
            case 0:
            case 2: {
                this.f = new StructureBoundingBox(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
                break;
            }
            default: {
                this.f = new StructureBoundingBox(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
                break;
            }
        }
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenNetherPiece15)structurePiece, list, random, 8, 3, false);
        this.b((WorldGenNetherPiece15)structurePiece, list, random, 3, 8, false);
        this.c((WorldGenNetherPiece15)structurePiece, list, random, 3, 8, false);
    }
    
    public static WorldGenNetherPiece1 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -8, -3, 0, 19, 10, 19, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece1(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 8, 5, 0, 10, 7, 18, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 5, 8, 18, 7, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int i = 7; i <= 11; ++i) {
            for (int j = 0; j <= 2; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, 18 - j, structureBoundingBox);
            }
        }
        this.a(world, structureBoundingBox, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int k = 0; k <= 2; ++k) {
            for (int l = 7; l <= 11; ++l) {
                this.b(world, Blocks.NETHER_BRICK, 0, k, -1, l, structureBoundingBox);
                this.b(world, Blocks.NETHER_BRICK, 0, 18 - k, -1, l, structureBoundingBox);
            }
        }
        return true;
    }
}
