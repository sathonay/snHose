package net.minecraft.server;

public class BlockActionData
{
    private int a;
    private int b;
    private int c;
    private Block d;
    private int e;
    private int f;
    
    public BlockActionData(final int a, final int b, final int c, final Block d, final int e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
        this.d = d;
    }
    
    public int a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
    
    public int d() {
        return this.e;
    }
    
    public int e() {
        return this.f;
    }
    
    public Block f() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof BlockActionData) {
            final BlockActionData blockActionData = (BlockActionData)o;
            return this.a == blockActionData.a && this.b == blockActionData.b && this.c == blockActionData.c && this.e == blockActionData.e && this.f == blockActionData.f && this.d == blockActionData.d;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "TE(" + this.a + "," + this.b + "," + this.c + ")," + this.e + "," + this.f + "," + this.d;
    }
}
