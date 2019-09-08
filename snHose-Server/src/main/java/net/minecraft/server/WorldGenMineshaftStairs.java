package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMineshaftStairs extends StructurePiece
{
    public WorldGenMineshaftStairs() {
    }
    
    public WorldGenMineshaftStairs(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
    }
    
    public static StructureBoundingBox a(final List list, final Random random, final int n, final int n2, final int n3, final int n4) {
        final StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2 - 5, n3, n, n2 + 2, n3);
        switch (n4) {
            case 2: {
                structureBoundingBox.d = n + 2;
                structureBoundingBox.c = n3 - 8;
                break;
            }
            case 0: {
                structureBoundingBox.d = n + 2;
                structureBoundingBox.f = n3 + 8;
                break;
            }
            case 1: {
                structureBoundingBox.a = n - 8;
                structureBoundingBox.f = n3 + 2;
                break;
            }
            case 3: {
                structureBoundingBox.d = n + 8;
                structureBoundingBox.f = n3 + 2;
                break;
            }
        }
        if (StructurePiece.a(list, structureBoundingBox) != null) {
            return null;
        }
        return structureBoundingBox;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        final int d = this.d();
        switch (this.g) {
            case 2: {
                b(structurePiece, list, random, this.f.a, this.f.b, this.f.c - 1, 2, d);
                break;
            }
            case 0: {
                b(structurePiece, list, random, this.f.a, this.f.b, this.f.f + 1, 0, d);
                break;
            }
            case 1: {
                b(structurePiece, list, random, this.f.a - 1, this.f.b, this.f.c, 1, d);
                break;
            }
            case 3: {
                b(structurePiece, list, random, this.f.d + 1, this.f.b, this.f.c, 3, d);
                break;
            }
        }
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, 0, 5, 0, 2, 7, 1, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, 0, 0, 7, 2, 2, 8, Blocks.AIR, Blocks.AIR, false);
        for (int i = 0; i < 5; ++i) {
            this.a(world, structureBoundingBox, 0, 5 - i - ((i < 4) ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.AIR, Blocks.AIR, false);
        }
        return true;
    }
}
