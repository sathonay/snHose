package net.minecraft.server.v1_7_R4;

public class Facing
{
    public static final int[] OPPOSITE_FACING;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final String[] e;
    
    static {
        OPPOSITE_FACING = new int[] { 1, 0, 3, 2, 5, 4 };
        b = new int[] { 0, 0, 0, 0, -1, 1 };
        c = new int[] { -1, 1, 0, 0, 0, 0 };
        d = new int[] { 0, 0, -1, 1, 0, 0 };
        e = new String[] { "DOWN", "UP", "NORTH", "SOUTH", "WEST", "EAST" };
    }
}
