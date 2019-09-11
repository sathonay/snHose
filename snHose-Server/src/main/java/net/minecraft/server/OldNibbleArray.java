package net.minecraft.server;

public class OldNibbleArray
{
    public final byte[] a;
    private final int b;
    private final int c;
    
    public OldNibbleArray(final byte[] a, final int b) {
        this.a = a;
        this.b = b;
        this.c = b + 4;
    }
    
    public int a(final int n, final int n2, final int n3) {
        final int n4 = n << this.c | n3 << this.b | n2;
        final int n5 = n4 >> 1;
        if ((n4 & 0x1) == 0x0) {
            return this.a[n5] & 0xF;
        }
        return this.a[n5] >> 4 & 0xF;
    }
}
