package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVillageHouse extends WorldGenVillagePiece
{
    private boolean a;
    
    public WorldGenVillageHouse() {
    }
    
    public WorldGenVillageHouse(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
        this.a = random.nextBoolean();
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.setBoolean("Terrace", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.a = nbttagcompound.getBoolean("Terrace");
    }
    
    public static WorldGenVillageHouse a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 5, 6, 5, n4);
        if (StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageHouse(worldGenVillageStartPiece, n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.k < 0) {
            this.k = this.b(world, structureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 0, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureBoundingBox, 0, 4, 0, 4, 4, 4, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureBoundingBox, 1, 4, 1, 3, 4, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 1, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 2, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 3, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 1, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 2, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 3, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 1, 4, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 2, 4, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 0, 3, 4, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 1, 4, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 2, 4, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE, 0, 4, 3, 4, structureBoundingBox);
        this.a(world, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 4, 1, 1, 4, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureBoundingBox, 1, 1, 4, 3, 3, 4, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 4, structureBoundingBox);
        this.a(world, Blocks.THIN_GLASS, 0, 4, 2, 2, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 1, 1, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 1, 2, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 1, 3, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 2, 3, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 3, 3, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 3, 2, 0, structureBoundingBox);
        this.a(world, Blocks.WOOD, 0, 3, 1, 0, structureBoundingBox);
        if (this.a(world, 2, 0, -1, structureBoundingBox).getMaterial() == Material.AIR && this.a(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.AIR) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, this.a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, structureBoundingBox);
        }
        this.a(world, structureBoundingBox, 1, 1, 1, 3, 3, 3, Blocks.AIR, Blocks.AIR, false);
        if (this.a) {
            this.a(world, Blocks.FENCE, 0, 0, 5, 0, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 1, 5, 0, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 2, 5, 0, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 3, 5, 0, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 4, 5, 0, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 0, 5, 4, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 1, 5, 4, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 2, 5, 4, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 3, 5, 4, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 4, 5, 4, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 4, 5, 1, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 4, 5, 2, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 4, 5, 3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 0, 5, 1, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 0, 5, 2, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 0, 5, 3, structureBoundingBox);
        }
        if (this.a) {
            final int a = this.a(Blocks.LADDER, 3);
            this.a(world, Blocks.LADDER, a, 3, 1, 3, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 3, 2, 3, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 3, 3, 3, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 3, 4, 3, structureBoundingBox);
        }
        this.a(world, Blocks.TORCH, 0, 2, 3, 1, structureBoundingBox);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                this.b(world, j, 6, i, structureBoundingBox);
                this.b(world, Blocks.COBBLESTONE, 0, j, -1, i, structureBoundingBox);
            }
        }
        this.a(world, structureBoundingBox, 1, 1, 2, 1);
        return true;
    }
}
