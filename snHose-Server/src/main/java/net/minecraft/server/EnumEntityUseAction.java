package net.minecraft.server;

public enum EnumEntityUseAction
{
    INTERACT("INTERACT", 0, 0), 
    ATTACK("ATTACK", 1, 1);
    
    private static final EnumEntityUseAction[] c;
    private final int d;
    
    private EnumEntityUseAction(final String s, final int n, final int d) {
        this.d = d;
    }
    
    static {
        c = new EnumEntityUseAction[values().length];
        for (final EnumEntityUseAction enumEntityUseAction : values()) {
            EnumEntityUseAction.c[enumEntityUseAction.d] = enumEntityUseAction;
        }
    }
}
