package net.minecraft.server;

public class GenLayerIcePlains extends GenLayer
{
    public GenLayerIcePlains(final long n, final GenLayer a) {
        super(n);
        this.a = a;
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
                final int n8 = a[j + 1 + (i + 1 - 1) * (n3 + 2)];
                final int n9 = a[j + 1 + 1 + (i + 1) * (n3 + 2)];
                final int n10 = a[j + 1 - 1 + (i + 1) * (n3 + 2)];
                final int n11 = a[j + 1 + (i + 1 + 1) * (n3 + 2)];
                final int n12 = a[j + 1 + (i + 1) * n7];
                a2[j + i * n3] = n12;
                this.a(j + n, (long)(i + n2));
                if (n12 == 0 && n8 == 0 && n9 == 0 && n10 == 0 && n11 == 0 && this.a(2) == 0) {
                    a2[j + i * n3] = 1;
                }
            }
        }
        return a2;
    }
}
