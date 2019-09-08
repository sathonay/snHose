package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockFurnace extends BlockContainer
{
    private final Random a;
    private final boolean b;
    private static boolean M;
    
    protected BlockFurnace(final boolean b) {
        super(Material.STONE);
        this.a = new Random();
        this.b = b;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.FURNACE);
    }
    
    @Override
    public void onPlace(final World world, final int n, final int n2, final int n3) {
        super.onPlace(world, n, n2, n3);
        this.e(world, n, n2, n3);
    }
    
    private void e(final World world, final int i, final int j, final int k) {
        if (world.isStatic) {
            return;
        }
        final Block type = world.getType(i, j, k - 1);
        final Block type2 = world.getType(i, j, k + 1);
        final Block type3 = world.getType(i - 1, j, k);
        final Block type4 = world.getType(i + 1, j, k);
        int l = 3;
        if (type.j() && !type2.j()) {
            l = 3;
        }
        if (type2.j() && !type.j()) {
            l = 2;
        }
        if (type3.j() && !type4.j()) {
            l = 5;
        }
        if (type4.j() && !type3.j()) {
            l = 4;
        }
        world.setData(i, j, k, l, 2);
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityHuman, final int n, final float n2, final float n3, final float n4) {
        if (world.isStatic) {
            return true;
        }
        final TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.getTileEntity(i, j, k);
        if (tileentityfurnace != null) {
            entityHuman.openFurnace(tileentityfurnace);
        }
        return true;
    }
    
    public static void a(final boolean b, final World world, final int n, final int n2, final int n3) {
        final int data = world.getData(n, n2, n3);
        final TileEntity tileEntity = world.getTileEntity(n, n2, n3);
        BlockFurnace.M = true;
        if (b) {
            world.setTypeUpdate(n, n2, n3, Blocks.BURNING_FURNACE);
        }
        else {
            world.setTypeUpdate(n, n2, n3, Blocks.FURNACE);
        }
        BlockFurnace.M = false;
        world.setData(n, n2, n3, data, 2);
        if (tileEntity != null) {
            tileEntity.t();
            world.setTileEntity(n, n2, n3, tileEntity);
        }
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityFurnace();
    }
    
    @Override
    public void postPlace(final World world, final int i, final int j, final int k, final EntityLiving entityLiving, final ItemStack itemStack) {
        final int n = MathHelper.floor(entityLiving.yaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (n == 0) {
            world.setData(i, j, k, 2, 2);
        }
        if (n == 1) {
            world.setData(i, j, k, 5, 2);
        }
        if (n == 2) {
            world.setData(i, j, k, 3, 2);
        }
        if (n == 3) {
            world.setData(i, j, k, 4, 2);
        }
        if (itemStack.hasName()) {
            ((TileEntityFurnace)world.getTileEntity(i, j, k)).a(itemStack.getName());
        }
    }
    
    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int n4) {
        if (!BlockFurnace.M) {
            final TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)world.getTileEntity(n, n2, n3);
            if (tileEntityFurnace != null) {
                for (int i = 0; i < tileEntityFurnace.getSize(); ++i) {
                    final ItemStack item = tileEntityFurnace.getItem(i);
                    if (item != null) {
                        final float n5 = this.a.nextFloat() * 0.8f + 0.1f;
                        final float n6 = this.a.nextFloat() * 0.8f + 0.1f;
                        final float n7 = this.a.nextFloat() * 0.8f + 0.1f;
                        while (item.count > 0) {
                            int count = this.a.nextInt(21) + 10;
                            if (count > item.count) {
                                count = item.count;
                            }
                            final ItemStack itemStack = item;
                            itemStack.count -= count;
                            final EntityItem entity = new EntityItem(world, n + n5, n2 + n6, n3 + n7, new ItemStack(item.getItem(), count, item.getData()));
                            if (item.hasTag()) {
                                entity.getItemStack().setTag((NBTTagCompound)item.getTag().clone());
                            }
                            final float n8 = 0.05f;
                            entity.motX = (float)this.a.nextGaussian() * n8;
                            entity.motY = (float)this.a.nextGaussian() * n8 + 0.2f;
                            entity.motZ = (float)this.a.nextGaussian() * n8;
                            world.addEntity(entity);
                        }
                    }
                }
                world.updateAdjacentComparators(n, n2, n3, block);
            }
        }
        super.remove(world, n, n2, n3, block, n4);
    }
    
    @Override
    public boolean isComplexRedstone() {
        return true;
    }
    
    @Override
    public int g(final World world, final int i, final int j, final int k, final int n) {
        return Container.b((IInventory)world.getTileEntity(i, j, k));
    }
}
