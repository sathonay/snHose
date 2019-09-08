package net.minecraft.server.v1_7_R4;

public class SharedConstants
{
    public static final char[] allowedCharacters;
    
    public static boolean isAllowedChatCharacter(final char c) {
        return c != '§' && c >= ' ' && c != '\u007f';
    }
    
    public static String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray()) {
            if (isAllowedChatCharacter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    static {
        allowedCharacters = new char[] { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
    }
}
