package net.minecraft.server;

import java.util.*;

public class BlockRepeater extends BlockDiodeAbstract
{
    public static final double[] b;
    private static final int[] M;
    
    protected BlockRepeater(final boolean flag) {
        super(flag);
    }
    
    @Override
    public boolean interact(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman, final int n4, final float n5, final float n6, final float n7) {
        final int data = world.getData(n, n2, n3);
        world.setData(n, n2, n3, (((data & 0xC) >> 2) + 1 << 2 & 0xC) | (data & 0x3), 3);
        return true;
    }
    
    @Override
    protected int b(final int n) {
        return BlockRepeater.M[(n & 0xC) >> 2] * 2;
    }
    
    @Override
    protected BlockDiodeAbstract e() {
        return Blocks.DIODE_ON;
    }
    
    @Override
    protected BlockDiodeAbstract i() {
        return Blocks.DIODE_OFF;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.DIODE;
    }
    
    @Override
    public int b() {
        return 15;
    }
    
    @Override
    public boolean g(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        return this.h(iblockaccess, i, j, k, l) > 0;
    }
    
    @Override
    protected boolean a(final Block block) {
        return BlockDiodeAbstract.d(block);
    }
    
    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int l) {
        super.remove(world, n, n2, n3, block, l);
        this.e(world, n, n2, n3);
    }
    
    static {
        b = new double[] { -0.0625, 0.0625, 0.1875, 0.3125 };
        M = new int[] { 1, 2, 3, 4 };
    }
}
