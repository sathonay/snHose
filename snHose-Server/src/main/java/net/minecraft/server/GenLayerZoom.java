package net.minecraft.server;

public class GenLayerZoom extends GenLayer
{
    public GenLayerZoom(final long n, final GenLayer a) {
        super(n);
        super.a = a;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n >> 1;
        final int n6 = n2 >> 1;
        final int n7 = (n3 >> 1) + 2;
        final int n8 = (n4 >> 1) + 2;
        final int[] a = this.a.a(n5, n6, n7, n8);
        final int n9 = n7 - 1 << 1;
        final int[] a2 = IntCache.a(n9 * (n8 - 1 << 1));
        for (int i = 0; i < n8 - 1; ++i) {
            int n10 = (i << 1) * n9;
            int j = 0;
            int n11 = a[j + 0 + (i + 0) * n7];
            int n12 = a[j + 0 + (i + 1) * n7];
            while (j < n7 - 1) {
                this.a(j + n5 << 1, (long)(i + n6 << 1));
                final int n13 = a[j + 1 + (i + 0) * n7];
                final int n14 = a[j + 1 + (i + 1) * n7];
                a2[n10] = n11;
                a2[n10++ + n9] = this.a(new int[] { n11, n12 });
                a2[n10] = this.a(new int[] { n11, n13 });
                a2[n10++ + n9] = this.b(n11, n13, n12, n14);
                n11 = n13;
                n12 = n14;
                ++j;
            }
        }
        final int[] a3 = IntCache.a(n3 * n4);
        for (int k = 0; k < n4; ++k) {
            System.arraycopy(a2, (k + (n2 & 0x1)) * n9 + (n & 0x1), a3, k * n3, n3);
        }
        return a3;
    }
    
    public static GenLayer b(final long n, final GenLayer genLayer, final int n2) {
        GenLayer genLayer2 = genLayer;
        for (int i = 0; i < n2; ++i) {
            genLayer2 = new GenLayerZoom(n + i, genLayer2);
        }
        return genLayer2;
    }
}
