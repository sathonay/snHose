package net.minecraft.server;

public enum EnumSkyBlock
{
    SKY("Sky", 0, 15), 
    BLOCK("Block", 1, 0);
    
    public final int c;
    
    private EnumSkyBlock(final String s, final int n, final int c) {
        this.c = c;
    }
}
