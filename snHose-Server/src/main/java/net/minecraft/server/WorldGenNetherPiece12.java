package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenNetherPiece12 extends WorldGenNetherPiece
{
    private boolean b;
    
    public WorldGenNetherPiece12() {
    }
    
    public WorldGenNetherPiece12(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.b = nbtTagCompound.getBoolean("Mob");
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Mob", this.b);
    }
    
    public static WorldGenNetherPiece12 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -2, 0, 0, 7, 8, 9, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece12(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 2, 0, 6, 7, 7, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, Blocks.NETHER_FENCE, 0, 1, 6, 3, structureBoundingBox);
        this.a(world, Blocks.NETHER_FENCE, 0, 5, 6, 3, structureBoundingBox);
        this.a(world, structureBoundingBox, 0, 6, 3, 0, 6, 8, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 6, 6, 3, 6, 6, 8, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 1, 6, 8, 5, 7, 8, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        this.a(world, structureBoundingBox, 2, 8, 8, 4, 8, 8, Blocks.NETHER_FENCE, Blocks.NETHER_FENCE, false);
        if (!this.b) {
            final int a = this.a(5);
            final int a2 = this.a(3, 5);
            final int b = this.b(3, 5);
            if (structureBoundingBox.b(a2, a, b)) {
                this.b = true;
                world.setTypeAndData(a2, a, b, Blocks.MOB_SPAWNER, 0, 2);
                final TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)world.getTileEntity(a2, a, b);
                if (tileEntityMobSpawner != null) {
                    tileEntityMobSpawner.getSpawner().setMobName("Blaze");
                }
            }
        }
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this.b(world, Blocks.NETHER_BRICK, 0, i, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
