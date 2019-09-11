package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdStart extends WorldGenStrongholdStairs2
{
    public WorldGenStrongholdPieceWeight a;
    public WorldGenStrongholdPortalRoom b;
    public List c;
    
    public WorldGenStrongholdStart() {
        this.c = new ArrayList();
    }
    
    public WorldGenStrongholdStart(final int n, final Random random, final int n2, final int n3) {
        super(0, random, n2, n3);
        this.c = new ArrayList();
    }
    
    @Override
    public ChunkPosition a() {
        if (this.b != null) {
            return this.b.a();
        }
        return super.a();
    }
}
