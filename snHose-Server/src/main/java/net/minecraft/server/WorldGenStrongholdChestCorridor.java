package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdChestCorridor extends WorldGenStrongholdPiece
{
    private static final StructurePieceTreasure[] a;
    private boolean b;
    
    public WorldGenStrongholdChestCorridor() {
    }
    
    public WorldGenStrongholdChestCorridor(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Chest", this.b);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.b = nbtTagCompound.getBoolean("Chest");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
    }
    
    public static WorldGenStrongholdChestCorridor a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdChestCorridor(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 4, 6, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 1, 0);
        this.a(world, random, structureBoundingBox, WorldGenStrongholdDoorType.a, 1, 1, 6);
        this.a(world, structureBoundingBox, 3, 1, 2, 3, 1, 4, Blocks.SMOOTH_BRICK, Blocks.SMOOTH_BRICK, false);
        this.a(world, Blocks.STEP, 5, 3, 1, 1, structureBoundingBox);
        this.a(world, Blocks.STEP, 5, 3, 1, 5, structureBoundingBox);
        this.a(world, Blocks.STEP, 5, 3, 2, 2, structureBoundingBox);
        this.a(world, Blocks.STEP, 5, 3, 2, 4, structureBoundingBox);
        for (int i = 2; i <= 4; ++i) {
            this.a(world, Blocks.STEP, 5, 2, 1, i, structureBoundingBox);
        }
        if (!this.b && structureBoundingBox.b(this.a(3, 3), this.a(2), this.b(3, 3))) {
            this.b = true;
            this.a(world, structureBoundingBox, random, 3, 2, 3, StructurePieceTreasure.a(WorldGenStrongholdChestCorridor.a, Items.ENCHANTED_BOOK.b(random)), 2 + random.nextInt(2));
        }
        return true;
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.ENDER_PEARL, 0, 1, 1, 10), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.APPLE, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_SWORD, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_HELMET, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_LEGGINGS, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_BOOTS, 0, 1, 1, 5), new StructurePieceTreasure(Items.GOLDEN_APPLE, 0, 1, 1, 1), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1) };
    }
}
