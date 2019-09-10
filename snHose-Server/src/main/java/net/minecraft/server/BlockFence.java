package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockFence extends Block
{
    private final String a;
    
    public BlockFence(final String a, final Material material) {
        super(material);
        this.a = a;
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final AxisAlignedBB axisAlignedBB, final List list, final Entity entity) {
        final boolean e = this.e(world, n, n2, n3 - 1);
        final boolean e2 = this.e(world, n, n2, n3 + 1);
        final boolean e3 = this.e(world, n - 1, n2, n3);
        final boolean e4 = this.e(world, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (e) {
            f3 = 0.0f;
        }
        if (e2) {
            f4 = 1.0f;
        }
        if (e || e2) {
            this.a(f, 0.0f, f3, f2, 1.5f, f4);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        float n4 = 0.375f;
        float n5 = 0.625f;
        if (e3) {
            f = 0.0f;
        }
        if (e4) {
            f2 = 1.0f;
        }
        if (e3 || e4 || (!e && !e2)) {
            this.a(f, 0.0f, n4, f2, 1.5f, n5);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        if (e) {
            n4 = 0.0f;
        }
        if (e2) {
            n5 = 1.0f;
        }
        this.a(f, 0.0f, n4, f2, 1.0f, n5);
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final boolean e = this.e(blockAccess, n, n2, n3 - 1);
        final boolean e2 = this.e(blockAccess, n, n2, n3 + 1);
        final boolean e3 = this.e(blockAccess, n - 1, n2, n3);
        final boolean e4 = this.e(blockAccess, n + 1, n2, n3);
        final float f = (!e3 ? 0.375f : 0.0f);
        final float f2 = (!e4 ? 0.625f : 1.0f);
        final float f3 = (!e ? 0.375f : 0.0f);
        final float f4 = (!e2 ? 0.625f : 1.0f);
        this.a(f, 0.0f, f3, f2, 1.0f, f4);
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
    public boolean b(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        return false;
    }
    
    @Override
    public int b() {
        return 11;
    }
    
    public boolean e(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final Block type = blockAccess.getType(n, n2, n3);
        return type == this || type == Blocks.FENCE_GATE || (type.material.k() && type.d() && type.material != Material.PUMPKIN);
    }
    
    public static boolean a(final Block block) {
        return block == Blocks.FENCE || block == Blocks.NETHER_FENCE;
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityhuman, final int n, final float n2, final float n3, final float n4) {
        return world.isStatic || ItemLeash.a(entityhuman, world, i, j, k);
    }
}
