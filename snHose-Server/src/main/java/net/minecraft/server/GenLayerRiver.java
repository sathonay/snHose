package net.minecraft.server.v1_7_R4;

public class GenLayerRiver extends GenLayer
{
    public GenLayerRiver(final long n, final GenLayer a) {
        super(n);
        super.a = a;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n - 1;
        final int n6 = n2 - 1;
        final int n7 = n3 + 2;
        final int[] a = this.a.a(n5, n6, n7, n4 + 2);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                final int c = this.c(a[j + 0 + (i + 1) * n7]);
                final int c2 = this.c(a[j + 2 + (i + 1) * n7]);
                final int c3 = this.c(a[j + 1 + (i + 0) * n7]);
                final int c4 = this.c(a[j + 1 + (i + 2) * n7]);
                final int c5 = this.c(a[j + 1 + (i + 1) * n7]);
                if (c5 != c || c5 != c3 || c5 != c2 || c5 != c4) {
                    a2[j + i * n3] = BiomeBase.RIVER.id;
                }
                else {
                    a2[j + i * n3] = -1;
                }
            }
        }
        return a2;
    }
    
    private int c(final int n) {
        if (n >= 2) {
            return 2 + (n & 0x1);
        }
        return n;
    }
}
