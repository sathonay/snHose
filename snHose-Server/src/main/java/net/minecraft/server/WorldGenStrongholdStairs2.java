package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdStairs2 extends WorldGenStrongholdPiece
{
    private boolean a;
    
    public WorldGenStrongholdStairs2() {
    }
    
    public WorldGenStrongholdStairs2(final int n, final Random random, final int n2, final int n3) {
        super(n);
        this.a = true;
        this.g = random.nextInt(4);
        this.d = WorldGenStrongholdDoorType.a;
        switch (this.g) {
            case 0:
            case 2: {
                this.f = new StructureBoundingBox(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
                break;
            }
            default: {
                this.f = new StructureBoundingBox(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
                break;
            }
        }
    }
    
    public WorldGenStrongholdStairs2(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.a = false;
        this.g = g;
        this.d = this.a(random);
        this.f = f;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Source", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getBoolean("Source");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        if (this.a) {
            WorldGenStrongholdPieces.d = WorldGenStrongholdCrossing.class;
        }
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
    }
    
    public static WorldGenStrongholdStairs2 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -7, 0, 5, 11, 5, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdStairs2(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 10, 4, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 7, 0);
        this.a(world, random, structureBoundingBox, WorldGenStrongholdDoorType.a, 1, 1, 4);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 6, 1, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 5, 1, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 1, 6, 1, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 5, 2, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 4, 3, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 1, 5, 3, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 4, 3, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 3, 3, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 3, 4, 3, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 3, 2, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 2, 1, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 3, 3, 1, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 2, 1, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 1, 1, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 1, 2, 1, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 1, 2, structureBoundingBox);
        this.a(world, Blocks.STEP, 0, 1, 1, 3, structureBoundingBox);
        return true;
    }
}
