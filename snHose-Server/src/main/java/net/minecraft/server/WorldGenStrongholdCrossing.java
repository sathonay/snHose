package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdCrossing extends WorldGenStrongholdPiece
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean e;
    
    public WorldGenStrongholdCrossing() {
    }
    
    public WorldGenStrongholdCrossing(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
        this.a = random.nextBoolean();
        this.b = random.nextBoolean();
        this.c = random.nextBoolean();
        this.e = (random.nextInt(3) > 0);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("leftLow", this.a);
        nbtTagCompound.setBoolean("leftHigh", this.b);
        nbtTagCompound.setBoolean("rightLow", this.c);
        nbtTagCompound.setBoolean("rightHigh", this.e);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getBoolean("leftLow");
        this.b = nbtTagCompound.getBoolean("leftHigh");
        this.c = nbtTagCompound.getBoolean("rightLow");
        this.e = nbtTagCompound.getBoolean("rightHigh");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        int n = 3;
        int n2 = 5;
        if (this.g == 1 || this.g == 2) {
            n = 8 - n;
            n2 = 8 - n2;
        }
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 5, 1);
        if (this.a) {
            this.b((WorldGenStrongholdStart)structurePiece, list, random, n, 1);
        }
        if (this.b) {
            this.b((WorldGenStrongholdStart)structurePiece, list, random, n2, 7);
        }
        if (this.c) {
            this.c((WorldGenStrongholdStart)structurePiece, list, random, n, 1);
        }
        if (this.e) {
            this.c((WorldGenStrongholdStart)structurePiece, list, random, n2, 7);
        }
    }
    
    public static WorldGenStrongholdCrossing a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -4, -3, 0, 10, 9, 11, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdCrossing(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 9, 8, 10, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 4, 3, 0);
        if (this.a) {
            this.a(world, structureBoundingBox, 0, 3, 1, 0, 5, 3, Blocks.AIR, Blocks.AIR, false);
        }
        if (this.c) {
            this.a(world, structureBoundingBox, 9, 3, 1, 9, 5, 3, Blocks.AIR, Blocks.AIR, false);
        }
        if (this.b) {
            this.a(world, structureBoundingBox, 0, 5, 7, 0, 7, 9, Blocks.AIR, Blocks.AIR, false);
        }
        if (this.e) {
            this.a(world, structureBoundingBox, 9, 5, 7, 9, 7, 9, Blocks.AIR, Blocks.AIR, false);
        }
        this.a(world, structureBoundingBox, 5, 1, 10, 7, 3, 10, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 1, 2, 1, 8, 2, 6, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 4, 1, 5, 4, 4, 9, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 8, 1, 5, 8, 4, 9, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 1, 4, 7, 3, 4, 9, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 1, 3, 5, 3, 3, 6, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 1, 3, 4, 3, 3, 4, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 1, 4, 6, 3, 4, 6, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 5, 1, 7, 7, 1, 8, false, random, WorldGenStrongholdPieces.e);
        this.a(world, structureBoundingBox, 5, 1, 9, 7, 1, 9, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 5, 2, 7, 7, 2, 7, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 4, 5, 7, 4, 5, 9, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 8, 5, 7, 8, 5, 9, Blocks.STEP, Blocks.STEP, false);
        this.a(world, structureBoundingBox, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_STEP, Blocks.DOUBLE_STEP, false);
        this.a(world, Blocks.TORCH, 0, 6, 5, 6, structureBoundingBox);
        return true;
    }
}
