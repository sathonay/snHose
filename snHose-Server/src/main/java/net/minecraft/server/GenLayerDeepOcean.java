package net.minecraft.server.v1_7_R4;

public class GenLayerDeepOcean extends GenLayer
{
    public GenLayerDeepOcean(final long n, final GenLayer a) {
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
                int n13 = 0;
                if (n8 == 0) {
                    ++n13;
                }
                if (n9 == 0) {
                    ++n13;
                }
                if (n10 == 0) {
                    ++n13;
                }
                if (n11 == 0) {
                    ++n13;
                }
                if (n12 == 0 && n13 > 3) {
                    a2[j + i * n3] = BiomeBase.DEEP_OCEAN.id;
                }
                else {
                    a2[j + i * n3] = n12;
                }
            }
        }
        return a2;
    }
}
