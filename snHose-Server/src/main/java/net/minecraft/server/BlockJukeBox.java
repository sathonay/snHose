package net.minecraft.server.v1_7_R4;

public class BlockJukeBox extends BlockContainer
{
    protected BlockJukeBox() {
        super(Material.WOOD);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityHuman, final int n, final float n2, final float n3, final float n4) {
        if (world.getData(i, j, k) == 0) {
            return false;
        }
        this.dropRecord(world, i, j, k);
        return true;
    }
    
    public void b(final World world, final int n, final int n2, final int n3, final ItemStack itemStack) {
        if (world.isStatic) {
            return;
        }
        final TileEntityRecordPlayer tileEntityRecordPlayer = (TileEntityRecordPlayer)world.getTileEntity(n, n2, n3);
        if (tileEntityRecordPlayer == null) {
            return;
        }
        tileEntityRecordPlayer.setRecord(itemStack.cloneItemStack());
        world.setData(n, n2, n3, 1, 2);
    }
    
    public void dropRecord(final World world, final int n, final int n2, final int n3) {
        if (world.isStatic) {
            return;
        }
        final TileEntityRecordPlayer tileEntityRecordPlayer = (TileEntityRecordPlayer)world.getTileEntity(n, n2, n3);
        if (tileEntityRecordPlayer == null) {
            return;
        }
        final ItemStack record = tileEntityRecordPlayer.getRecord();
        if (record == null) {
            return;
        }
        world.triggerEffect(1005, n, n2, n3, 0);
        world.a((String)null, n, n2, n3);
        tileEntityRecordPlayer.setRecord(null);
        world.setData(n, n2, n3, 0, 2);
        final float n4 = 0.7f;
        final EntityItem entity = new EntityItem(world, n + (world.random.nextFloat() * n4 + (1.0f - n4) * 0.5), n2 + (world.random.nextFloat() * n4 + (1.0f - n4) * 0.2 + 0.6), n3 + (world.random.nextFloat() * n4 + (1.0f - n4) * 0.5), record.cloneItemStack());
        entity.pickupDelay = 10;
        world.addEntity(entity);
    }
    
    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int n4) {
        this.dropRecord(world, n, n2, n3);
        super.remove(world, n, n2, n3, block, n4);
    }
    
    @Override
    public void dropNaturally(final World world, final int i, final int j, final int k, final int l, final float f, final int n) {
        if (world.isStatic) {
            return;
        }
        super.dropNaturally(world, i, j, k, l, f, 0);
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityRecordPlayer();
    }
    
    @Override
    public boolean isComplexRedstone() {
        return true;
    }
    
    @Override
    public int g(final World world, final int i, final int j, final int k, final int n) {
        final ItemStack record = ((TileEntityRecordPlayer)world.getTileEntity(i, j, k)).getRecord();
        return (record == null) ? 0 : (Item.getId(record.getItem()) + 1 - Item.getId(Items.RECORD_1));
    }
}
