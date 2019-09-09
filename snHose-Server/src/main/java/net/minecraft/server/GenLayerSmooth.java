package net.minecraft.server;

public class GenLayerSmooth extends GenLayer
{
    public GenLayerSmooth(final long n, final GenLayer a) {
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
                final int n8 = a[j + 0 + (i + 1) * n7];
                final int n9 = a[j + 2 + (i + 1) * n7];
                final int n10 = a[j + 1 + (i + 0) * n7];
                final int n11 = a[j + 1 + (i + 2) * n7];
                int n12 = a[j + 1 + (i + 1) * n7];
                if (n8 == n9 && n10 == n11) {
                    this.a(j + n, (long)(i + n2));
                    n12 = (this.a(2) == 0 ? n8 : n10);
                }
                else {
                    if (n8 == n9) {
                        n12 = n8;
                    }
                    if (n10 == n11) {
                        n12 = n10;
                    }
                }
                a2[j + i * n3] = n12;
            }
        }
        return a2;
    }
}
