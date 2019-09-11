package net.minecraft.server;

final class NBTReadLimiterUnlimited extends NBTReadLimiter
{
    NBTReadLimiterUnlimited(final long n) {
        super(n);
    }
    
    @Override
    public void a(final long n) {
    }
}
