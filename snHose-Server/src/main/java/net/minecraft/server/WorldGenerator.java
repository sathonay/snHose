package net.minecraft.server;

import java.util.*;

public abstract class WorldGenerator
{
    private final boolean a;
    
    public WorldGenerator() {
        this.a = false;
    }
    
    public WorldGenerator(final boolean a) {
        this.a = a;
    }
    
    public abstract boolean generate(final World p0, final Random p1, final int p2, final int p3, final int p4);
    
    public void a(final double n, final double n2, final double n3) {
    }
    
    protected void setType(final World world, final int n, final int n2, final int n3, final Block block) {
        this.setTypeAndData(world, n, n2, n3, block, 0);
    }
    
    protected void setTypeAndData(final World world, final int n, final int n2, final int n3, final Block block, final int n4) {
        if (this.a) {
            world.setTypeAndData(n, n2, n3, block, n4, 3);
        }
        else {
            world.setTypeAndData(n, n2, n3, block, n4, 2);
        }
    }
}
