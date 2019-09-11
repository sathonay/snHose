package net.minecraft.server;

public abstract class BlockContainer extends Block implements IContainer
{
    protected BlockContainer(final Material material) {
        super(material);
        this.isTileEntity = true;
    }
    
    @Override
    public void onPlace(final World world, final int i, final int j, final int k) {
        super.onPlace(world, i, j, k);
    }
    
    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int l) {
        super.remove(world, n, n2, n3, block, l);
        world.p(n, n2, n3);
    }
    
    @Override
    public boolean a(final World world, final int n, final int n2, final int n3, final int n4, final int n5) {
        super.a(world, n, n2, n3, n4, n5);
        final TileEntity tileEntity = world.getTileEntity(n, n2, n3);
        return tileEntity != null && tileEntity.c(n4, n5);
    }
}
