package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockEnderPortalFrame extends Block
{
    public BlockEnderPortalFrame() {
        super(Material.STONE);
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public int b() {
        return 26;
    }
    
    @Override
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final AxisAlignedBB axisAlignedBB, final List list, final Entity entity) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
        super.a(world, i, j, k, axisAlignedBB, list, entity);
        if (b(world.getData(i, j, k))) {
            this.a(0.3125f, 0.8125f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
            super.a(world, i, j, k, axisAlignedBB, list, entity);
        }
        this.g();
    }
    
    public static boolean b(final int n) {
        return (n & 0x4) != 0x0;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return null;
    }
    
    @Override
    public void postPlace(final World world, final int i, final int j, final int k, final EntityLiving entityLiving, final ItemStack itemStack) {
        world.setData(i, j, k, ((MathHelper.floor(entityLiving.yaw * 4.0f / 360.0f + 0.5) & 0x3) + 2) % 4, 2);
    }
    
    @Override
    public boolean isComplexRedstone() {
        return true;
    }
    
    @Override
    public int g(final World world, final int i, final int j, final int k, final int n) {
        if (b(world.getData(i, j, k))) {
            return 15;
        }
        return 0;
    }
}
