package net.minecraft.server;

public class GenLayerSpecial extends GenLayer
{
    private final EnumGenLayerSpecial c;
    
    public GenLayerSpecial(final long n, final GenLayer a, final EnumGenLayerSpecial c) {
        super(n);
        this.a = a;
        this.c = c;
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        switch (GenLayerJumpTable.a[this.c.ordinal()]) {
            default: {
                return this.c(n, n2, n3, n4);
            }
            case 2: {
                return this.d(n, n2, n3, n4);
            }
            case 3: {
                return this.e(n, n2, n3, n4);
            }
        }
    }
    
    private int[] c(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n - 1;
        final int n6 = n2 - 1;
        final int n7 = 1 + n3 + 1;
        final int[] a = this.a.a(n5, n6, n7, 1 + n4 + 1);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                int n8 = a[j + 1 + (i + 1) * n7];
                if (n8 == 1) {
                    final int n9 = a[j + 1 + (i + 1 - 1) * n7];
                    final int n10 = a[j + 1 + 1 + (i + 1) * n7];
                    final int n11 = a[j + 1 - 1 + (i + 1) * n7];
                    final int n12 = a[j + 1 + (i + 1 + 1) * n7];
                    final boolean b = n9 == 3 || n10 == 3 || n11 == 3 || n12 == 3;
                    final boolean b2 = n9 == 4 || n10 == 4 || n11 == 4 || n12 == 4;
                    if (b || b2) {
                        n8 = 2;
                    }
                }
                a2[j + i * n3] = n8;
            }
        }
        return a2;
    }
    
    private int[] d(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n - 1;
        final int n6 = n2 - 1;
        final int n7 = 1 + n3 + 1;
        final int[] a = this.a.a(n5, n6, n7, 1 + n4 + 1);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n8 = a[j + 1 + (i + 1) * n7];
                if (n8 == 4) {
                    final int n9 = a[j + 1 + (i + 1 - 1) * n7];
                    final int n10 = a[j + 1 + 1 + (i + 1) * n7];
                    final int n11 = a[j + 1 - 1 + (i + 1) * n7];
                    final int n12 = a[j + 1 + (i + 1 + 1) * n7];
                    final boolean b = n9 == 2 || n10 == 2 || n11 == 2 || n12 == 2;
                    if (n9 == 1 || n10 == 1 || n11 == 1 || n12 == 1 || b) {
                        n8 = 3;
                    }
                }
                a2[j + i * n3] = n8;
            }
        }
        return a2;
    }
    
    private int[] e(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.a.a(n, n2, n3, n4);
        final int[] a2 = IntCache.a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.a(j + n, (long)(i + n2));
                int n5 = a[j + i * n3];
                if (n5 != 0 && this.a(13) == 0) {
                    n5 |= (1 + this.a(15) << 8 & 0xF00);
                }
                a2[j + i * n3] = n5;
            }
        }
        return a2;
    }
}
