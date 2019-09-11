package net.minecraft.server;

import java.util.*;

public class BiomeCacheBlock
{
    public float[] a;
    public BiomeBase[] b;
    public int c;
    public int d;
    public long e;
    final /* synthetic */ BiomeCache f;
    
    public BiomeCacheBlock(final BiomeCache f, final int c, final int d) {
        this.f = f;
        this.a = new float[256];
        this.b = new BiomeBase[256];
        this.c = c;
        this.d = d;
        f.a.getWetness(this.a, c << 4, d << 4, 16, 16);
        f.a.a(this.b, c << 4, d << 4, 16, 16, false);
    }
    
    public BiomeBase a(final int n, final int n2) {
        return this.b[(n & 0xF) | (n2 & 0xF) << 4];
    }
}
