package net.minecraft.server.v1_7_R4;

public class ChunkCoordIntPair
{
    public final int x;
    public final int z;
    
    public ChunkCoordIntPair(final int x, final int z) {
        this.x = x;
        this.z = z;
    }
    
    public static long a(final int n, final int n2) {
        return (n & 0xFFFFFFFFL) | (n2 & 0xFFFFFFFFL) << 32;
    }
    
    @Override
    public int hashCode() {
        return 1664525 * this.x + 1013904223 ^ 1664525 * (this.z ^ 0xDEADBEEF) + 1013904223;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ChunkCoordIntPair) {
            final ChunkCoordIntPair chunkCoordIntPair = (ChunkCoordIntPair)o;
            return this.x == chunkCoordIntPair.x && this.z == chunkCoordIntPair.z;
        }
        return false;
    }
    
    public int a() {
        return (this.x << 4) + 8;
    }
    
    public int b() {
        return (this.z << 4) + 8;
    }
    
    public ChunkPosition a(final int n) {
        return new ChunkPosition(this.a(), n, this.b());
    }
    
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.z + "]";
    }
}
