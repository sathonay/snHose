package net.minecraft.server.v1_7_R4;

public class NBTReadLimiter
{
    public static final NBTReadLimiter a;
    private final long b;
    private long c;
    
    public NBTReadLimiter(final long b) {
        this.b = b;
    }
    
    public void a(final long n) {
        this.c += n / 8L;
        if (this.c > this.b) {
            throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.c + "bytes where max allowed: " + this.b);
        }
    }
    
    static {
        a = new NBTReadLimiterUnlimited(0L);
    }
}
