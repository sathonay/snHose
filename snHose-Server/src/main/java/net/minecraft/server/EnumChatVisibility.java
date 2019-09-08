package net.minecraft.server.v1_7_R4;

public enum EnumChatVisibility
{
    FULL("FULL", 0, 0, "options.chat.visibility.full"), 
    SYSTEM("SYSTEM", 1, 1, "options.chat.visibility.system"), 
    HIDDEN("HIDDEN", 2, 2, "options.chat.visibility.hidden");
    
    private static final EnumChatVisibility[] d;
    private final int e;
    private final String f;
    
    private EnumChatVisibility(final String s, final int n, final int e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public int a() {
        return this.e;
    }
    
    public static EnumChatVisibility a(final int n) {
        return EnumChatVisibility.d[n % EnumChatVisibility.d.length];
    }
    
    static {
        d = new EnumChatVisibility[values().length];
        for (final EnumChatVisibility enumChatVisibility : values()) {
            EnumChatVisibility.d[enumChatVisibility.e] = enumChatVisibility;
        }
    }
}
