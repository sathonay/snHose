package net.minecraft.server;

import java.util.*;

public class WorldGenVillageFarm extends WorldGenVillagePiece
{
    private Block a;
    private Block b;
    
    public WorldGenVillageFarm() {
    }
    
    public WorldGenVillageFarm(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
        this.a = this.a(random);
        this.b = this.a(random);
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.setInt("CA", Block.REGISTRY.b(this.a));
        nbttagcompound.setInt("CB", Block.REGISTRY.b(this.b));
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.a = Block.getById(nbttagcompound.getInt("CA"));
        this.b = Block.getById(nbttagcompound.getInt("CB"));
    }
    
    private Block a(final Random random) {
        switch (random.nextInt(5)) {
            default: {
                return Blocks.CROPS;
            }
            case 0: {
                return Blocks.CARROTS;
            }
            case 1: {
                return Blocks.POTATOES;
            }
        }
    }
    
    public static WorldGenVillageFarm a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 7, 4, 9, n4);
        if (!WorldGenVillagePiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageFarm(worldGenVillageStartPiece, n5, random, a, n4);
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
        this.a(world, structureBoundingBox, 0, 1, 0, 6, 4, 8, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.SOIL, Blocks.SOIL, false);
        this.a(world, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.SOIL, Blocks.SOIL, false);
        this.a(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureBoundingBox, 1, 0, 0, 5, 0, 0, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureBoundingBox, 1, 0, 8, 5, 0, 8, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.STATIONARY_WATER, Blocks.STATIONARY_WATER, false);
        for (int i = 1; i <= 7; ++i) {
            this.a(world, this.a, MathHelper.nextInt(random, 2, 7), 1, 1, i, structureBoundingBox);
            this.a(world, this.a, MathHelper.nextInt(random, 2, 7), 2, 1, i, structureBoundingBox);
            this.a(world, this.b, MathHelper.nextInt(random, 2, 7), 4, 1, i, structureBoundingBox);
            this.a(world, this.b, MathHelper.nextInt(random, 2, 7), 5, 1, i, structureBoundingBox);
        }
        for (int j = 0; j < 9; ++j) {
            for (int k = 0; k < 7; ++k) {
                this.b(world, k, 4, j, structureBoundingBox);
                this.b(world, Blocks.DIRT, 0, k, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
