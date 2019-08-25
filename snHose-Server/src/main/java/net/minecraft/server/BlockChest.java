package net.minecraft.server;

import java.util.*;

public class BlockChest extends BlockContainer
{
    private final Random b;
    public final int a;

    protected BlockChest(final int a) {
        super(Material.WOOD);
        this.b = new Random();
        this.a = a;
        this.a(CreativeModeTab.c);
        this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
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
        return 22;
    }

    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        if (blockAccess.getType(n, n2, n3 - 1) == this) {
            this.a(0.0625f, 0.0f, 0.0f, 0.9375f, 0.875f, 0.9375f);
        }
        else if (blockAccess.getType(n, n2, n3 + 1) == this) {
            this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 1.0f);
        }
        else if (blockAccess.getType(n - 1, n2, n3) == this) {
            this.a(0.0f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
        else if (blockAccess.getType(n + 1, n2, n3) == this) {
            this.a(0.0625f, 0.0f, 0.0625f, 1.0f, 0.875f, 0.9375f);
        }
        else {
            this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
    }

    @Override
    public void onPlace(final World world, final int n, final int n2, final int n3) {
        super.onPlace(world, n, n2, n3);
        this.e(world, n, n2, n3);
        final Block type = world.getType(n, n2, n3 - 1);
        final Block type2 = world.getType(n, n2, n3 + 1);
        final Block type3 = world.getType(n - 1, n2, n3);
        final Block type4 = world.getType(n + 1, n2, n3);
        if (type == this) {
            this.e(world, n, n2, n3 - 1);
        }
        if (type2 == this) {
            this.e(world, n, n2, n3 + 1);
        }
        if (type3 == this) {
            this.e(world, n - 1, n2, n3);
        }
        if (type4 == this) {
            this.e(world, n + 1, n2, n3);
        }
    }

    @Override
    public void postPlace(final World world, final int n, final int n2, final int n3, final EntityLiving entityLiving, final ItemStack itemStack) {
        final Block type = world.getType(n, n2, n3 - 1);
        final Block type2 = world.getType(n, n2, n3 + 1);
        final Block type3 = world.getType(n - 1, n2, n3);
        final Block type4 = world.getType(n + 1, n2, n3);
        int l = 0;
        final int n4 = MathHelper.floor(entityLiving.yaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (n4 == 0) {
            l = 2;
        }
        if (n4 == 1) {
            l = 5;
        }
        if (n4 == 2) {
            l = 3;
        }
        if (n4 == 3) {
            l = 4;
        }
        if (type != this && type2 != this && type3 != this && type4 != this) {
            world.setData(n, n2, n3, l, 3);
        }
        else {
            if ((type == this || type2 == this) && (l == 4 || l == 5)) {
                if (type == this) {
                    world.setData(n, n2, n3 - 1, l, 3);
                }
                else {
                    world.setData(n, n2, n3 + 1, l, 3);
                }
                world.setData(n, n2, n3, l, 3);
            }
            if ((type3 == this || type4 == this) && (l == 2 || l == 3)) {
                if (type3 == this) {
                    world.setData(n - 1, n2, n3, l, 3);
                }
                else {
                    world.setData(n + 1, n2, n3, l, 3);
                }
                world.setData(n, n2, n3, l, 3);
            }
        }
        if (itemStack.hasName()) {
            ((TileEntityChest)world.getTileEntity(n, n2, n3)).a(itemStack.getName());
        }
    }

    public void e(final World world, final int i, final int j, final int k) {
        if (world.isStatic) {
            return;
        }
        final Block type = world.getType(i, j, k - 1);
        final Block type2 = world.getType(i, j, k + 1);
        final Block type3 = world.getType(i - 1, j, k);
        final Block type4 = world.getType(i + 1, j, k);
        int l;
        if (type == this || type2 == this) {
            final Block type5 = world.getType(i - 1, j, (type == this) ? (k - 1) : (k + 1));
            final Block type6 = world.getType(i + 1, j, (type == this) ? (k - 1) : (k + 1));
            l = 5;
            int n = (type == this ? world.getData(i, j, k - 1) : world.getData(i, j, k + 1));
            if (n == 4) {
                l = 4;
            }
            if ((type3.j() || type5.j()) && !type4.j() && !type6.j()) {
                l = 5;
            }
            if ((type4.j() || type6.j()) && !type3.j() && !type5.j()) {
                l = 4;
            }
        }
        else if (type3 == this || type4 == this) {
            final Block type7 = world.getType((type3 == this) ? (i - 1) : (i + 1), j, k - 1);
            final Block type8 = world.getType((type3 == this) ? (i - 1) : (i + 1), j, k + 1);
            l = 3;
            int n2 = (type3 == this ? world.getData(i - 1, j, k) : world.getData(i + 1, j, k));
            if (n2 == 2) {
                l = 2;
            }
            if ((type.j() || type7.j()) && !type2.j() && !type8.j()) {
                l = 3;
            }
            if ((type2.j() || type8.j()) && !type.j() && !type7.j()) {
                l = 2;
            }
        }
        else {
            l = 3;
            /*
            l is already at 3 dude :/
            if (type.j() && !type2.j()) {
                l = 3;
            }
            */
            if (type2.j() && !type.j()) {
                l = 2;
            }
            if (type3.j() && !type4.j()) {
                l = 5;
            }
            if (type4.j() && !type3.j()) {
                l = 4;
            }
        }
        world.setData(i, j, k, l, 3);
    }

    @Override
    public boolean canPlace(final World world, final int n, final int n2, final int n3) {
        int n4 = 0;
        if (world.getType(n - 1, n2, n3) == this) {
            ++n4;
        }
        if (world.getType(n + 1, n2, n3) == this) {
            ++n4;
        }
        if (world.getType(n, n2, n3 - 1) == this) {
            ++n4;
        }
        if (world.getType(n, n2, n3 + 1) == this) {
            ++n4;
        }
        return n4 <= 1 && !this.n(world, n - 1, n2, n3) && !this.n(world, n + 1, n2, n3) && !this.n(world, n, n2, n3 - 1) && !this.n(world, n, n2, n3 + 1);
    }

    private boolean n(final World world, final int i, final int j, final int k) {
        return world.getType(i, j, k) == this && (world.getType(i - 1, j, k) == this || world.getType(i + 1, j, k) == this || world.getType(i, j, k - 1) == this || world.getType(i, j, k + 1) == this);
    }

    @Override
    public void doPhysics(final World world, final int n, final int n2, final int n3, final Block block) {
        super.doPhysics(world, n, n2, n3, block);
        final TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(n, n2, n3);
        if (tileEntityChest != null) {
            tileEntityChest.u();
        }
    }

    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int n4) {
        final TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(n, n2, n3);
        if (tileEntityChest != null) {
            for (int i = 0; i < tileEntityChest.getSize(); ++i) {
                final ItemStack item = tileEntityChest.getItem(i);
                if (item != null) {
                    final float n5 = this.b.nextFloat() * 0.8f + 0.1f;
                    final float n6 = this.b.nextFloat() * 0.8f + 0.1f;
                    final float n7 = this.b.nextFloat() * 0.8f + 0.1f;
                    while (item.count > 0) {
                        int count = Math.min(this.b.nextInt(21) + 10, item.count);
                        final ItemStack itemStack = item;
                        itemStack.count -= count;
                        final EntityItem entity = new EntityItem(world, n + n5, n2 + n6, n3 + n7, new ItemStack(item.getItem(), count, item.getData()));
                        final float n8 = 0.05f;
                        entity.motX = (float)this.b.nextGaussian() * n8;
                        entity.motY = (float)this.b.nextGaussian() * n8 + 0.2f;
                        entity.motZ = (float)this.b.nextGaussian() * n8;
                        if (item.hasTag()) {
                            entity.getItemStack().setTag((NBTTagCompound)item.getTag().clone());
                        }
                        world.addEntity(entity);
                    }
                }
            }
            world.updateAdjacentComparators(n, n2, n3, block);
        }
        super.remove(world, n, n2, n3, block, n4);
    }

    @Override
    public boolean interact(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman, final int n4, final float n5, final float n6, final float n7) {
        if (world.isStatic) {
            return true;
        }
        final IInventory m = this.m(world, n, n2, n3);
        if (m != null) {
            entityHuman.openContainer(m);
        }
        return true;
    }

    public IInventory m(final World world, final int n, final int j, final int n2) {
        IInventory inventory = (TileEntityChest)world.getTileEntity(n, j, n2);
        if (inventory == null) {
            return null;
        }
        if (world.getType(n, j + 1, n2).r()) {
            return null;
        }
        if (o(world, n, j, n2)) {
            return null;
        }
        if (world.getType(n - 1, j, n2) == this && (world.getType(n - 1, j + 1, n2).r() || o(world, n - 1, j, n2))) {
            return null;
        }
        if (world.getType(n + 1, j, n2) == this && (world.getType(n + 1, j + 1, n2).r() || o(world, n + 1, j, n2))) {
            return null;
        }
        if (world.getType(n, j, n2 - 1) == this && (world.getType(n, j + 1, n2 - 1).r() || o(world, n, j, n2 - 1))) {
            return null;
        }
        if (world.getType(n, j, n2 + 1) == this && (world.getType(n, j + 1, n2 + 1).r() || o(world, n, j, n2 + 1))) {
            return null;
        }
        if (world.getType(n - 1, j, n2) == this) {
            inventory = new InventoryLargeChest("container.chestDouble", (IInventory)world.getTileEntity(n - 1, j, n2), inventory);
        }
        if (world.getType(n + 1, j, n2) == this) {
            inventory = new InventoryLargeChest("container.chestDouble", inventory, (IInventory)world.getTileEntity(n + 1, j, n2));
        }
        if (world.getType(n, j, n2 - 1) == this) {
            inventory = new InventoryLargeChest("container.chestDouble", (IInventory)world.getTileEntity(n, j, n2 - 1), inventory);
        }
        if (world.getType(n, j, n2 + 1) == this) {
            inventory = new InventoryLargeChest("container.chestDouble", inventory, (IInventory)world.getTileEntity(n, j, n2 + 1));
        }
        return inventory;
    }

    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityChest();
    }

    @Override
    public boolean isPowerSource() {
        return this.a == 1;
    }

    @Override
    public int b(final IBlockAccess blockAccess, final int n, final int n2, final int n3, final int n4) {
        if (!this.isPowerSource()) {
            return 0;
        }
        return MathHelper.limit(((TileEntityChest)blockAccess.getTileEntity(n, n2, n3)).o, 0, 15);
    }

    @Override
    public int c(final IBlockAccess blockAccess, final int n, final int n2, final int n3, final int n4) {
        if (n4 == 1) {
            return this.b(blockAccess, n, n2, n3, n4);
        }
        return 0;
    }

    private static boolean o(final World world, final int n, final int n2, final int n3) {
        final Iterator<Entity> iterator = world.a(EntityOcelot.class, AxisAlignedBB.a(n, n2 + 1, n3, n + 1, n2 + 2, n3 + 1)).iterator();
        while (iterator.hasNext()) {
            if (((EntityOcelot)iterator.next()).isSitting()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isComplexRedstone() {
        return true;
    }

    @Override
    public int g(final World world, final int n, final int n2, final int n3, final int n4) {
        return Container.b(this.m(world, n, n2, n3));
    }
}
