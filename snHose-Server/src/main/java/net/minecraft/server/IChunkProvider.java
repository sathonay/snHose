package net.minecraft.server;

import java.util.*;

public interface IChunkProvider
{
    boolean isChunkLoaded(final int p0, final int p1);
    
    Chunk getOrCreateChunk(final int p0, final int p1);
    
    Chunk getChunkAt(final int p0, final int p1);
    
    void getChunkAt(final IChunkProvider p0, final int p1, final int p2);
    
    boolean saveChunks(final boolean p0, final IProgressUpdate p1);
    
    boolean unloadChunks();
    
    boolean canSave();
    
    String getName();
    
    List getMobsFor(final EnumCreatureType p0, final int p1, final int p2, final int p3);
    
    ChunkPosition findNearestMapFeature(final World p0, final String p1, final int p2, final int p3, final int p4);
    
    int getLoadedChunks();
    
    void recreateStructures(final int p0, final int p1);
    
    void c();
}
