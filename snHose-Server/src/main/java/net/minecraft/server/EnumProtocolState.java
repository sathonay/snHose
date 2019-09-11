package net.minecraft.server;

enum EnumProtocolState
{
    HELLO("HELLO", 0), 
    KEY("KEY", 1), 
    AUTHENTICATING("AUTHENTICATING", 2), 
    READY_TO_ACCEPT("READY_TO_ACCEPT", 3), 
    e("ACCEPTED", 4);
    
    private EnumProtocolState(final String s, final int n) {
    }
}
