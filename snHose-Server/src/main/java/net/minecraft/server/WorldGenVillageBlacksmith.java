package net.minecraft.server;

import java.util.*;

public class WorldGenVillageBlacksmith extends WorldGenVillagePiece
{
    private static final StructurePieceTreasure[] a;
    private boolean b;
    
    public WorldGenVillageBlacksmith() {
    }
    
    public WorldGenVillageBlacksmith(final WorldGenVillageStartPiece worldgenvillagestartpiece, final int i, final Random random, final StructureBoundingBox f, final int g) {
        super(worldgenvillagestartpiece, i);
        this.g = g;
        this.f = f;
    }
    
    public static WorldGenVillageBlacksmith a(final WorldGenVillageStartPiece worldGenVillageStartPiece, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, 0, 0, 0, 10, 6, 7, n4);
        if (!WorldGenVillagePiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenVillageBlacksmith(worldGenVillageStartPiece, n5, random, a, n4);
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.setBoolean("Chest", this.b);
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.b = nbttagcompound.getBoolean("Chest");
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureboundingbox) {
        if (this.k < 0) {
            this.k = this.b(world, structureboundingbox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        this.a(world, structureboundingbox, 0, 1, 0, 9, 4, 6, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureboundingbox, 0, 0, 0, 9, 0, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 4, 0, 9, 4, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, structureboundingbox, 0, 5, 0, 9, 5, 6, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureboundingbox, 1, 5, 1, 8, 5, 5, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureboundingbox, 1, 1, 0, 2, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 1, 0, 0, 4, 0, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureboundingbox, 3, 1, 0, 3, 4, 0, Blocks.LOG, Blocks.LOG, false);
        this.a(world, structureboundingbox, 0, 1, 6, 0, 4, 6, Blocks.LOG, Blocks.LOG, false);
        this.a(world, Blocks.WOOD, 0, 3, 3, 1, structureboundingbox);
        this.a(world, structureboundingbox, 3, 1, 2, 3, 3, 2, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 4, 1, 3, 5, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 0, 1, 1, 0, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 1, 1, 6, 5, 3, 6, Blocks.WOOD, Blocks.WOOD, false);
        this.a(world, structureboundingbox, 5, 1, 0, 5, 3, 0, Blocks.FENCE, Blocks.FENCE, false);
        this.a(world, structureboundingbox, 9, 1, 0, 9, 3, 0, Blocks.FENCE, Blocks.FENCE, false);
        this.a(world, structureboundingbox, 6, 1, 4, 9, 4, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        this.a(world, Blocks.LAVA, 0, 7, 1, 5, structureboundingbox);
        this.a(world, Blocks.LAVA, 0, 8, 1, 5, structureboundingbox);
        this.a(world, Blocks.IRON_FENCE, 0, 9, 2, 5, structureboundingbox);
        this.a(world, Blocks.IRON_FENCE, 0, 9, 2, 4, structureboundingbox);
        this.a(world, structureboundingbox, 7, 2, 4, 8, 2, 5, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.COBBLESTONE, 0, 6, 1, 3, structureboundingbox);
        this.a(world, Blocks.FURNACE, 0, 6, 2, 3, structureboundingbox);
        this.a(world, Blocks.FURNACE, 0, 6, 3, 3, structureboundingbox);
        this.a(world, Blocks.DOUBLE_STEP, 0, 8, 1, 1, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 0, 2, 4, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 2, 2, 6, structureboundingbox);
        this.a(world, Blocks.THIN_GLASS, 0, 4, 2, 6, structureboundingbox);
        this.a(world, Blocks.FENCE, 0, 2, 1, 4, structureboundingbox);
        this.a(world, Blocks.WOOD_PLATE, 0, 2, 2, 4, structureboundingbox);
        this.a(world, Blocks.WOOD, 0, 1, 1, 5, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, this.a(Blocks.WOOD_STAIRS, 3), 2, 1, 5, structureboundingbox);
        this.a(world, Blocks.WOOD_STAIRS, this.a(Blocks.WOOD_STAIRS, 1), 1, 1, 4, structureboundingbox);
        if (!this.b && structureboundingbox.b(this.a(5, 5), this.a(1), this.b(5, 5))) {
            this.b = true;
            this.a(world, structureboundingbox, random, 5, 1, 5, WorldGenVillageBlacksmith.a, 3 + random.nextInt(6));
        }
        for (int i = 6; i <= 8; ++i) {
            if (this.a(world, i, 0, -1, structureboundingbox).getMaterial() == Material.AIR && this.a(world, i, -1, -1, structureboundingbox).getMaterial() != Material.AIR) {
                this.a(world, Blocks.COBBLESTONE_STAIRS, this.a(Blocks.COBBLESTONE_STAIRS, 3), i, 0, -1, structureboundingbox);
            }
        }
        for (int j = 0; j < 7; ++j) {
            for (int k = 0; k < 10; ++k) {
                this.b(world, k, 6, j, structureboundingbox);
                this.b(world, Blocks.COBBLESTONE, 0, k, -1, j, structureboundingbox);
            }
        }
        this.a(world, structureboundingbox, 7, 1, 1, 1);
        return true;
    }
    
    @Override
    protected int b(final int n) {
        return 3;
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.APPLE, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_SWORD, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_HELMET, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_LEGGINGS, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_BOOTS, 0, 1, 1, 5), new StructurePieceTreasure(Item.getItemOf(Blocks.OBSIDIAN), 0, 3, 7, 5), new StructurePieceTreasure(Item.getItemOf(Blocks.SAPLING), 0, 3, 7, 5), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1) };
    }
}
