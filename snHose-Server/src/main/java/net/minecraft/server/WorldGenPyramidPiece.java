package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenPyramidPiece extends WorldGenScatteredPiece
{
    private boolean[] e;
    private static final StructurePieceTreasure[] i;
    
    public WorldGenPyramidPiece() {
        this.e = new boolean[4];
    }
    
    public WorldGenPyramidPiece(final Random random, final int n, final int n2) {
        super(random, n, 64, n2, 21, 15, 21);
        this.e = new boolean[4];
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("hasPlacedChest0", this.e[0]);
        nbtTagCompound.setBoolean("hasPlacedChest1", this.e[1]);
        nbtTagCompound.setBoolean("hasPlacedChest2", this.e[2]);
        nbtTagCompound.setBoolean("hasPlacedChest3", this.e[3]);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.e[0] = nbtTagCompound.getBoolean("hasPlacedChest0");
        this.e[1] = nbtTagCompound.getBoolean("hasPlacedChest1");
        this.e[2] = nbtTagCompound.getBoolean("hasPlacedChest2");
        this.e[3] = nbtTagCompound.getBoolean("hasPlacedChest3");
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, -4, 0, this.a - 1, 0, this.c - 1, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        for (int i = 1; i <= 9; ++i) {
            this.a(world, structureBoundingBox, i, i, i, this.a - 1 - i, i, this.c - 1 - i, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
            this.a(world, structureBoundingBox, i + 1, i, i + 1, this.a - 2 - i, i, this.c - 2 - i, Blocks.AIR, Blocks.AIR, false);
        }
        for (int j = 0; j < this.a; ++j) {
            for (int k = 0; k < this.c; ++k) {
                this.b(world, Blocks.SANDSTONE, 0, j, -5, k, structureBoundingBox);
            }
        }
        final int a = this.a(Blocks.SANDSTONE_STAIRS, 3);
        final int a2 = this.a(Blocks.SANDSTONE_STAIRS, 2);
        final int a3 = this.a(Blocks.SANDSTONE_STAIRS, 0);
        final int a4 = this.a(Blocks.SANDSTONE_STAIRS, 1);
        final int n = 1;
        final int n2 = 11;
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, 2, 10, 0, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a2, 2, 10, 4, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a3, 0, 10, 2, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a4, 4, 10, 2, structureBoundingBox);
        this.a(world, structureBoundingBox, this.a - 5, 0, 0, this.a - 1, 9, 4, Blocks.SANDSTONE, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.a - 4, 10, 1, this.a - 2, 10, 3, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, this.a - 3, 10, 0, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a2, this.a - 3, 10, 4, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a3, this.a - 5, 10, 2, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a4, this.a - 1, 10, 2, structureBoundingBox);
        this.a(world, structureBoundingBox, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 9, 1, 0, 11, 3, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.SANDSTONE, 2, 9, 1, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 9, 2, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 9, 3, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 10, 3, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 11, 3, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 11, 2, 1, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 11, 1, 1, structureBoundingBox);
        this.a(world, structureBoundingBox, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 4, 1, 2, 8, 2, 2, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 12, 1, 2, 16, 2, 2, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 5, 4, 5, this.a - 6, 4, this.c - 6, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, 9, 4, 9, 11, 4, 11, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 8, 1, 8, 8, 3, 8, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 12, 1, 8, 12, 3, 8, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 8, 1, 12, 8, 3, 12, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 12, 1, 12, 12, 3, 12, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, this.a - 5, 1, 5, this.a - 2, 4, 11, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, this.a - 7, 7, 9, this.a - 7, 7, 11, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, 5, 5, 9, 5, 7, 11, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, this.a - 6, 5, 9, this.a - 6, 7, 11, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, Blocks.AIR, 0, 5, 5, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 5, 6, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 6, 6, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, this.a - 6, 5, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, this.a - 6, 6, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, this.a - 7, 6, 10, structureBoundingBox);
        this.a(world, structureBoundingBox, 2, 4, 4, 2, 6, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.a - 3, 4, 4, this.a - 3, 6, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, 2, 4, 5, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, 2, 3, 4, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, this.a - 3, 4, 5, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a, this.a - 3, 3, 4, structureBoundingBox);
        this.a(world, structureBoundingBox, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, this.a - 3, 1, 3, this.a - 2, 2, 3, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, Blocks.SANDSTONE_STAIRS, 0, 1, 1, 2, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, 0, this.a - 2, 1, 2, structureBoundingBox);
        this.a(world, Blocks.STEP, 1, 1, 2, 2, structureBoundingBox);
        this.a(world, Blocks.STEP, 1, this.a - 2, 2, 2, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a4, 2, 1, 2, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE_STAIRS, a3, this.a - 3, 1, 2, structureBoundingBox);
        this.a(world, structureBoundingBox, 4, 3, 5, 4, 3, 18, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, this.a - 5, 3, 5, this.a - 5, 3, 17, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, 3, 1, 5, 4, 2, 16, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.a - 6, 1, 5, this.a - 5, 2, 16, Blocks.AIR, Blocks.AIR, false);
        for (int l = 5; l <= 17; l += 2) {
            this.a(world, Blocks.SANDSTONE, 2, 4, 1, l, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, 4, 2, l, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, this.a - 5, 1, l, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, this.a - 5, 2, l, structureBoundingBox);
        }
        this.a(world, Blocks.WOOL, n, 10, 0, 7, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 10, 0, 8, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 9, 0, 9, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 11, 0, 9, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 8, 0, 10, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 12, 0, 10, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 7, 0, 10, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 13, 0, 10, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 9, 0, 11, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 11, 0, 11, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 10, 0, 12, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 10, 0, 13, structureBoundingBox);
        this.a(world, Blocks.WOOL, n2, 10, 0, 10, structureBoundingBox);
        for (int n3 = 0; n3 <= this.a - 1; n3 += this.a - 1) {
            this.a(world, Blocks.SANDSTONE, 2, n3, 2, 1, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 2, 2, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 2, 3, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 3, 1, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 3, 2, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 3, 3, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 4, 1, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, n3, 4, 2, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 4, 3, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 5, 1, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 5, 2, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 5, 3, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 6, 1, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, n3, 6, 2, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 6, 3, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 7, 1, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 7, 2, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n3, 7, 3, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 8, 1, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 8, 2, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n3, 8, 3, structureBoundingBox);
        }
        for (int n4 = 2; n4 <= this.a - 3; n4 += this.a - 3 - 2) {
            this.a(world, Blocks.SANDSTONE, 2, n4 - 1, 2, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4, 2, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 + 1, 2, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 - 1, 3, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4, 3, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 + 1, 3, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 - 1, 4, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, n4, 4, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 + 1, 4, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 - 1, 5, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4, 5, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 + 1, 5, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 - 1, 6, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 1, n4, 6, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 + 1, 6, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 - 1, 7, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4, 7, 0, structureBoundingBox);
            this.a(world, Blocks.WOOL, n, n4 + 1, 7, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 - 1, 8, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4, 8, 0, structureBoundingBox);
            this.a(world, Blocks.SANDSTONE, 2, n4 + 1, 8, 0, structureBoundingBox);
        }
        this.a(world, structureBoundingBox, 8, 4, 0, 12, 6, 0, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, Blocks.AIR, 0, 8, 6, 0, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 12, 6, 0, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 9, 5, 0, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 1, 10, 5, 0, structureBoundingBox);
        this.a(world, Blocks.WOOL, n, 11, 5, 0, structureBoundingBox);
        this.a(world, structureBoundingBox, 8, -14, 8, 12, -11, 12, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 8, -10, 8, 12, -10, 12, Blocks.SANDSTONE, 1, Blocks.SANDSTONE, 1, false);
        this.a(world, structureBoundingBox, 8, -9, 8, 12, -9, 12, Blocks.SANDSTONE, 2, Blocks.SANDSTONE, 2, false);
        this.a(world, structureBoundingBox, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE, Blocks.SANDSTONE, false);
        this.a(world, structureBoundingBox, 9, -11, 9, 11, -1, 11, Blocks.AIR, Blocks.AIR, false);
        this.a(world, Blocks.STONE_PLATE, 0, 10, -11, 10, structureBoundingBox);
        this.a(world, structureBoundingBox, 9, -13, 9, 11, -13, 11, Blocks.TNT, Blocks.AIR, false);
        this.a(world, Blocks.AIR, 0, 8, -11, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 8, -10, 10, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 1, 7, -10, 10, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 7, -11, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 12, -11, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 12, -10, 10, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 1, 13, -10, 10, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 13, -11, 10, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, -11, 8, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, -10, 8, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 1, 10, -10, 7, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 10, -11, 7, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, -11, 12, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, -10, 12, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 1, 10, -10, 13, structureBoundingBox);
        this.a(world, Blocks.SANDSTONE, 2, 10, -11, 13, structureBoundingBox);
        for (int n5 = 0; n5 < 4; ++n5) {
            if (!this.e[n5]) {
                this.e[n5] = this.a(world, structureBoundingBox, random, 10 + Direction.a[n5] * 2, -11, 10 + Direction.b[n5] * 2, StructurePieceTreasure.a(WorldGenPyramidPiece.i, Items.ENCHANTED_BOOK.b(random)), 2 + random.nextInt(5));
            }
        }
        return true;
    }
    
    static {
        i = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 2, 7, 15), new StructurePieceTreasure(Items.EMERALD, 0, 1, 3, 2), new StructurePieceTreasure(Items.BONE, 0, 4, 6, 20), new StructurePieceTreasure(Items.ROTTEN_FLESH, 0, 3, 7, 16), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1) };
    }
}
