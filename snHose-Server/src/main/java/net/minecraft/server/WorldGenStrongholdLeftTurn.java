package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdLeftTurn extends WorldGenStrongholdPiece
{
    public WorldGenStrongholdLeftTurn() {
    }
    
    public WorldGenStrongholdLeftTurn(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        if (this.g == 2 || this.g == 3) {
            this.b((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
        }
        else {
            this.c((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
        }
    }
    
    public static WorldGenStrongholdLeftTurn a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, 5, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdLeftTurn(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 4, 4, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 1, 0);
        if (this.g == 2 || this.g == 3) {
            this.a(world, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.AIR, Blocks.AIR, false);
        }
        else {
            this.a(world, structureBoundingBox, 4, 1, 1, 4, 3, 3, Blocks.AIR, Blocks.AIR, false);
        }
        return true;
    }
}
