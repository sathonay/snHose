package net.minecraft.server;

import java.util.regex.*;
import java.util.*;

public enum EnumChatFormat
{
    BLACK("BLACK", 0, '0'), 
    DARK_BLUE("DARK_BLUE", 1, '1'), 
    DARK_GREEN("DARK_GREEN", 2, '2'), 
    DARK_AQUA("DARK_AQUA", 3, '3'), 
    DARK_RED("DARK_RED", 4, '4'), 
    DARK_PURPLE("DARK_PURPLE", 5, '5'), 
    GOLD("GOLD", 6, '6'), 
    GRAY("GRAY", 7, '7'), 
    DARK_GRAY("DARK_GRAY", 8, '8'), 
    BLUE("BLUE", 9, '9'), 
    GREEN("GREEN", 10, 'a'), 
    AQUA("AQUA", 11, 'b'), 
    RED("RED", 12, 'c'), 
    LIGHT_PURPLE("LIGHT_PURPLE", 13, 'd'), 
    YELLOW("YELLOW", 14, 'e'), 
    WHITE("WHITE", 15, 'f'), 
    RANDOM("OBFUSCATED", 16, 'k', true), 
    BOLD("BOLD", 17, 'l', true), 
    STRIKETHROUGH("STRIKETHROUGH", 18, 'm', true), 
    UNDERLINE("UNDERLINE", 19, 'n', true), 
    ITALIC("ITALIC", 20, 'o', true), 
    RESET("RESET", 21, 'r');
    
    private static final Map w;
    private static final Map x;
    private static final Pattern y;
    private final char z;
    private final boolean A;
    private final String B;
    
    private EnumChatFormat(final String s, final int n, final char c) {
        this(s, n, c, false);
    }
    
    private EnumChatFormat(final String s, final int n, final char z, final boolean a) {
        this.z = z;
        this.A = a;
        this.B = "�" + z;
    }
    
    public char getChar() {
        return this.z;
    }
    
    public boolean isFormat() {
        return this.A;
    }
    
    public boolean c() {
        return !this.A && this != EnumChatFormat.RESET;
    }
    
    public String d() {
        return this.name().toLowerCase();
    }
    
    @Override
    public String toString() {
        return this.B;
    }
    
    public static EnumChatFormat b(final String s) {
        if (s == null) {
            return null;
        }
        return EnumChatFormat.x.get(s.toLowerCase());
    }
    
    public static Collection a(final boolean b, final boolean b2) {
        final ArrayList<String> list = new ArrayList<String>();
        for (final EnumChatFormat enumChatFormat : values()) {
            if (!enumChatFormat.c() || b) {
                if (!enumChatFormat.isFormat() || b2) {
                    list.add(enumChatFormat.d());
                }
            }
        }
        return list;
    }
    
    static {
        w = new HashMap();
        x = new HashMap();
        y = Pattern.compile("(?i)" + String.valueOf('�') + "[0-9A-FK-OR]");
        for (final EnumChatFormat enumChatFormat : values()) {
            EnumChatFormat.w.put(enumChatFormat.getChar(), enumChatFormat);
            EnumChatFormat.x.put(enumChatFormat.d(), enumChatFormat);
        }
    }
}
