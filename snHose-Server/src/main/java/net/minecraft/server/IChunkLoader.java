package net.minecraft.server;

public interface IChunkLoader
{
    Chunk a(final World p0, final int p1, final int p2);
    
    void a(final World p0, final Chunk p1);
    
    void b(final World p0, final Chunk p1);
    
    void a();
    
    void b();
}
