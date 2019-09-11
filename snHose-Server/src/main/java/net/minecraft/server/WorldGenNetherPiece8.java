package net.minecraft.server;

import java.util.*;

public class WorldGenNetherPiece8 extends WorldGenNetherPiece
{
    private boolean b;
    
    public WorldGenNetherPiece8() {
    }
    
    public WorldGenNetherPiece8(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
        this.b = (random.nextInt(3) == 0);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.b = nbtTagCompound.getBoolean("Chest");
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Chest", this.b);
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.b((WorldGenNetherPiece15)structurePiece, list, random, 0, 1, true);
    }
    
    public static WorldGenNetherPiece8 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, 0, 0, 5, 7, 5, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece8(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 4, 5, 4, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 4, 3, 1, 4, 4, 1, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 4, 3, 3, 4, 4, 3, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 3, 4, 1, 4, 4, Blocks.NETHER_FENCE, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 3, 3, 4, 3, 4, 4, Blocks.NETHER_FENCE, Blocks.NETHER_BRICK, false);
        if (this.b && structureBoundingBox.b(this.a(3, 3), this.a(2), this.b(3, 3))) {
            this.b = false;
            this.a(world, structureBoundingBox, random, 3, 2, 3, WorldGenNetherPiece8.a, 2 + random.nextInt(4));
        }
        this.a(world, structureBoundingBox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
