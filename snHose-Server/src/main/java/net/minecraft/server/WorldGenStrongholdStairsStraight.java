package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdStairsStraight extends WorldGenStrongholdPiece
{
    public WorldGenStrongholdStairsStraight() {
    }
    
    public WorldGenStrongholdStairsStraight(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
    }
    
    public static WorldGenStrongholdStairsStraight a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -7, 0, 5, 11, 8, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdStairsStraight(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 10, 7, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 7, 0);
        this.a(world, random, structureBoundingBox, WorldGenStrongholdDoorType.a, 1, 1, 7);
        final int a = this.a(Blocks.COBBLESTONE_STAIRS, 2);
        for (int i = 0; i < 6; ++i) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, a, 1, 6 - i, 1 + i, structureBoundingBox);
            this.a(world, Blocks.COBBLESTONE_STAIRS, a, 2, 6 - i, 1 + i, structureBoundingBox);
            this.a(world, Blocks.COBBLESTONE_STAIRS, a, 3, 6 - i, 1 + i, structureBoundingBox);
            if (i < 5) {
                this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 5 - i, 1 + i, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 5 - i, 1 + i, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 5 - i, 1 + i, structureBoundingBox);
            }
        }
        return true;
    }
}
