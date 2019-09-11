package net.minecraft.server;

public class GenLayerZoomVoronoi extends GenLayer
{
    public GenLayerZoomVoronoi(final long n, final GenLayer a) {
        super(n);
        super.a = a;
    }
    
    @Override
    public int[] a(int n, int n2, final int n3, final int n4) {
        n -= 2;
        n2 -= 2;
        final int n5 = n >> 2;
        final int n6 = n2 >> 2;
        final int n7 = (n3 >> 2) + 2;
        final int n8 = (n4 >> 2) + 2;
        final int[] a = this.a.a(n5, n6, n7, n8);
        final int n9 = n7 - 1 << 2;
        final int[] a2 = IntCache.a(n9 * (n8 - 1 << 2));
        for (int i = 0; i < n8 - 1; ++i) {
            int j = 0;
            int n10 = a[j + 0 + (i + 0) * n7];
            int n11 = a[j + 0 + (i + 1) * n7];
            while (j < n7 - 1) {
                this.a(j + n5 << 2, (long)(i + n6 << 2));
                final double n12 = (this.a(1024) / 1024.0 - 0.5) * 3.6;
                final double n13 = (this.a(1024) / 1024.0 - 0.5) * 3.6;
                this.a(j + n5 + 1 << 2, (long)(i + n6 << 2));
                final double n14 = (this.a(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double n15 = (this.a(1024) / 1024.0 - 0.5) * 3.6;
                this.a(j + n5 << 2, (long)(i + n6 + 1 << 2));
                final double n16 = (this.a(1024) / 1024.0 - 0.5) * 3.6;
                final double n17 = (this.a(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                this.a(j + n5 + 1 << 2, (long)(i + n6 + 1 << 2));
                final double n18 = (this.a(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double n19 = (this.a(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final int n20 = a[j + 1 + (i + 0) * n7] & 0xFF;
                final int n21 = a[j + 1 + (i + 1) * n7] & 0xFF;
                for (int k = 0; k < 4; ++k) {
                    int n22 = ((i << 2) + k) * n9 + (j << 2);
                    for (int l = 0; l < 4; ++l) {
                        final double n23 = (k - n13) * (k - n13) + (l - n12) * (l - n12);
                        final double n24 = (k - n15) * (k - n15) + (l - n14) * (l - n14);
                        final double n25 = (k - n17) * (k - n17) + (l - n16) * (l - n16);
                        final double n26 = (k - n19) * (k - n19) + (l - n18) * (l - n18);
                        if (n23 < n24 && n23 < n25 && n23 < n26) {
                            a2[n22++] = n10;
                        }
                        else if (n24 < n23 && n24 < n25 && n24 < n26) {
                            a2[n22++] = n20;
                        }
                        else if (n25 < n23 && n25 < n24 && n25 < n26) {
                            a2[n22++] = n11;
                        }
                        else {
                            a2[n22++] = n21;
                        }
                    }
                }
                n10 = n20;
                n11 = n21;
                ++j;
            }
        }
        final int[] a3 = IntCache.a(n3 * n4);
        for (int n27 = 0; n27 < n4; ++n27) {
            System.arraycopy(a2, (n27 + (n2 & 0x3)) * n9 + (n & 0x3), a3, n27 * n3, n3);
        }
        return a3;
    }
}
