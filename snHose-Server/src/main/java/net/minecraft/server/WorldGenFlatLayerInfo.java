package net.minecraft.server;

public class WorldGenFlatLayerInfo
{
    private Block a;
    private int b;
    private int c;
    private int d;
    
    public WorldGenFlatLayerInfo(final int b, final Block a) {
        this.b = 1;
        this.b = b;
        this.a = a;
    }
    
    public WorldGenFlatLayerInfo(final int n, final Block block, final int c) {
        this(n, block);
        this.c = c;
    }
    
    public int a() {
        return this.b;
    }
    
    public Block b() {
        return this.a;
    }
    
    public int c() {
        return this.c;
    }
    
    public int d() {
        return this.d;
    }
    
    public void c(final int d) {
        this.d = d;
    }
    
    @Override
    public String toString() {
        String s = Integer.toString(Block.getId(this.a));
        if (this.b > 1) {
            s = this.b + "x" + s;
        }
        if (this.c > 0) {
            s = s + ":" + this.c;
        }
        return s;
    }
}
