package net.minecraft.server;

import java.util.*;

public class NoiseGeneratorOctaves extends NoiseGenerator
{
    private NoiseGeneratorPerlin[] a;
    private int b;
    
    public NoiseGeneratorOctaves(final Random random, final int b) {
        this.b = b;
        this.a = new NoiseGeneratorPerlin[b];
        for (int i = 0; i < b; ++i) {
            this.a[i] = new NoiseGeneratorPerlin(random);
        }
    }
    
    public double[] a(double[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final double n7, final double n8, final double n9) {
        if (array == null) {
            array = new double[n4 * n5 * n6];
        }
        else {
            for (int i = 0; i < array.length; ++i) {
                array[i] = 0.0;
            }
        }
        double n10 = 1.0;
        for (int j = 0; j < this.b; ++j) {
            final double var0 = n * n10 * n7;
            final double n11 = n2 * n10 * n8;
            final double var2 = n3 * n10 * n9;
            final long d = MathHelper.d(var0);
            final long d2 = MathHelper.d(var2);
            this.a[j].a(array, var0 - d + d % 16777216L, n11, var2 - d2 + d2 % 16777216L, n4, n5, n6, n7 * n10, n8 * n10, n9 * n10, n10);
            n10 /= 2.0;
        }
        return array;
    }
    
    public double[] a(final double[] array, final int n, final int n2, final int n3, final int n4, final double n5, final double n6, final double n7) {
        return this.a(array, n, 10, n2, n3, 1, n4, n5, 1.0, n6);
    }
}
