package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenNetherPiece15 extends WorldGenNetherPiece1
{
    public WorldGenNetherPieceWeight b;
    public List c;
    public List d;
    public ArrayList e;
    
    public WorldGenNetherPiece15() {
        this.e = new ArrayList();
    }
    
    public WorldGenNetherPiece15(final Random random, final int n, final int n2) {
        super(random, n, n2);
        this.e = new ArrayList();
        this.c = new ArrayList();
        for (final WorldGenNetherPieceWeight worldGenNetherPieceWeight : WorldGenNetherPieces.a) {
            worldGenNetherPieceWeight.c = 0;
            this.c.add(worldGenNetherPieceWeight);
        }
        this.d = new ArrayList();
        for (final WorldGenNetherPieceWeight worldGenNetherPieceWeight2 : WorldGenNetherPieces.b) {
            worldGenNetherPieceWeight2.c = 0;
            this.d.add(worldGenNetherPieceWeight2);
        }
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
    }
}
