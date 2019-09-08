package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdStairs extends WorldGenStrongholdPiece
{
    private boolean a;
    private boolean b;
    
    public WorldGenStrongholdStairs() {
    }
    
    public WorldGenStrongholdStairs(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.d = this.a(random);
        this.f = f;
        this.a = (random.nextInt(2) == 0);
        this.b = (random.nextInt(2) == 0);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Left", this.a);
        nbtTagCompound.setBoolean("Right", this.b);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getBoolean("Left");
        this.b = nbtTagCompound.getBoolean("Right");
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        this.a((WorldGenStrongholdStart)structurePiece, list, random, 1, 1);
        if (this.a) {
            this.b((WorldGenStrongholdStart)structurePiece, list, random, 1, 2);
        }
        if (this.b) {
            this.c((WorldGenStrongholdStart)structurePiece, list, random, 1, 2);
        }
    }
    
    public static WorldGenStrongholdStairs a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        if (!WorldGenStrongholdPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenStrongholdStairs(n5, random, a, n4);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 0, 0, 4, 4, 6, true, random, WorldGenStrongholdPieces.e);
        this.a(world, random, structureBoundingBox, this.d, 1, 1, 0);
        this.a(world, random, structureBoundingBox, WorldGenStrongholdDoorType.a, 1, 1, 6);
        this.a(world, structureBoundingBox, random, 0.1f, 1, 2, 1, Blocks.TORCH, 0);
        this.a(world, structureBoundingBox, random, 0.1f, 3, 2, 1, Blocks.TORCH, 0);
        this.a(world, structureBoundingBox, random, 0.1f, 1, 2, 5, Blocks.TORCH, 0);
        this.a(world, structureBoundingBox, random, 0.1f, 3, 2, 5, Blocks.TORCH, 0);
        if (this.a) {
            this.a(world, structureBoundingBox, 0, 1, 2, 0, 3, 4, Blocks.AIR, Blocks.AIR, false);
        }
        if (this.b) {
            this.a(world, structureBoundingBox, 4, 1, 2, 4, 3, 4, Blocks.AIR, Blocks.AIR, false);
        }
        return true;
    }
}
