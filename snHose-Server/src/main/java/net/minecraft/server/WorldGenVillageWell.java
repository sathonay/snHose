package net.minecraft.server;

import java.util.*;

public class WorldGenVillageWell extends WorldGenVillagePiece
{
    public WorldGenVillageWell() {
    }
    
    public WorldGenVillageWell(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final int n, final int n2) {
        super(worldgenvillagestartpiece, i);
        switch (this.g = random.nextInt(4)) {
            case 0:
            case 2: {
                this.f = new StructureBoundingBox(n, 64, n2, n + 6 - 1, 78, n2 + 6 - 1);
                break;
            }
            default: {
                this.f = new StructureBoundingBox(n, 64, n2, n + 6 - 1, 78, n2 + 6 - 1);
                break;
            }
        }
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a - 1, this.f.e - 4, this.f.c + 1, 1, this.d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.d + 1, this.f.e - 4, this.f.c + 1, 3, this.d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a + 1, this.f.e - 4, this.f.c - 1, 2, this.d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a + 1, this.f.e - 4, this.f.f + 1, 0, this.d());
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.k < 0) {
            this.k = this.b(world, structureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 3, 0);
        }
        this.a(world, structureBoundingBox, 1, 0, 1, 4, 12, 4, Blocks.COBBLESTONE, Blocks.WATER, false);
        this.a(world, Blocks.AIR, 0, 2, 12, 2, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 3, 12, 2, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 2, 12, 3, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 3, 12, 3, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 13, 1, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 14, 1, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 4, 13, 1, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 4, 14, 1, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 13, 4, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 1, 14, 4, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 4, 13, 4, structureBoundingBox);
        this.a(world, Blocks.FENCE, 0, 4, 14, 4, structureBoundingBox);
        this.a(world, structureBoundingBox, 1, 15, 1, 4, 15, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 5; ++j) {
                if (j == 0 || j == 5 || i == 0 || i == 5) {
                    this.a(world, Blocks.GRAVEL, 0, j, 11, i, structureBoundingBox);
                    this.b(world, j, 12, i, structureBoundingBox);
                }
            }
        }
        return true;
    }
}
