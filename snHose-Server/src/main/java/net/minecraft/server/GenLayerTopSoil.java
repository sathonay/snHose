package net.minecraft.server;

public class GenLayerTopSoil extends GenLayer
{
    public GenLayerTopSoil(final long n, final GenLayer a) {
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
                final int n8 = a[j + 1 + (i + 1) * n7];
                this.a(j + n, (long)(i + n2));
                if (n8 == 0) {
                    a2[j + i * n3] = 0;
                }
                else {
                    final int a3 = this.a(6);
                    int n9;
                    if (a3 == 0) {
                        n9 = 4;
                    }
                    else if (a3 <= 1) {
                        n9 = 3;
                    }
                    else {
                        n9 = 1;
                    }
                    a2[j + i * n3] = n9;
                }
            }
        }
        return a2;
    }
}
