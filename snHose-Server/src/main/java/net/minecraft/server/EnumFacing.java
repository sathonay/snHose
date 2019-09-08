package net.minecraft.server.v1_7_R4;

public enum EnumFacing
{
    DOWN("DOWN", 0, 0, 1, 0, -1, 0), 
    UP("UP", 1, 1, 0, 0, 1, 0), 
    NORTH("NORTH", 2, 2, 3, 0, 0, -1), 
    SOUTH("SOUTH", 3, 3, 2, 0, 0, 1), 
    EAST("EAST", 4, 4, 5, -1, 0, 0), 
    WEST("WEST", 5, 5, 4, 1, 0, 0);
    
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private static final EnumFacing[] l;
    
    private EnumFacing(final String s, final int n, final int g, final int h, final int i, final int j, final int k) {
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
    }
    
    public int getAdjacentX() {
        return this.i;
    }
    
    public int getAdjacentY() {
        return this.j;
    }
    
    public int getAdjacentZ() {
        return this.k;
    }
    
    public static EnumFacing a(final int n) {
        return EnumFacing.l[n % EnumFacing.l.length];
    }
    
    static {
        l = new EnumFacing[6];
        for (final EnumFacing enumFacing : values()) {
            EnumFacing.l[enumFacing.g] = enumFacing;
        }
    }
}
