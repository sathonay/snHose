package net.minecraft.server;

public class BlockBeacon extends BlockContainer
{
    public BlockBeacon() {
        super(Material.SHATTERABLE);
        this.c(3.0f);
        this.a(CreativeModeTab.f);
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityBeacon();
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityHuman, final int n, final float n2, final float n3, final float n4) {
        if (world.isStatic) {
            return true;
        }
        final TileEntityBeacon tileentitybeacon = (TileEntityBeacon)world.getTileEntity(i, j, k);
        if (tileentitybeacon != null) {
            entityHuman.openBeacon(tileentitybeacon);
        }
        return true;
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
        return 34;
    }
    
    @Override
    public void postPlace(final World world, final int n, final int n2, final int n3, final EntityLiving entityliving, final ItemStack itemstack) {
        super.postPlace(world, n, n2, n3, entityliving, itemstack);
        if (itemstack.hasName()) {
            ((TileEntityBeacon)world.getTileEntity(n, n2, n3)).a(itemstack.getName());
        }
    }
}
