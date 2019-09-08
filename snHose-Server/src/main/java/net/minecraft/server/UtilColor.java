package net.minecraft.server.v1_7_R4;

import java.util.regex.*;

public class UtilColor
{
    private static final Pattern a;
    
    public static boolean b(final String s) {
        return s == null || "".equals(s);
    }
    
    static {
        a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    }
}
