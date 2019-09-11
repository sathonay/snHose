package net.minecraft.server;

import java.util.*;

public class BlockPlant extends Block
{
    protected BlockPlant(final Material material) {
        super(material);
        this.a(true);
        final float n = 0.2f;
        this.a(0.5f - n, 0.0f, 0.5f - n, 0.5f + n, n * 3.0f, 0.5f + n);
        this.a(CreativeModeTab.c);
    }
    
    protected BlockPlant() {
        this(Material.PLANT);
    }
    
    @Override
    public boolean canPlace(final World world, final int n, final int j, final int n2) {
        return super.canPlace(world, n, j, n2) && this.a(world.getType(n, j - 1, n2));
    }
    
    protected boolean a(final Block block) {
        return block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.SOIL;
    }
    
    @Override
    public void doPhysics(final World world, final int i, final int j, final int k, final Block block) {
        super.doPhysics(world, i, j, k, block);
        this.e(world, i, j, k);
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final Random random) {
        this.e(world, n, n2, n3);
    }
    
    protected void e(final World world, final int i, final int j, final int k) {
        if (!this.j(world, i, j, k)) {
            this.b(world, i, j, k, world.getData(i, j, k), 0);
            world.setTypeAndData(i, j, k, Block.getById(0), 0, 2);
        }
    }
    
    @Override
    public boolean j(final World world, final int i, final int n, final int k) {
        return this.a(world.getType(i, n - 1, k));
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return null;
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public int b() {
        return 1;
    }
}
