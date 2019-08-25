package net.minecraft.server;

import java.util.Random;

public class MathHelper {
    private static float[] a = new float[65536];
    private static final int[] b;

    public static final float sin(float var0) {
        return a[(int)(var0 * 10430.378F) & '\uffff'];
    }

    public static final float cos(float var0) {
        return a[(int)(var0 * 10430.378F + 16384.0F) & '\uffff'];
    }

    public static final float c(float var0) {
        return (float)Math.sqrt((double)var0);
    }

    public static final float sqrt(double var0) {
        return (float)Math.sqrt(var0);
    }

    public static int d(float var0) {
        int var1 = (int)var0;
        return var0 < (float)var1 ? var1 - 1 : var1;
    }

    public static int floor(double var0) {
        int var2 = (int)var0;
        return var0 < (double)var2 ? var2 - 1 : var2;
    }

    public static long d(double var0) {
        long var2 = (long)var0;
        return var0 < (double)var2 ? var2 - 1L : var2;
    }

    public static float abs(float var0) {
        return var0 >= 0.0F ? var0 : -var0;
    }

    public static int a(int var0) {
        return var0 >= 0 ? var0 : -var0;
    }

    public static int f(float var0) {
        int var1 = (int)var0;
        return var0 > (float)var1 ? var1 + 1 : var1;
    }

    public static int f(double var0) {
        int var2 = (int)var0;
        return var0 > (double)var2 ? var2 + 1 : var2;
    }

    public static double b(double var0, double var2, double var4) {
        if (var4 < 0.0D) {
            return var0;
        }
        return var4 > 1.0D ? var2 : var0 + (var2 - var0) * var4;
    }

    public static double a(double var0, double var2) {
        if (var0 < 0.0D) {
            var0 = -var0;
        }

        if (var2 < 0.0D) {
            var2 = -var2;
        }

        return var0 > var2 ? var0 : var2;
    }

    public static int nextInt(Random var0, int var1, int var2) {
        return var1 >= var2 ? var1 : var0.nextInt(var2 - var1 + 1) + var1;
    }

    public static float a(Random var0, float var1, float var2) {
        return var1 >= var2 ? var1 : var0.nextFloat() * (var2 - var1) + var1;
    }

    public static double a(Random var0, double var1, double var3) {
        return var1 >= var3 ? var1 : var0.nextDouble() * (var3 - var1) + var1;
    }

    public static double a(long[] var0) {
        long var1 = 0L;
        long[] var3 = var0;
        int var4 = var0.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            long var6 = var3[var5];
            var1 += var6;
        }

        return (double)var1 / (double)var0.length;
    }

    public static float g(float var0) {
        var0 %= 360.0F;
        if (var0 >= 180.0F) {
            var0 -= 360.0F;
        }

        if (var0 < -180.0F) {
            var0 += 360.0F;
        }

        return var0;
    }

    public static double g(double var0) {
        var0 %= 360.0D;
        if (var0 >= 180.0D) {
            var0 -= 360.0D;
        }

        if (var0 < -180.0D) {
            var0 += 360.0D;
        }

        return var0;
    }

    public static int a(String var0, int var1) {
        int var2 = var1;

        try {
            var2 = Integer.parseInt(var0);
        } catch (Throwable var4) {}

        return var2;
    }

    public static int a(String var0, int var1, int var2) {
        int var3 = var1;

        try {
            var3 = Integer.parseInt(var0);
        } catch (Throwable var5) {}

        if (var3 < var2) {
            var3 = var2;
        }

        return var3;
    }

    public static double a(String var0, double var1) {
        double var3 = var1;

        try {
            var3 = Double.parseDouble(var0);
        } catch (Throwable var6) {}

        return var3;
    }

    public static double a(String var0, double var1, double var3) {
        double var5 = var1;

        try {
            var5 = Double.parseDouble(var0);
        } catch (Throwable var8) {}

        if (var5 < var3) {
            var5 = var3;
        }

        return var5;
    }

    public static double limit(double actual, double minimum, double maximum) {
        return Math.min(Math.max(actual, minimum), maximum);
    }

    public static int limit(int actual, int minimum, int maximum) {
        return Math.min(Math.max(actual, minimum), maximum);
    }

    public static float limit(float actual, float minimum, float maximum) {
        return Math.min(Math.max(actual, minimum), maximum);
    }

    public static byte limit(byte actual, byte minimum, byte maximum) {
        return (byte) Math.min(Math.max(actual, minimum), maximum);
    }

    static {
        for(int var0 = 0; var0 < 65536; ++var0) {
            a[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
        }

        b = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
    }
}

