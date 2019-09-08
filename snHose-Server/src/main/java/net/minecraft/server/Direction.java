package net.minecraft.server;

public class Direction
{
    public static final int[] a;
    public static final int[] b;
    public static final String[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;
    public static final int[] h;
    public static final int[][] i;
    
    public static int a(final double n, final double n2) {
        if (MathHelper.abs((float)n) > MathHelper.abs((float)n2)) {
            if (n > 0.0) {
                return 1;
            }
            return 3;
        }
        if (n2 > 0.0) {
            return 2;
        }
        return 0;
    }
    
    static {
        a = new int[] { 0, -1, 0, 1 };
        b = new int[] { 1, 0, -1, 0 };
        c = new String[] { "SOUTH", "WEST", "NORTH", "EAST" };
        d = new int[] { 3, 4, 2, 5 };
        e = new int[] { -1, -1, 2, 0, 1, 3 };
        f = new int[] { 2, 3, 0, 1 };
        g = new int[] { 1, 2, 3, 0 };
        h = new int[] { 3, 0, 1, 2 };
        i = new int[][] { { 1, 0, 3, 2, 5, 4 }, { 1, 0, 5, 4, 2, 3 }, { 1, 0, 2, 3, 4, 5 }, { 1, 0, 4, 5, 3, 2 } };
    }
}
