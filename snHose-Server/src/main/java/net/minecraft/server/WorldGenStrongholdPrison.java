package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdPrison extends WorldGenStrongholdPiece
{
    public WorldGenStrongholdPrison() {
    }
    
    public WorldGenStrongholdPrison(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
    }
    
    public static WorldGenStrongholdPrison a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 9, 5, 11, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdPrison(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 8, 4, 10, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 1, 0);
        this.a(world, structureBoundingBox, 1, 1, 10, 3, 3, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 4, 1, 1, 4, 3, 1, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 3, 4, 3, 3, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 7, 4, 3, 7, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 9, 4, 3, 9, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 4, 4, 3, 6, Blocks.IRON_FENCE, Blocks.IRON_FENCE, false);
        this.a(world, structureBoundingBox, 5, 1, 5, 7, 3, 5, Blocks.IRON_FENCE, Blocks.IRON_FENCE, false);
        this.a(world, Blocks.IRON_FENCE, 0, 4, 3, 2, structureBoundingBox);
        this.a(world, Blocks.IRON_FENCE, 0, 4, 3, 8, structureBoundingBox);
        this.a(world, Blocks.IRON_DOOR_BLOCK, this.a(Blocks.IRON_DOOR_BLOCK, 3), 4, 1, 2, structureBoundingBox);
        this.a(world, Blocks.IRON_DOOR_BLOCK, this.a(Blocks.IRON_DOOR_BLOCK, 3) + 8, 4, 2, 2, structureBoundingBox);
        this.a(world, Blocks.IRON_DOOR_BLOCK, this.a(Blocks.IRON_DOOR_BLOCK, 3), 4, 1, 8, structureBoundingBox);
        this.a(world, Blocks.IRON_DOOR_BLOCK, this.a(Blocks.IRON_DOOR_BLOCK, 3) + 8, 4, 2, 8, structureBoundingBox);
        return true;
    }
}
