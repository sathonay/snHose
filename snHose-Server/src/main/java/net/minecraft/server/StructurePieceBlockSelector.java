package net.minecraft.server.v1_7_R4;

import java.util.*;

public abstract class StructurePieceBlockSelector
{
    protected Block a;
    protected int b;
    
    protected StructurePieceBlockSelector() {
        this.a = Blocks.AIR;
    }
    
    public abstract void a(final Random p0, final int p1, final int p2, final int p3, final boolean p4);
    
    public Block a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
}
