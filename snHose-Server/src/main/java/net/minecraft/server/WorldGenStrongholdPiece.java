package net.minecraft.server.v1_7_R4;

import java.util.*;

abstract class WorldGenStrongholdPiece extends StructurePiece
{
    protected WorldGenStrongholdDoorType d;
    
    public WorldGenStrongholdPiece() {
        this.d = WorldGenStrongholdDoorType.a;
    }
    
    protected WorldGenStrongholdPiece(final int n) {
        super(n);
        this.d = WorldGenStrongholdDoorType.a;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setString("EntryDoor", this.d.name());
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        this.d = WorldGenStrongholdDoorType.valueOf(nbtTagCompound.getString("EntryDoor"));
    }
    
    protected void a(final World world, final Random random, final StructureBoundingBox structureBoundingBox, final WorldGenStrongholdDoorType worldGenStrongholdDoorType, final int n, final int n2, final int n3) {
        switch (WorldGenStrongholdPieceWeight3.a[worldGenStrongholdDoorType.ordinal()]) {
            default: {
                this.a(world, structureBoundingBox, n, n2, n3, n + 3 - 1, n2 + 3 - 1, n3, Blocks.AIR, Blocks.AIR, false);
                break;
            }
            case 2: {
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 1, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2, n3, structureBoundingBox);
                this.a(world, Blocks.WOODEN_DOOR, 0, n + 1, n2, n3, structureBoundingBox);
                this.a(world, Blocks.WOODEN_DOOR, 8, n + 1, n2 + 1, n3, structureBoundingBox);
                break;
            }
            case 3: {
                this.a(world, Blocks.AIR, 0, n + 1, n2, n3, structureBoundingBox);
                this.a(world, Blocks.AIR, 0, n + 1, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n, n2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n + 1, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n + 2, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n + 2, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_FENCE, 0, n + 2, n2, n3, structureBoundingBox);
                break;
            }
            case 4: {
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 1, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2 + 2, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, n + 2, n2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_DOOR_BLOCK, 0, n + 1, n2, n3, structureBoundingBox);
                this.a(world, Blocks.IRON_DOOR_BLOCK, 8, n + 1, n2 + 1, n3, structureBoundingBox);
                this.a(world, Blocks.STONE_BUTTON, this.a(Blocks.STONE_BUTTON, 4), n + 2, n2 + 1, n3 + 1, structureBoundingBox);
                this.a(world, Blocks.STONE_BUTTON, this.a(Blocks.STONE_BUTTON, 3), n + 2, n2 + 1, n3 - 1, structureBoundingBox);
                break;
            }
        }
    }
    
    protected WorldGenStrongholdDoorType a(final Random random) {
        switch (random.nextInt(5)) {
            default: {
                return WorldGenStrongholdDoorType.a;
            }
            case 2: {
                return WorldGenStrongholdDoorType.b;
            }
            case 3: {
                return WorldGenStrongholdDoorType.c;
            }
            case 4: {
                return WorldGenStrongholdDoorType.d;
            }
        }
    }
    
    protected StructurePiece a(final WorldGenStrongholdStart worldGenStrongholdStart, final List list, final Random random, final int n, final int n2) {
        switch (this.g) {
            case 2: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n, this.f.b + n2, this.f.c - 1, this.g, this.d());
            }
            case 0: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n, this.f.b + n2, this.f.f + 1, this.g, this.d());
            }
            case 1: {
                return c(worldGenStrongholdStart, list, random, this.f.a - 1, this.f.b + n2, this.f.c + n, this.g, this.d());
            }
            case 3: {
                return c(worldGenStrongholdStart, list, random, this.f.d + 1, this.f.b + n2, this.f.c + n, this.g, this.d());
            }
            default: {
                return null;
            }
        }
    }
    
    protected StructurePiece b(final WorldGenStrongholdStart worldGenStrongholdStart, final List list, final Random random, final int n, final int n2) {
        switch (this.g) {
            case 2: {
                return c(worldGenStrongholdStart, list, random, this.f.a - 1, this.f.b + n, this.f.c + n2, 1, this.d());
            }
            case 0: {
                return c(worldGenStrongholdStart, list, random, this.f.a - 1, this.f.b + n, this.f.c + n2, 1, this.d());
            }
            case 1: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n2, this.f.b + n, this.f.c - 1, 2, this.d());
            }
            case 3: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n2, this.f.b + n, this.f.c - 1, 2, this.d());
            }
            default: {
                return null;
            }
        }
    }
    
    protected StructurePiece c(final WorldGenStrongholdStart worldGenStrongholdStart, final List list, final Random random, final int n, final int n2) {
        switch (this.g) {
            case 2: {
                return c(worldGenStrongholdStart, list, random, this.f.d + 1, this.f.b + n, this.f.c + n2, 3, this.d());
            }
            case 0: {
                return c(worldGenStrongholdStart, list, random, this.f.d + 1, this.f.b + n, this.f.c + n2, 3, this.d());
            }
            case 1: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n2, this.f.b + n, this.f.f + 1, 0, this.d());
            }
            case 3: {
                return c(worldGenStrongholdStart, list, random, this.f.a + n2, this.f.b + n, this.f.f + 1, 0, this.d());
            }
            default: {
                return null;
            }
        }
    }
    
    protected static boolean a(final StructureBoundingBox structureBoundingBox) {
        return structureBoundingBox != null && structureBoundingBox.b > 10;
    }
}
