package net.minecraft.server;

import java.util.*;

public class NoiseGenerator3Handler
{
    private static int[][] e;
    public static final double a;
    private int[] f;
    public double b;
    public double c;
    public double d;
    private static final double g;
    private static final double h;
    
    public NoiseGenerator3Handler() {
        this(new Random());
    }
    
    public NoiseGenerator3Handler(final Random random) {
        this.f = new int[512];
        this.b = random.nextDouble() * 256.0;
        this.c = random.nextDouble() * 256.0;
        this.d = random.nextDouble() * 256.0;
        for (int i = 0; i < 256; ++i) {
            this.f[i] = i;
        }
        for (int j = 0; j < 256; ++j) {
            final int n = random.nextInt(256 - j) + j;
            final int n2 = this.f[j];
            this.f[j] = this.f[n];
            this.f[n] = n2;
            this.f[j + 256] = this.f[j];
        }
    }
    
    private static int a(final double n) {
        return (n > 0.0) ? ((int)n) : ((int)n - 1);
    }
    
    private static double a(final int[] array, final double n, final double n2) {
        return array[0] * n + array[1] * n2;
    }
    
    public double a(final double n, final double n2) {
        final double n3 = (n + n2) * (0.5 * (NoiseGenerator3Handler.a - 1.0));
        final int a = a(n + n3);
        final int a2 = a(n2 + n3);
        final double n4 = (3.0 - NoiseGenerator3Handler.a) / 6.0;
        final double n5 = (a + a2) * n4;
        final double n6 = a - n5;
        final double n7 = a2 - n5;
        final double n8 = n - n6;
        final double n9 = n2 - n7;
        int n10;
        int n11;
        if (n8 > n9) {
            n10 = 1;
            n11 = 0;
        }
        else {
            n10 = 0;
            n11 = 1;
        }
        final double n12 = n8 - n10 + n4;
        final double n13 = n9 - n11 + n4;
        final double n14 = n8 - 1.0 + 2.0 * n4;
        final double n15 = n9 - 1.0 + 2.0 * n4;
        final int n16 = a & 0xFF;
        final int n17 = a2 & 0xFF;
        final int n18 = this.f[n16 + this.f[n17]] % 12;
        final int n19 = this.f[n16 + n10 + this.f[n17 + n11]] % 12;
        final int n20 = this.f[n16 + 1 + this.f[n17 + 1]] % 12;
        final double n21 = 0.5 - n8 * n8 - n9 * n9;
        double n22;
        if (n21 < 0.0) {
            n22 = 0.0;
        }
        else {
            final double n23 = n21 * n21;
            n22 = n23 * n23 * a(NoiseGenerator3Handler.e[n18], n8, n9);
        }
        final double n24 = 0.5 - n12 * n12 - n13 * n13;
        double n25;
        if (n24 < 0.0) {
            n25 = 0.0;
        }
        else {
            final double n26 = n24 * n24;
            n25 = n26 * n26 * a(NoiseGenerator3Handler.e[n19], n12, n13);
        }
        final double n27 = 0.5 - n14 * n14 - n15 * n15;
        double n28;
        if (n27 < 0.0) {
            n28 = 0.0;
        }
        else {
            final double n29 = n27 * n27;
            n28 = n29 * n29 * a(NoiseGenerator3Handler.e[n20], n14, n15);
        }
        return 70.0 * (n22 + n25 + n28);
    }
    
    public void a(final double[] array, final double n, final double n2, final int n3, final int n4, final double n5, final double n6, final double n7) {
        int n8 = 0;
        for (int i = 0; i < n4; ++i) {
            final double n9 = (n2 + i) * n6 + this.c;
            for (int j = 0; j < n3; ++j) {
                final double n10 = (n + j) * n5 + this.b;
                final double n11 = (n10 + n9) * NoiseGenerator3Handler.g;
                final int a = a(n10 + n11);
                final int a2 = a(n9 + n11);
                final double n12 = (a + a2) * NoiseGenerator3Handler.h;
                final double n13 = a - n12;
                final double n14 = a2 - n12;
                final double n15 = n10 - n13;
                final double n16 = n9 - n14;
                int n17;
                int n18;
                if (n15 > n16) {
                    n17 = 1;
                    n18 = 0;
                }
                else {
                    n17 = 0;
                    n18 = 1;
                }
                final double n19 = n15 - n17 + NoiseGenerator3Handler.h;
                final double n20 = n16 - n18 + NoiseGenerator3Handler.h;
                final double n21 = n15 - 1.0 + 2.0 * NoiseGenerator3Handler.h;
                final double n22 = n16 - 1.0 + 2.0 * NoiseGenerator3Handler.h;
                final int n23 = a & 0xFF;
                final int n24 = a2 & 0xFF;
                final int n25 = this.f[n23 + this.f[n24]] % 12;
                final int n26 = this.f[n23 + n17 + this.f[n24 + n18]] % 12;
                final int n27 = this.f[n23 + 1 + this.f[n24 + 1]] % 12;
                final double n28 = 0.5 - n15 * n15 - n16 * n16;
                double n29;
                if (n28 < 0.0) {
                    n29 = 0.0;
                }
                else {
                    final double n30 = n28 * n28;
                    n29 = n30 * n30 * a(NoiseGenerator3Handler.e[n25], n15, n16);
                }
                final double n31 = 0.5 - n19 * n19 - n20 * n20;
                double n32;
                if (n31 < 0.0) {
                    n32 = 0.0;
                }
                else {
                    final double n33 = n31 * n31;
                    n32 = n33 * n33 * a(NoiseGenerator3Handler.e[n26], n19, n20);
                }
                final double n34 = 0.5 - n21 * n21 - n22 * n22;
                double n35;
                if (n34 < 0.0) {
                    n35 = 0.0;
                }
                else {
                    final double n36 = n34 * n34;
                    n35 = n36 * n36 * a(NoiseGenerator3Handler.e[n27], n21, n22);
                }
                final int n37 = n8++;
                array[n37] += 70.0 * (n29 + n32 + n35) * n7;
            }
        }
    }
    
    static {
        NoiseGenerator3Handler.e = new int[][] { { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 }, { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 }, { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 } };
        a = Math.sqrt(3.0);
        g = 0.5 * (NoiseGenerator3Handler.a - 1.0);
        h = (3.0 - NoiseGenerator3Handler.a) / 6.0;
    }
}
