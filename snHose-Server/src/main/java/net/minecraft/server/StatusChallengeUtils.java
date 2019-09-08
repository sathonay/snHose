package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.base.*;

public class StatusChallengeUtils
{
    public static char[] a;
    
    public static String a(final byte[] array, final int n, final int n2) {
        int n3;
        int n4;
        for (n3 = n2 - 1, n4 = ((n > n3) ? n3 : n); 0 != array[n4] && n4 < n3; ++n4) {}
        return new String(array, n, n4 - n, Charsets.UTF_8);
    }
    
    public static int b(final byte[] array, final int n) {
        return b(array, n, array.length);
    }
    
    public static int b(final byte[] array, final int n, final int n2) {
        if (0 > n2 - n - 4) {
            return 0;
        }
        return array[n + 3] << 24 | (array[n + 2] & 0xFF) << 16 | (array[n + 1] & 0xFF) << 8 | (array[n] & 0xFF);
    }
    
    public static int c(final byte[] array, final int n, final int n2) {
        if (0 > n2 - n - 4) {
            return 0;
        }
        return array[n] << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8 | (array[n + 3] & 0xFF);
    }
    
    public static String a(final byte b) {
        return "" + StatusChallengeUtils.a[(b & 0xF0) >>> 4] + StatusChallengeUtils.a[b & 0xF];
    }
    
    static {
        StatusChallengeUtils.a = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
}
