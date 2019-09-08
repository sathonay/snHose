package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVillageLight extends WorldGenVillagePiece
{
    public WorldGenVillageLight() {
    }
    
    public WorldGenVillageLight(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
    }
    
    public static StructureBoundingBox a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 3, 4, 2, n4);
        if (StructurePiece.a(list, a) != null) {
            return null;
        }
        return a;
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.k < 0) {
            this.k = this.b(world, structureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 4 - 1, 0);
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.FENCE, 0, 1, 0, 0, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 1, 0, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 2, 0, structureBoundingBox);
        this.a(world, Blocks.WOOL, 15, 1, 3, 0, structureBoundingBox);
        this.a(world, Blocks.TORCH, 0, 0, 3, 0, structureBoundingBox);
        this.a(world, Blocks.TORCH, 0, 1, 3, 1, structureBoundingBox);
        this.a(world, Blocks.TORCH, 0, 2, 3, 0, structureBoundingBox);
        this.a(world, Blocks.TORCH, 0, 1, 3, -1, structureBoundingBox);
        return true;
    }
}
