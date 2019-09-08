package net.minecraft.server.v1_7_R4;

public enum EnumDifficulty
{
    PEACEFUL("PEACEFUL", 0, 0, "options.difficulty.peaceful"), 
    EASY("EASY", 1, 1, "options.difficulty.easy"), 
    NORMAL("NORMAL", 2, 2, "options.difficulty.normal"), 
    HARD("HARD", 3, 3, "options.difficulty.hard");
    
    private static final EnumDifficulty[] e;
    private final int f;
    private final String g;
    
    private EnumDifficulty(final String s, final int n, final int f, final String g) {
        this.f = f;
        this.g = g;
    }
    
    public int a() {
        return this.f;
    }
    
    public static EnumDifficulty getById(final int n) {
        return EnumDifficulty.e[n % EnumDifficulty.e.length];
    }
    
    public String b() {
        return this.g;
    }
    
    static {
        e = new EnumDifficulty[values().length];
        for (final EnumDifficulty enumDifficulty : values()) {
            EnumDifficulty.e[enumDifficulty.f] = enumDifficulty;
        }
    }
}
