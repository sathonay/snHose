package net.minecraft.server.v1_7_R4;

class PackStatisticData
{
    private final long a;
    private final int b;
    private final double c;
    
    private PackStatisticData(final long a, final int b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public PackStatisticData a(final long n) {
        return new PackStatisticData(n + this.a, this.b + 1, (n + this.a) / (this.b + 1));
    }
    
    public long a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    @Override
    public String toString() {
        return "{totalBytes=" + this.a + ", count=" + this.b + ", averageBytes=" + this.c + '}';
    }
}
