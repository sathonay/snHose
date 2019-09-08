package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenStrongholdCorridor extends WorldGenStrongholdPiece
{
    private int a;
    
    public WorldGenStrongholdCorridor() {
    }
    
    public WorldGenStrongholdCorridor(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
        this.a = ((g == 2 || g == 0) ? f.d() : f.b());
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setInt("Steps", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a = nbtTagCompound.getInt("Steps");
    }
    
    public static StructureBoundingBox a(final List list, final Random random, final int n, final int n2, final int n3, final int n4) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, 4, n4);
        final StructurePiece a2 = StructurePiece.a(list, a);
        if (a2 == null) {
            return null;
        }
        if (a2.c().b == a.b) {
            for (int i = 3; i >= 1; --i) {
                if (!a2.c().a(StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, i - 1, n4))) {
                    return StructureBoundingBox.a(n, n2, n3, -1, -1, 0, 5, 5, i, n4);
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        for (int i = 0; i < this.a; ++i) {
            this.a(world, Blocks.SMOOTH_BRICK, 0, 0, 0, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 0, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 0, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 0, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 4, 0, i, structureBoundingBox);
            for (int j = 1; j <= 3; ++j) {
                this.a(world, Blocks.SMOOTH_BRICK, 0, 0, j, i, structureBoundingBox);
                this.a(world, Blocks.AIR, 0, 1, j, i, structureBoundingBox);
                this.a(world, Blocks.AIR, 0, 2, j, i, structureBoundingBox);
                this.a(world, Blocks.AIR, 0, 3, j, i, structureBoundingBox);
                this.a(world, Blocks.SMOOTH_BRICK, 0, 4, j, i, structureBoundingBox);
            }
            this.a(world, Blocks.SMOOTH_BRICK, 0, 0, 4, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 1, 4, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 2, 4, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 3, 4, i, structureBoundingBox);
            this.a(world, Blocks.SMOOTH_BRICK, 0, 4, 4, i, structureBoundingBox);
        }
        return true;
    }
}
