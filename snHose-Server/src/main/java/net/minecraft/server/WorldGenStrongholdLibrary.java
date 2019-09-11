package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdLibrary extends WorldGenStrongholdPiece
{
    private static final StructurePieceTreasure[] a;
    private boolean b;
    
    public WorldGenStrongholdLibrary() {
    }
    
    public WorldGenStrongholdLibrary(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
        this.b = (f.c() > 6);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Tall", this.b);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.b = nbtTagCompound.getBoolean("Tall");
    }
    
    public static WorldGenStrongholdLibrary a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.a(n, n2, n3, -4, -1, 0, 14, 11, 15, n4);
        if (!WorldGenStrongholdPiece.a(structureBoundingBox) || StructurePiece.a(list, structureBoundingBox) != null) {
            structureBoundingBox = StructureBoundingBox.a(n, n2, n3, -4, -1, 0, 14, 6, 15, n4);
            if (!WorldGenStrongholdPiece.a(structureBoundingBox) || StructurePiece.a(list, structureBoundingBox) != null) {
                return null;
            }
        }
        return new WorldGenStrongholdLibrary(n5, random, structureBoundingBox, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        int n = 11;
        if (!this.b) {
            n = 6;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 13, n - 1, 14, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 4, 1, 0);
        this.a(world, structureBoundingBox, random, 0.07f, 2, 1, 1, 11, 4, 13, Blocks.WEB, Blocks.WEB, false);
        for (int i = 1; i <= 13; ++i) {
            if ((i - 1) % 4 == 0) {
                this.a(world, structureBoundingBox, 1, 1, i, 1, 4, i, Blocks.WOOD, Blocks.WOOD, false);
                this.a(world, structureBoundingBox, 12, 1, i, 12, 4, i, Blocks.WOOD, Blocks.WOOD, false);
                this.a(world, Blocks.TORCH, 0, 2, 3, i, structureBoundingBox);
                this.a(world, Blocks.TORCH, 0, 11, 3, i, structureBoundingBox);
                if (this.b) {
                    this.a(world, structureBoundingBox, 1, 6, i, 1, 9, i, Blocks.WOOD, Blocks.WOOD, false);
                    this.a(world, structureBoundingBox, 12, 6, i, 12, 9, i, Blocks.WOOD, Blocks.WOOD, false);
                }
            }
            else {
                this.a(world, structureBoundingBox, 1, 1, i, 1, 4, i, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
                this.a(world, structureBoundingBox, 12, 1, i, 12, 4, i, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
                if (this.b) {
                    this.a(world, structureBoundingBox, 1, 6, i, 1, 9, i, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
                    this.a(world, structureBoundingBox, 12, 6, i, 12, 9, i, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
                }
            }
        }
        for (int j = 3; j < 12; j += 2) {
            this.a(world, structureBoundingBox, 3, 1, j, 4, 3, j, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
            this.a(world, structureBoundingBox, 6, 1, j, 7, 3, j, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
            this.a(world, structureBoundingBox, 9, 1, j, 10, 3, j, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);
        }
        if (this.b) {
            this.a(world, structureBoundingBox, 1, 5, 1, 3, 5, 13, Blocks.WOOD, Blocks.WOOD, false);
            this.a(world, structureBoundingBox, 10, 5, 1, 12, 5, 13, Blocks.WOOD, Blocks.WOOD, false);
            this.a(world, structureBoundingBox, 4, 5, 1, 9, 5, 2, Blocks.WOOD, Blocks.WOOD, false);
            this.a(world, structureBoundingBox, 4, 5, 12, 9, 5, 13, Blocks.WOOD, Blocks.WOOD, false);
            this.a(world, Blocks.WOOD, 0, 9, 5, 11, structureBoundingBox);
            this.a(world, Blocks.WOOD, 0, 8, 5, 11, structureBoundingBox);
            this.a(world, Blocks.WOOD, 0, 9, 5, 10, structureBoundingBox);
            this.a(world, structureBoundingBox, 3, 6, 2, 3, 6, 12, Blocks.FENCE, Blocks.FENCE, false);
            this.a(world, structureBoundingBox, 10, 6, 2, 10, 6, 10, Blocks.FENCE, Blocks.FENCE, false);
            this.a(world, structureBoundingBox, 4, 6, 2, 9, 6, 2, Blocks.FENCE, Blocks.FENCE, false);
            this.a(world, structureBoundingBox, 4, 6, 12, 8, 6, 12, Blocks.FENCE, Blocks.FENCE, false);
            this.a(world, Blocks.FENCE, 0, 9, 6, 11, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 8, 6, 11, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, 9, 6, 10, structureBoundingBox);
            final int a = this.a(Blocks.LADDER, 3);
            this.a(world, Blocks.LADDER, a, 10, 1, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 2, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 3, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 4, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 5, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 6, 13, structureBoundingBox);
            this.a(world, Blocks.LADDER, a, 10, 7, 13, structureBoundingBox);
            final int n2 = 7;
            final int n3 = 7;
            this.a(world, Blocks.FENCE, 0, n2 - 1, 9, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2, 9, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 - 1, 8, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2, 8, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 - 1, 7, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2, 7, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 - 2, 7, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 + 1, 7, n3, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 - 1, 7, n3 - 1, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2 - 1, 7, n3 + 1, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2, 7, n3 - 1, structureBoundingBox);
            this.a(world, Blocks.FENCE, 0, n2, 7, n3 + 1, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2 - 2, 8, n3, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2 + 1, 8, n3, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2 - 1, 8, n3 - 1, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2 - 1, 8, n3 + 1, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2, 8, n3 - 1, structureBoundingBox);
            this.a(world, Blocks.TORCH, 0, n2, 8, n3 + 1, structureBoundingBox);
        }
        this.a(world, structureBoundingBox, random, 3, 3, 5, StructurePieceTreasure.a(WorldGenStrongholdLibrary.a, Items.ENCHANTED_BOOK.a(random, 1, 5, 2)), 1 + random.nextInt(4));
        if (this.b) {
            this.a(world, Blocks.AIR, 0, 12, 9, 1, structureBoundingBox);
            this.a(world, structureBoundingBox, random, 12, 8, 1, StructurePieceTreasure.a(WorldGenStrongholdLibrary.a, Items.ENCHANTED_BOOK.a(random, 1, 5, 2)), 1 + random.nextInt(4));
        }
        return true;
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.BOOK, 0, 1, 3, 20), new StructurePieceTreasure(Items.PAPER, 0, 2, 7, 20), new StructurePieceTreasure(Items.MAP_EMPTY, 0, 1, 1, 1), new StructurePieceTreasure(Items.COMPASS, 0, 1, 1, 1) };
    }
}
