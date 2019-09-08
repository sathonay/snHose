package net.minecraft.server.v1_7_R4;

final class NBTReadLimiterUnlimited extends NBTReadLimiter
{
    NBTReadLimiterUnlimited(final long n) {
        super(n);
    }
    
    @Override
    public void a(final long n) {
    }
}
