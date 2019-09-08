package net.minecraft.server.v1_7_R4;

import java.util.*;

public class NoiseGeneratorPerlin extends NoiseGenerator
{
    private int[] d;
    public double a;
    public double b;
    public double c;
    private static final double[] e;
    private static final double[] f;
    private static final double[] g;
    private static final double[] h;
    private static final double[] i;
    
    public NoiseGeneratorPerlin() {
        this(new Random());
    }
    
    public NoiseGeneratorPerlin(final Random random) {
        this.d = new int[512];
        this.a = random.nextDouble() * 256.0;
        this.b = random.nextDouble() * 256.0;
        this.c = random.nextDouble() * 256.0;
        for (int i = 0; i < 256; ++i) {
            this.d[i] = i;
        }
        for (int j = 0; j < 256; ++j) {
            final int n = random.nextInt(256 - j) + j;
            final int n2 = this.d[j];
            this.d[j] = this.d[n];
            this.d[n] = n2;
            this.d[j + 256] = this.d[j];
        }
    }
    
    public final double b(final double n, final double n2, final double n3) {
        return n2 + n * (n3 - n2);
    }
    
    public final double a(final int n, final double n2, final double n3) {
        final int n4 = n & 0xF;
        return NoiseGeneratorPerlin.h[n4] * n2 + NoiseGeneratorPerlin.i[n4] * n3;
    }
    
    public final double a(final int n, final double n2, final double n3, final double n4) {
        final int n5 = n & 0xF;
        return NoiseGeneratorPerlin.e[n5] * n2 + NoiseGeneratorPerlin.f[n5] * n3 + NoiseGeneratorPerlin.g[n5] * n4;
    }
    
    public void a(final double[] array, final double n, final double n2, final double n3, final int n4, final int n5, final int n6, final double n7, final double n8, final double n9, final double n10) {
        if (n5 == 1) {
            int n11 = 0;
            final double n12 = 1.0 / n10;
            for (int i = 0; i < n4; ++i) {
                final double n13 = n + i * n7 + this.a;
                int n14 = (int)n13;
                if (n13 < n14) {
                    --n14;
                }
                final int n15 = n14 & 0xFF;
                final double n16 = n13 - n14;
                final double n17 = n16 * n16 * n16 * (n16 * (n16 * 6.0 - 15.0) + 10.0);
                for (int j = 0; j < n6; ++j) {
                    final double n18 = n3 + j * n9 + this.c;
                    int n19 = (int)n18;
                    if (n18 < n19) {
                        --n19;
                    }
                    final int n20 = n19 & 0xFF;
                    final double n21 = n18 - n19;
                    final double n22 = n21 * n21 * n21 * (n21 * (n21 * 6.0 - 15.0) + 10.0);
                    final int n23 = this.d[this.d[n15] + 0] + n20;
                    final int n24 = this.d[this.d[n15 + 1] + 0] + n20;
                    final double b = this.b(n22, this.b(n17, this.a(this.d[n23], n16, n21), this.a(this.d[n24], n16 - 1.0, 0.0, n21)), this.b(n17, this.a(this.d[n23 + 1], n16, 0.0, n21 - 1.0), this.a(this.d[n24 + 1], n16 - 1.0, 0.0, n21 - 1.0)));
                    final int n25 = n11++;
                    array[n25] += b * n12;
                }
            }
            return;
        }
        int n26 = 0;
        final double n27 = 1.0 / n10;
        int n28 = -1;
        double b2 = 0.0;
        double b3 = 0.0;
        double b4 = 0.0;
        double b5 = 0.0;
        for (int k = 0; k < n4; ++k) {
            final double n29 = n + k * n7 + this.a;
            int n30 = (int)n29;
            if (n29 < n30) {
                --n30;
            }
            final int n31 = n30 & 0xFF;
            final double n32 = n29 - n30;
            final double n33 = n32 * n32 * n32 * (n32 * (n32 * 6.0 - 15.0) + 10.0);
            for (int l = 0; l < n6; ++l) {
                final double n34 = n3 + l * n9 + this.c;
                int n35 = (int)n34;
                if (n34 < n35) {
                    --n35;
                }
                final int n36 = n35 & 0xFF;
                final double n37 = n34 - n35;
                final double n38 = n37 * n37 * n37 * (n37 * (n37 * 6.0 - 15.0) + 10.0);
                for (int n39 = 0; n39 < n5; ++n39) {
                    final double n40 = n2 + n39 * n8 + this.b;
                    int n41 = (int)n40;
                    if (n40 < n41) {
                        --n41;
                    }
                    final int n42 = n41 & 0xFF;
                    final double n43 = n40 - n41;
                    final double n44 = n43 * n43 * n43 * (n43 * (n43 * 6.0 - 15.0) + 10.0);
                    if (n39 == 0 || n42 != n28) {
                        n28 = n42;
                        final int n45 = this.d[n31] + n42;
                        final int n46 = this.d[n45] + n36;
                        final int n47 = this.d[n45 + 1] + n36;
                        final int n48 = this.d[n31 + 1] + n42;
                        final int n49 = this.d[n48] + n36;
                        final int n50 = this.d[n48 + 1] + n36;
                        b2 = this.b(n33, this.a(this.d[n46], n32, n43, n37), this.a(this.d[n49], n32 - 1.0, n43, n37));
                        b3 = this.b(n33, this.a(this.d[n47], n32, n43 - 1.0, n37), this.a(this.d[n50], n32 - 1.0, n43 - 1.0, n37));
                        b4 = this.b(n33, this.a(this.d[n46 + 1], n32, n43, n37 - 1.0), this.a(this.d[n49 + 1], n32 - 1.0, n43, n37 - 1.0));
                        b5 = this.b(n33, this.a(this.d[n47 + 1], n32, n43 - 1.0, n37 - 1.0), this.a(this.d[n50 + 1], n32 - 1.0, n43 - 1.0, n37 - 1.0));
                    }
                    final double b6 = this.b(n38, this.b(n44, b2, b3), this.b(n44, b4, b5));
                    final int n51 = n26++;
                    array[n51] += b6 * n27;
                }
            }
        }
    }
    
    static {
        e = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        f = new double[] { 1.0, 1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0 };
        g = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
        h = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        i = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
    }
}
