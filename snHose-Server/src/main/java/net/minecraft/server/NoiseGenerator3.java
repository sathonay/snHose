package net.minecraft.server.v1_7_R4;

import java.util.*;

public class NoiseGenerator3 extends NoiseGenerator
{
    private NoiseGenerator3Handler[] a;
    private int b;
    
    public NoiseGenerator3(final Random random, final int b) {
        this.b = b;
        this.a = new NoiseGenerator3Handler[b];
        for (int i = 0; i < b; ++i) {
            this.a[i] = new NoiseGenerator3Handler(random);
        }
    }
    
    public double a(final double n, final double n2) {
        double n3 = 0.0;
        double n4 = 1.0;
        for (int i = 0; i < this.b; ++i) {
            n3 += this.a[i].a(n * n4, n2 * n4) / n4;
            n4 /= 2.0;
        }
        return n3;
    }
    
    public double[] a(final double[] array, final double n, final double n2, final int n3, final int n4, final double n5, final double n6, final double n7) {
        return this.a(array, n, n2, n3, n4, n5, n6, n7, 0.5);
    }
    
    public double[] a(double[] array, final double n, final double n2, final int n3, final int n4, final double n5, final double n6, final double n7, final double n8) {
        if (array == null || array.length < n3 * n4) {
            array = new double[n3 * n4];
        }
        else {
            for (int i = 0; i < array.length; ++i) {
                array[i] = 0.0;
            }
        }
        double n9 = 1.0;
        double n10 = 1.0;
        for (int j = 0; j < this.b; ++j) {
            this.a[j].a(array, n, n2, n3, n4, n5 * n10 * n9, n6 * n10 * n9, 0.55 / n9);
            n10 *= n7;
            n9 *= n8;
        }
        return array;
    }
}
