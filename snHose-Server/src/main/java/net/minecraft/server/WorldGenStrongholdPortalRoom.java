package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdPortalRoom extends WorldGenStrongholdPiece
{
    private boolean a;
    
    public WorldGenStrongholdPortalRoom() {
    }
    
    public WorldGenStrongholdPortalRoom(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Mob", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getBoolean("Mob");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        if (structurePiece != null) {
            ((WorldGenStrongholdStart)structurePiece).b = this;
        }
    }
    
    public static WorldGenStrongholdPortalRoom a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -4, -1, 0, 11, 8, 16, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdPortalRoom(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.a(world, structureBoundingBox, 0, 0, 0, 10, 7, 15, false, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, WorldGenStrongholdDoorType.c, 4, 1, 0);
        final int n = 6;
        this.a(world, structureBoundingBox, 1, n, 1, 1, n, 14, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 9, n, 1, 9, n, 14, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 2, n, 1, 8, n, 2, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 2, n, 14, 8, n, 14, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 1, 1, 1, 2, 1, 4, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 8, 1, 1, 9, 1, 4, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 1, 1, 1, 1, 1, 3, Blocks.LAVA, Blocks.LAVA, false);
        this.a(world, structureBoundingBox, 9, 1, 1, 9, 1, 3, Blocks.LAVA, Blocks.LAVA, false);
        this.a(world, structureBoundingBox, 3, 1, 8, 7, 1, 12, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 9, 6, 1, 11, Blocks.LAVA, Blocks.LAVA, false);
        for (int i = 3; i < 14; i += 2) {
            this.a(world, structureBoundingBox, 0, 3, i, 0, 4, i, Blocks.IRON_FENCE, Blocks.IRON_FENCE, false);
            this.a(world, structureBoundingBox, 10, 3, i, 10, 4, i, Blocks.IRON_FENCE, Blocks.IRON_FENCE, false);
        }
        for (int j = 2; j < 9; j += 2) {
            this.a(world, structureBoundingBox, j, 3, 15, j, 4, 15, Blocks.IRON_FENCE, Blocks.IRON_FENCE, false);
        }
        final int a = this.a(Blocks.STONE_STAIRS, 3);
        this.a(world, structureBoundingBox, 4, 1, 5, 6, 1, 7, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 2, 6, 6, 2, 7, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 3, 7, 6, 3, 7, false, random, WorldGenStrongholdPieces.e);
        for (int k = 4; k <= 6; ++k) {
            this.a(world, Blocks.STONE_STAIRS, a, k, 1, 4, structureBoundingBox);
            this.a(world, Blocks.STONE_STAIRS, a, k, 2, 5, structureBoundingBox);
            this.a(world, Blocks.STONE_STAIRS, a, k, 3, 6, structureBoundingBox);
        }
        int n2 = 2;
        int n3 = 0;
        int n4 = 3;
        int n5 = 1;
        switch (this.g) {
            case 0: {
                n2 = 0;
                n3 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                n3 = 1;
                n4 = 0;
                n5 = 2;
                break;
            }
            case 1: {
                n2 = 1;
                n3 = 3;
                n4 = 0;
                n5 = 2;
                break;
            }
        }
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n2 + ((random.nextFloat() > 0.9f) ? 4 : 0), 4, 3, 8, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n2 + ((random.nextFloat() > 0.9f) ? 4 : 0), 5, 3, 8, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n2 + ((random.nextFloat() > 0.9f) ? 4 : 0), 6, 3, 8, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n3 + ((random.nextFloat() > 0.9f) ? 4 : 0), 4, 3, 12, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n3 + ((random.nextFloat() > 0.9f) ? 4 : 0), 5, 3, 12, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n3 + ((random.nextFloat() > 0.9f) ? 4 : 0), 6, 3, 12, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n4 + ((random.nextFloat() > 0.9f) ? 4 : 0), 3, 3, 9, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n4 + ((random.nextFloat() > 0.9f) ? 4 : 0), 3, 3, 10, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n4 + ((random.nextFloat() > 0.9f) ? 4 : 0), 3, 3, 11, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n5 + ((random.nextFloat() > 0.9f) ? 4 : 0), 7, 3, 9, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n5 + ((random.nextFloat() > 0.9f) ? 4 : 0), 7, 3, 10, structureBoundingBox);
        this.a(world, Blocks.ENDER_PORTAL_FRAME, n5 + ((random.nextFloat() > 0.9f) ? 4 : 0), 7, 3, 11, structureBoundingBox);
        if (!this.a) {
            final int a2 = this.a(3);
            final int a3 = this.a(5, 6);
            final int b = this.b(5, 6);
            if (structureBoundingBox.b(a3, a2, b)) {
                this.a = true;
                world.setTypeAndData(a3, a2, b, Blocks.MOB_SPAWNER, 0, 2);
                final TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)world.getTileEntity(a3, a2, b);
                if (tileEntityMobSpawner != null) {
                    tileEntityMobSpawner.getSpawner().setMobName("Silverfish");
                }
            }
        }
        return true;
    }
}
