package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenNetherPiece2 extends WorldGenNetherPiece
{
    private int b;
    
    public WorldGenNetherPiece2() {
    }
    
    public WorldGenNetherPiece2(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
        this.b = random.nextInt();
    }
    
    public static WorldGenNetherPiece2 a(final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final StructureBoundingBox a = StructureBoundingBox.a(n, n2, n3, -1, -3, 0, 5, 10, 8, n4);
        if (!WorldGenNetherPiece.a(a) || StructurePiece.a(list, a) != null) {
            return null;
        }
        return new WorldGenNetherPiece2(n5, random, a, n4);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.b = nbtTagCompound.getInt("Seed");
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setInt("Seed", this.b);
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        final Random random2 = new Random(this.b);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 3; j <= 4; ++j) {
                this.a(world, structureBoundingBox, i, j, 0, i, j, random2.nextInt(8), Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
            }
        }
        this.a(world, structureBoundingBox, 0, 5, 0, 0, 5, random2.nextInt(8), Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        this.a(world, structureBoundingBox, 4, 5, 0, 4, 5, random2.nextInt(8), Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        for (int k = 0; k <= 4; ++k) {
            this.a(world, structureBoundingBox, k, 2, 0, k, 2, random2.nextInt(5), Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
        }
        for (int l = 0; l <= 4; ++l) {
            for (int n = 0; n <= 1; ++n) {
                this.a(world, structureBoundingBox, l, n, 0, l, n, random2.nextInt(3), Blocks.NETHER_BRICK, Blocks.NETHER_BRICK, false);
            }
        }
        return true;
    }
}
