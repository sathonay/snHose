package net.minecraft.server;

public class PathPoint
{
    public final int a;
    public final int b;
    public final int c;
    private final int j;
    int d;
    float e;
    float f;
    float g;
    PathPoint h;
    public boolean i;
    
    public PathPoint(final int a, final int b, final int c) {
        this.d = -1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.j = a(a, b, c);
    }
    
    public static int a(final int n, final int n2, final int n3) {
        return (n2 & 0xFF) | (n & 0x7FFF) << 8 | (n3 & 0x7FFF) << 24 | ((n < 0) ? Integer.MIN_VALUE : 0) | ((n3 < 0) ? 32768 : 0);
    }
    
    public float a(final PathPoint pathPoint) {
        final float n = pathPoint.a - this.a;
        final float n2 = pathPoint.b - this.b;
        final float n3 = pathPoint.c - this.c;
        return MathHelper.c(n * n + n2 * n2 + n3 * n3);
    }
    
    public float b(final PathPoint pathPoint) {
        final float n = pathPoint.a - this.a;
        final float n2 = pathPoint.b - this.b;
        final float n3 = pathPoint.c - this.c;
        return n * n + n2 * n2 + n3 * n3;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof PathPoint) {
            final PathPoint pathPoint = (PathPoint)o;
            return this.j == pathPoint.j && this.a == pathPoint.a && this.b == pathPoint.b && this.c == pathPoint.c;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.j;
    }
    
    public boolean a() {
        return this.d >= 0;
    }
    
    @Override
    public String toString() {
        return this.a + ", " + this.b + ", " + this.c;
    }
}
