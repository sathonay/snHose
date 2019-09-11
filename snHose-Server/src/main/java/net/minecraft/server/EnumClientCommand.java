package net.minecraft.server;

public enum EnumClientCommand
{
    PERFORM_RESPAWN("PERFORM_RESPAWN", 0, 0), 
    REQUEST_STATS("REQUEST_STATS", 1, 1), 
    OPEN_INVENTORY_ACHIEVEMENT("OPEN_INVENTORY_ACHIEVEMENT", 2, 2);
    
    private final int d;
    private static final EnumClientCommand[] e;
    
    private EnumClientCommand(final String s, final int n, final int d) {
        this.d = d;
    }
    
    static {
        e = new EnumClientCommand[values().length];
        for (final EnumClientCommand enumClientCommand : values()) {
            EnumClientCommand.e[enumClientCommand.d] = enumClientCommand;
        }
    }
}
