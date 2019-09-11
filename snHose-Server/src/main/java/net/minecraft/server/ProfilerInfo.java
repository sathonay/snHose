package net.minecraft.server;

public final class ProfilerInfo implements Comparable
{
    public double a;
    public double b;
    public String c;
    
    public ProfilerInfo(final String c, final double a, final double b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int a(final ProfilerInfo profilerInfo) {
        if (profilerInfo.a < this.a) {
            return -1;
        }
        if (profilerInfo.a > this.a) {
            return 1;
        }
        return profilerInfo.c.compareTo(this.c);
    }
}
