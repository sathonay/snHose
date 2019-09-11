package net.minecraft.server;

import java.util.*;

public class BlockEnderChest extends BlockContainer
{
    protected BlockEnderChest() {
        super(Material.STONE);
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
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.OBSIDIAN);
    }
    
    @Override
    public int a(final Random random) {
        return 8;
    }
    
    @Override
    protected boolean E() {
        return true;
    }
    
    @Override
    public void postPlace(final World world, final int i, final int j, final int k, final EntityLiving entityLiving, final ItemStack itemStack) {
        int l = 0;
        final int n = MathHelper.floor(entityLiving.yaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (n == 0) {
            l = 2;
        }
        if (n == 1) {
            l = 5;
        }
        if (n == 2) {
            l = 3;
        }
        if (n == 3) {
            l = 4;
        }
        world.setData(i, j, k, l, 2);
    }
    
    @Override
    public boolean interact(final World world, final int n, final int j, final int n2, final EntityHuman entityHuman, final int n3, final float n4, final float n5, final float n6) {
        final InventoryEnderChest enderChest = entityHuman.getEnderChest();
        final TileEntityEnderChest tileentityenderchest = (TileEntityEnderChest)world.getTileEntity(n, j, n2);
        if (enderChest == null || tileentityenderchest == null) {
            return true;
        }
        if (world.getType(n, j + 1, n2).r()) {
            return true;
        }
        if (world.isStatic) {
            return true;
        }
        enderChest.a(tileentityenderchest);
        entityHuman.openContainer(enderChest);
        return true;
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityEnderChest();
    }
}
