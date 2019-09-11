package net.minecraft.server;

public class BiomeMeta extends WeightedRandomChoice
{
    public Class b;
    public int c;
    public int d;
    
    public BiomeMeta(final Class b, final int n, final int c, final int d) {
        super(n);
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public String toString() {
        return this.b.getSimpleName() + "*(" + this.c + "-" + this.d + "):" + this.a;
    }
}
