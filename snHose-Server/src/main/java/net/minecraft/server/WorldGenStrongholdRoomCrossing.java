package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdRoomCrossing extends WorldGenStrongholdPiece
{
    private static final StructurePieceTreasure[] b;
    protected int a;
    
    public WorldGenStrongholdRoomCrossing() {
    }
    
    public WorldGenStrongholdRoomCrossing(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
        this.a = random.nextInt(5);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setInt("Type", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getInt("Type");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 4, 1);
        this.b((WorldGenStrongholdStart)structurePiece, list, random, 1, 4);
        this.c((WorldGenStrongholdStart)structurePiece, list, random, 1, 4);
    }
    
    public static WorldGenStrongholdRoomCrossing a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -4, -1, 0, 11, 7, 11, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdRoomCrossing(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 10, 6, 10, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 4, 1, 0);
        this.a(world, structureBoundingBox, 4, 1, 10, 6, 3, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 1, 4, 0, 3, 6, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 10, 1, 4, 10, 3, 6, Blocks.AIR, Blocks.AIR, false);
        switch (this.a) {
            case 0: {
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 1, 5, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 2, 5, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 3, 5, structureBoundingBox);
                this.a(world, Blocks.TORCH, 0, 4, 3, 5, structureBoundingBox);
                this.a(world, Blocks.TORCH, 0, 6, 3, 5, structureBoundingBox);
                this.a(world, Blocks.TORCH, 0, 5, 3, 4, structureBoundingBox);
                this.a(world, Blocks.TORCH, 0, 5, 3, 6, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 4, 1, 4, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 4, 1, 5, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 4, 1, 6, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 6, 1, 4, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 6, 1, 5, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 6, 1, 6, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 5, 1, 4, structureBoundingBox);
                this.a(world, Blocks.STEP, 0, 5, 1, 6, structureBoundingBox);
                break;
            }
            case 1: {
                for (int i = 0; i < 5; ++i) {
                    this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 1, 3 + i, structureBoundingBox);
                    this.a(world, Blocks.SMOOTH_BRICK, 0, 7, 1, 3 + i, structureBoundingBox);
                    this.a(world, Blocks.SMOOTH_BRICK, 0, 3 + i, 1, 3, structureBoundingBox);
                    this.a(world, Blocks.SMOOTH_BRICK, 0, 3 + i, 1, 7, structureBoundingBox);
                }
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 1, 5, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 2, 5, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 5, 3, 5, structureBoundingBox);
                this.a(world, Blocks.WATER, 0, 5, 4, 5, structureBoundingBox);
                break;
            }
            case 2: {
                for (int j = 1; j <= 9; ++j) {
                    this.a(world, Blocks.COBBLESTONE, 0, 1, 3, j, structureBoundingBox);
                    this.a(world, Blocks.COBBLESTONE, 0, 9, 3, j, structureBoundingBox);
                }
                for (int k = 1; k <= 9; ++k) {
                    this.a(world, Blocks.COBBLESTONE, 0, k, 3, 1, structureBoundingBox);
                    this.a(world, Blocks.COBBLESTONE, 0, k, 3, 9, structureBoundingBox);
                }
                this.a(world, Blocks.COBBLESTONE, 0, 5, 1, 4, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 5, 1, 6, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 5, 3, 4, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 5, 3, 6, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 4, 1, 5, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 6, 1, 5, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 4, 3, 5, structureBoundingBox);
                this.a(world, Blocks.COBBLESTONE, 0, 6, 3, 5, structureBoundingBox);
                for (int l = 1; l <= 3; ++l) {
                    this.a(world, Blocks.COBBLESTONE, 0, 4, l, 4, structureBoundingBox);
                    this.a(world, Blocks.COBBLESTONE, 0, 6, l, 4, structureBoundingBox);
                    this.a(world, Blocks.COBBLESTONE, 0, 4, l, 6, structureBoundingBox);
                    this.a(world, Blocks.COBBLESTONE, 0, 6, l, 6, structureBoundingBox);
                }
                this.a(world, Blocks.TORCH, 0, 5, 3, 5, structureBoundingBox);
                for (int n = 2; n <= 8; ++n) {
                    this.a(world, Blocks.WOOD, 0, 2, 3, n, structureBoundingBox);
                    this.a(world, Blocks.WOOD, 0, 3, 3, n, structureBoundingBox);
                    if (n <= 3 || n >= 7) {
                        this.a(world, Blocks.WOOD, 0, 4, 3, n, structureBoundingBox);
                        this.a(world, Blocks.WOOD, 0, 5, 3, n, structureBoundingBox);
                        this.a(world, Blocks.WOOD, 0, 6, 3, n, structureBoundingBox);
                    }
                    this.a(world, Blocks.WOOD, 0, 7, 3, n, structureBoundingBox);
                    this.a(world, Blocks.WOOD, 0, 8, 3, n, structureBoundingBox);
                }
                this.a(world, Blocks.LADDER, this.a(Blocks.LADDER, 4), 9, 1, 3, structureBoundingBox);
                this.a(world, Blocks.LADDER, this.a(Blocks.LADDER, 4), 9, 2, 3, structureBoundingBox);
                this.a(world, Blocks.LADDER, this.a(Blocks.LADDER, 4), 9, 3, 3, structureBoundingBox);
                this.a(world, structureBoundingBox, random, 3, 4, 8, StructurePieceTreasure.a(WorldGenStrongholdRoomCrossing.b, Items.ENCHANTED_BOOK.b(random)), 1 + random.nextInt(4));
                break;
            }
        }
        return true;
    }
    
    static {
        b = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.COAL, 0, 3, 8, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.APPLE, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 1) };
    }
}
