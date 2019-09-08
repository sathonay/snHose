package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockLongGrass extends BlockPlant implements IBlockFragilePlantElement
{
    private static final String[] a;
    
    protected BlockLongGrass() {
        super(Material.REPLACEABLE_PLANT);
        final float n = 0.4f;
        this.a(0.5f - n, 0.0f, 0.5f - n, 0.5f + n, 0.8f, 0.5f + n);
    }
    
    @Override
    public boolean j(final World world, final int i, final int n, final int k) {
        return this.a(world.getType(i, n - 1, k));
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        if (random.nextInt(8) == 0) {
            return Items.SEEDS;
        }
        return null;
    }
    
    @Override
    public int getDropCount(final int n, final Random random) {
        return 1 + random.nextInt(n * 2 + 1);
    }
    
    @Override
    public void a(final World world, final EntityHuman entityhuman, final int n, final int n2, final int n3, final int n4) {
        if (!world.isStatic && entityhuman.bF() != null && entityhuman.bF().getItem() == Items.SHEARS) {
            entityhuman.a(StatisticList.MINE_BLOCK_COUNT[Block.getId(this)], 1);
            this.a(world, n, n2, n3, new ItemStack(Blocks.LONG_GRASS, 1, n4));
        }
        else {
            super.a(world, entityhuman, n, n2, n3, n4);
        }
    }
    
    @Override
    public int getDropData(final World world, final int i, final int j, final int k) {
        return world.getData(i, j, k);
    }
    
    @Override
    public boolean a(final World world, final int i, final int j, final int k, final boolean b) {
        return world.getData(i, j, k) != 0;
    }
    
    @Override
    public boolean a(final World world, final Random random, final int n, final int n2, final int n3) {
        return true;
    }
    
    @Override
    public void b(final World world, final Random random, final int i, final int j, final int k) {
        final int data = world.getData(i, j, k);
        int l = 2;
        if (data == 2) {
            l = 3;
        }
        if (Blocks.DOUBLE_PLANT.canPlace(world, i, j, k)) {
            Blocks.DOUBLE_PLANT.c(world, i, j, k, l, 2);
        }
    }
    
    static {
        a = new String[] { "deadbush", "tallgrass", "fern" };
    }
}
