package net.minecraft.server;

import java.util.*;

public class BlockDeadBush extends BlockPlant
{
    protected BlockDeadBush() {
        super(Material.REPLACEABLE_PLANT);
        final float n = 0.4f;
        this.a(0.5f - n, 0.0f, 0.5f - n, 0.5f + n, 0.8f, 0.5f + n);
    }
    
    @Override
    protected boolean a(final Block block) {
        return block == Blocks.SAND || block == Blocks.HARDENED_CLAY || block == Blocks.STAINED_HARDENED_CLAY || block == Blocks.DIRT;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return null;
    }
    
    @Override
    public void a(final World world, final EntityHuman entityhuman, final int n, final int n2, final int n3, final int n4) {
        if (!world.isStatic && entityhuman.bF() != null && entityhuman.bF().getItem() == Items.SHEARS) {
            entityhuman.a(StatisticList.MINE_BLOCK_COUNT[Block.getId(this)], 1);
            this.a(world, n, n2, n3, new ItemStack(Blocks.DEAD_BUSH, 1, n4));
        }
        else {
            super.a(world, entityhuman, n, n2, n3, n4);
        }
    }
}
