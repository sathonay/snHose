package net.minecraft.server;

public enum EnumMovingObjectType
{
    MISS("MISS", 0), 
    BLOCK("BLOCK", 1), 
    ENTITY("ENTITY", 2);
    
    private EnumMovingObjectType(final String s, final int n) {
    }
}
