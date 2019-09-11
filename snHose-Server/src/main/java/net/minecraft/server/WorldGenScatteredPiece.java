package net.minecraft.server;

import java.util.*;

abstract class WorldGenScatteredPiece extends StructurePiece
{
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    
    public WorldGenScatteredPiece() {
        this.d = -1;
    }
    
    protected WorldGenScatteredPiece(final Random random, final int n, final int n2, final int n3, final int a, final int b, final int c) {
        super(0);
        this.d = -1;
        this.a = a;
        this.b = b;
        this.c = c;
        switch (this.g = random.nextInt(4)) {
            case 0:
            case 2: {
                this.f = new StructureBoundingBox(n, n2, n3, n + a - 1, n2 + b - 1, n3 + c - 1);
                break;
            }
            default: {
                this.f = new StructureBoundingBox(n, n2, n3, n + c - 1, n2 + b - 1, n3 + a - 1);
                break;
            }
        }
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setInt("Width", this.a);
        nbtTagCompound.setInt("Height", this.b);
        nbtTagCompound.setInt("Depth", this.c);
        nbtTagCompound.setInt("HPos", this.d);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        this.a = nbtTagCompound.getInt("Width");
        this.b = nbtTagCompound.getInt("Height");
        this.c = nbtTagCompound.getInt("Depth");
        this.d = nbtTagCompound.getInt("HPos");
    }
    
    protected boolean a(final World world, final StructureBoundingBox structureBoundingBox, final int n) {
        if (this.d >= 0) {
            return true;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i = this.f.c; i <= this.f.f; ++i) {
            for (int j = this.f.a; j <= this.f.d; ++j) {
                if (structureBoundingBox.b(j, 64, i)) {
                    n2 += Math.max(world.i(j, i), world.worldProvider.getSeaLevel());
                    ++n3;
                }
            }
        }
        if (n3 == 0) {
            return false;
        }
        this.d = n2 / n3;
        this.f.a(0, this.d - this.f.b + n, 0);
        return true;
    }
}
