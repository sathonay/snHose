package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdRightTurn extends WorldGenStrongholdLeftTurn
{
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        if (this.g == 2 || this.g == 3) {
            this.c((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
        }
        else {
            this.b((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
        }
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 4, 4, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 1, 0);
        if (this.g == 2 || this.g == 3) {
            this.a(world, structureBoundingBox, 4, 1, 1, 4, 3, 3, Blocks.AIR, Blocks.AIR, false);
        }
        else {
            this.a(world, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.AIR, Blocks.AIR, false);
        }
        return true;
    }
}
