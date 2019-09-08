package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenVillageStartPiece extends WorldGenVillageWell
{
    public WorldChunkManager a;
    public boolean b;
    public int c;
    public WorldGenVillagePieceWeight d;
    public List e;
    public List i;
    public List j;
    
    public WorldGenVillageStartPiece() {
        this.i = new ArrayList();
        this.j = new ArrayList();
    }
    
    public WorldGenVillageStartPiece(final WorldChunkManager a, final int n, final Random random, final int n2, final int n3, final List e, final int c) {
        super(null, 0, random, n2, n3);
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.a = a;
        this.e = e;
        this.c = c;
        final BiomeBase biome = a.getBiome(n2, n3);
        this.b = (biome == BiomeBase.DESERT || biome == BiomeBase.DESERT_HILLS);
    }
    
    public WorldChunkManager e() {
        return this.a;
    }
}
