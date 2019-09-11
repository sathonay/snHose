package net.minecraft.server;

public class GenLayerPlains extends GenLayer
{
    public GenLayerPlains(final long n, final GenLayer a) {
        super(n);
        this.a = a;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.a.a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                final int n5 = a[j + 1 + (i + 1) * (n3 + 2)];
                if (this.a(57) == 0) {
                    if (n5 == BiomeBase.PLAINS.id) {
                        a2[j + i * n3] = BiomeBase.PLAINS.id + 128;
                    }
                    else {
                        a2[j + i * n3] = n5;
                    }
                }
                else {
                    a2[j + i * n3] = n5;
                }
            }
        }
        return a2;
    }
}
