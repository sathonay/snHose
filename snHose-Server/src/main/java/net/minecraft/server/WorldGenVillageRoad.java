package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVillageRoad extends WorldGenVillageRoadPiece
{
    private int a;
    
    public WorldGenVillageRoad() {
    }
    
    public WorldGenVillageRoad(final WorldGenVillageStartPiece worldGenVillageStartPiece, final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(worldGenVillageStartPiece, n);
        this.g = g;
        this.f = f;
        this.a = Math.max(f.b(), f.d());
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.setInt("Length", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.a = nbttagcompound.getInt("Length");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        boolean b = false;
        for (int i = random.nextInt(5); i < this.a - 8; i += 2 + random.nextInt(5)) {
            final StructurePiece a = this.a((WorldGenVillageStartPiece)structurePiece, list, random, 0, i);
            if (a != null) {
                i += Math.max(a.f.b(), a.f.d());
                b = true;
            }
        }
        for (int j = random.nextInt(5); j < this.a - 8; j += 2 + random.nextInt(5)) {
            final StructurePiece b2 = this.b((WorldGenVillageStartPiece)structurePiece, list, random, 0, j);
            if (b2 != null) {
                j += Math.max(b2.f.b(), b2.f.d());
                b = true;
            }
        }
        if (b && random.nextInt(3) > 0) {
            switch (this.g) {
                case 2: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a - 1, this.f.b, this.f.c, 1, this.d());
                    break;
                }
                case 0: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a - 1, this.f.b, this.f.f - 2, 1, this.d());
                    break;
                }
                case 3: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.d - 2, this.f.b, this.f.c - 1, 2, this.d());
                    break;
                }
                case 1: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a, this.f.b, this.f.c - 1, 2, this.d());
                    break;
                }
            }
        }
        if (b && random.nextInt(3) > 0) {
            switch (this.g) {
                case 2: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.d + 1, this.f.b, this.f.c, 3, this.d());
                    break;
                }
                case 0: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.d + 1, this.f.b, this.f.f - 2, 3, this.d());
                    break;
                }
                case 3: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.d - 2, this.f.b, this.f.f + 1, 0, this.d());
                    break;
                }
                case 1: {
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece)structurePiece, list, random, this.f.a, this.f.b, this.f.f + 1, 0, this.d());
                    break;
                }
            }
        }
    }
    
    public static StructureBoundingBox a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random var0, final int n, final int n2, final int n3, final int n4) {
        for (int i = 7 * MathHelper.nextInt(var0, 3, 5); i >= 7; i -= 7) {
            final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 3, 3, i, n4);
            if (StructurePiece.a(list, a) == null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        final Block b = this.b(Blocks.GRAVEL, 0);
        for (int i = this.f.a; i <= this.f.d; ++i) {
            for (int j = this.f.c; j <= this.f.f; ++j) {
                if (structureBoundingBox.b(i, 64, j)) {
                    world.setTypeAndData(i, world.i(i, j) - 1, j, b, 0, 2);
                }
            }
        }
        return true;
    }
}
