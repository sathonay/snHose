package net.minecraft.server;

class WorldGenNetherPieceWeight
{
    public Class a;
    public final int b;
    public int c;
    public int d;
    public boolean e;
    
    public WorldGenNetherPieceWeight(final Class a, final int b, final int d, final boolean e) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
    }
    
    public WorldGenNetherPieceWeight(final Class clazz, final int n, final int n2) {
        this(clazz, n, n2, false);
    }
    
    public boolean a(final int n) {
        return this.d == 0 || this.c < this.d;
    }
    
    public boolean a() {
        return this.d == 0 || this.c < this.d;
    }
}
