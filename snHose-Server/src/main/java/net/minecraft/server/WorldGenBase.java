package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenBase
{
    protected int a;
    protected Random b;
    protected World c;
    
    public WorldGenBase() {
        this.a = 8;
        this.b = new Random();
    }
    
    public void a(final IChunkProvider chunkProvider, final World c, final int n, final int n2, final Block[] array) {
        final int a = this.a;
        this.c = c;
        this.b.setSeed(c.getSeed());
        final long nextLong = this.b.nextLong();
        final long nextLong2 = this.b.nextLong();
        for (int i = n - a; i <= n + a; ++i) {
            for (int j = n2 - a; j <= n2 + a; ++j) {
                this.b.setSeed(i * nextLong ^ j * nextLong2 ^ c.getSeed());
                this.a(c, i, j, n, n2, array);
            }
        }
    }
    
    protected void a(final World world, final int n, final int n2, final int n3, final int n4, final Block[] array) {
    }
}
