package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockWaterLily extends BlockPlant
{
    protected BlockWaterLily() {
        final float n = 0.5f;
        this.a(0.5f - n, 0.0f, 0.5f - n, 0.5f + n, 0.015625f, 0.5f + n);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public int b() {
        return 23;
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final AxisAlignedBB axisalignedbb, final List list, final Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat)) {
            super.a(world, i, j, k, axisalignedbb, list, entity);
        }
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return AxisAlignedBB.a(n + this.minX, n2 + this.minY, n3 + this.minZ, n + this.maxX, n2 + this.maxY, n3 + this.maxZ);
    }
    
    @Override
    protected boolean a(final Block block) {
        return block == Blocks.STATIONARY_WATER;
    }
    
    @Override
    public boolean j(final World world, final int n, final int n2, final int n3) {
        return n2 >= 0 && n2 < 256 && world.getType(n, n2 - 1, n3).getMaterial() == Material.WATER && world.getData(n, n2 - 1, n3) == 0;
    }
}
