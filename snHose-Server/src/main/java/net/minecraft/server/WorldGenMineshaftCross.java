package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMineshaftCross extends StructurePiece
{
    private int a;
    private boolean b;
    
    public WorldGenMineshaftCross() {
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setBoolean("tf", this.b);
        nbtTagCompound.setInt("D", this.a);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        this.b = nbtTagCompound.getBoolean("tf");
        this.a = nbtTagCompound.getInt("D");
    }
    
    public WorldGenMineshaftCross(final int n, final Random random, final StructureBoundingBox f, final int a) {
        super(n);
        this.a = a;
        this.f = f;
        this.b = (f.c() > 3);
    }
    
    public static StructureBoundingBox a(final List list, final Random random, final int n, final int n2, final int n3, final int n4) {
        final StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2, n3, n, n2 + 2, n3);
        if (random.nextInt(4) == 0) {
            final StructureBoundingBox structureBoundingBox2 = structureBoundingBox;
            structureBoundingBox2.e += 4;
        }
        switch (n4) {
            case 2: {
                structureBoundingBox.a = n - 1;
                structureBoundingBox.d = n + 3;
                structureBoundingBox.c = n3 - 4;
                break;
            }
            case 0: {
                structureBoundingBox.a = n - 1;
                structureBoundingBox.d = n + 3;
                structureBoundingBox.f = n3 + 4;
                break;
            }
            case 1: {
                structureBoundingBox.a = n - 4;
                structureBoundingBox.c = n3 - 1;
                structureBoundingBox.f = n3 + 3;
                break;
            }
            case 3: {
                structureBoundingBox.d = n + 4;
                structureBoundingBox.c = n3 - 1;
                structureBoundingBox.f = n3 + 3;
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
        switch (this.a) {
            case 2: {
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.c - 1, 2, d);
                b(structurePiece, list, random, this.f.a - 1, this.f.b, this.f.c + 1, 1, d);
                b(structurePiece, list, random, this.f.d + 1, this.f.b, this.f.c + 1, 3, d);
                break;
            }
            case 0: {
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.f + 1, 0, d);
                b(structurePiece, list, random, this.f.a - 1, this.f.b, this.f.c + 1, 1, d);
                b(structurePiece, list, random, this.f.d + 1, this.f.b, this.f.c + 1, 3, d);
                break;
            }
            case 1: {
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.c - 1, 2, d);
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.f + 1, 0, d);
                b(structurePiece, list, random, this.f.a - 1, this.f.b, this.f.c + 1, 1, d);
                break;
            }
            case 3: {
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.c - 1, 2, d);
                b(structurePiece, list, random, this.f.a + 1, this.f.b, this.f.f + 1, 0, d);
                b(structurePiece, list, random, this.f.d + 1, this.f.b, this.f.c + 1, 3, d);
                break;
            }
        }
        if (this.b) {
            if (random.nextBoolean()) {
                b(structurePiece, list, random, this.f.a + 1, this.f.b + 3 + 1, this.f.c - 1, 2, d);
            }
            if (random.nextBoolean()) {
                b(structurePiece, list, random, this.f.a - 1, this.f.b + 3 + 1, this.f.c + 1, 1, d);
            }
            if (random.nextBoolean()) {
                b(structurePiece, list, random, this.f.d + 1, this.f.b + 3 + 1, this.f.c + 1, 3, d);
            }
            if (random.nextBoolean()) {
                b(structurePiece, list, random, this.f.a + 1, this.f.b + 3 + 1, this.f.f + 1, 0, d);
            }
        }
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        if (this.b) {
            this.a(world, structureBoundingBox, this.f.a + 1, this.f.b, this.f.c, this.f.d - 1, this.f.b + 3 - 1, this.f.f, Blocks.AIR, Blocks.AIR, false);
            this.a(world, structureBoundingBox, this.f.a, this.f.b, this.f.c + 1, this.f.d, this.f.b + 3 - 1, this.f.f - 1, Blocks.AIR, Blocks.AIR, false);
            this.a(world, structureBoundingBox, this.f.a + 1, this.f.e - 2, this.f.c, this.f.d - 1, this.f.e, this.f.f, Blocks.AIR, Blocks.AIR, false);
            this.a(world, structureBoundingBox, this.f.a, this.f.e - 2, this.f.c + 1, this.f.d, this.f.e, this.f.f - 1, Blocks.AIR, Blocks.AIR, false);
            this.a(world, structureBoundingBox, this.f.a + 1, this.f.b + 3, this.f.c + 1, this.f.d - 1, this.f.b + 3, this.f.f - 1, Blocks.AIR, Blocks.AIR, false);
        }
        else {
            this.a(world, structureBoundingBox, this.f.a + 1, this.f.b, this.f.c, this.f.d - 1, this.f.e, this.f.f, Blocks.AIR, Blocks.AIR, false);
            this.a(world, structureBoundingBox, this.f.a, this.f.b, this.f.c + 1, this.f.d, this.f.e, this.f.f - 1, Blocks.AIR, Blocks.AIR, false);
        }
        this.a(world, structureBoundingBox, this.f.a + 1, this.f.b, this.f.c + 1, this.f.a + 1, this.f.e, this.f.c + 1, Blocks.WOOD, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.f.a + 1, this.f.b, this.f.f - 1, this.f.a + 1, this.f.e, this.f.f - 1, Blocks.WOOD, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.f.d - 1, this.f.b, this.f.c + 1, this.f.d - 1, this.f.e, this.f.c + 1, Blocks.WOOD, Blocks.AIR, false);
        this.a(world, structureBoundingBox, this.f.d - 1, this.f.b, this.f.f - 1, this.f.d - 1, this.f.e, this.f.f - 1, Blocks.WOOD, Blocks.AIR, false);
        for (int i = this.f.a; i <= this.f.d; ++i) {
            for (int j = this.f.c; j <= this.f.f; ++j) {
                if (this.a(world, i, this.f.b - 1, j, structureBoundingBox).getMaterial() == Material.AIR) {
                    this.a(world, Blocks.WOOD, 0, i, this.f.b - 1, j, structureBoundingBox);
                }
            }
        }
        return true;
    }
}
