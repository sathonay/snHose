package net.minecraft.server;

import java.util.*;

public class BiomeCache
{
    private final WorldChunkManager a;
    private long b;
    private LongHashMap c;
    private List d;
    
    public BiomeCache(final WorldChunkManager a) {
        this.c = new LongHashMap();
        this.d = new ArrayList();
        this.a = a;
    }
    
    public BiomeCacheBlock a(int n, int n2) {
        n >>= 4;
        n2 >>= 4;
        final long n3 = (n & 0xFFFFFFFFL) | (n2 & 0xFFFFFFFFL) << 32;
        BiomeCacheBlock biomeCacheBlock = (BiomeCacheBlock)this.c.getEntry(n3);
        if (biomeCacheBlock == null) {
            biomeCacheBlock = new BiomeCacheBlock(this, n, n2);
            this.c.put(n3, biomeCacheBlock);
            this.d.add(biomeCacheBlock);
        }
        biomeCacheBlock.e = MinecraftServer.ar();
        return biomeCacheBlock;
    }
    
    public BiomeBase b(final int n, final int n2) {
        return this.a(n, n2).a(n, n2);
    }
    
    public void a() {
        final long ar = MinecraftServer.ar();
        final long n = ar - this.b;
        if (n > 7500L || n < 0L) {
            this.b = ar;
            for (int i = 0; i < this.d.size(); ++i) {
                final BiomeCacheBlock biomeCacheBlock = this.d.get(i);
                final long n2 = ar - biomeCacheBlock.e;
                if (n2 > 30000L || n2 < 0L) {
                    this.d.remove(i--);
                    this.c.remove((biomeCacheBlock.c & 0xFFFFFFFFL) | (biomeCacheBlock.d & 0xFFFFFFFFL) << 32);
                }
            }
        }
    }
    
    public BiomeBase[] d(final int n, final int n2) {
        return this.a(n, n2).b;
    }
}
