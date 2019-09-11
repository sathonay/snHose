package net.minecraft.server;

import java.util.*;

public abstract class WorldGenTreeAbstract extends WorldGenerator
{
    public WorldGenTreeAbstract(final boolean b) {
        super(b);
    }
    
    protected boolean a(final Block block) {
        return block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES || block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.LOG || block == Blocks.LOG2 || block == Blocks.SAPLING || block == Blocks.VINE;
    }
    
    public void b(final World world, final Random random, final int n, final int n2, final int n3) {
    }
}
