package net.minecraft.server;

import java.util.*;

public class BlockPistonMoving extends BlockContainer
{
    public BlockPistonMoving() {
        super(Material.PISTON);
        this.c(-1.0f);
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return null;
    }
    
    @Override
    public void onPlace(final World world, final int n, final int n2, final int n3) {
    }
    
    @Override
    public void remove(final World world, final int i, final int j, final int k, final Block block, final int n) {
        final TileEntity tileEntity = world.getTileEntity(i, j, k);
        if (tileEntity instanceof TileEntityPiston) {
            ((TileEntityPiston)tileEntity).f();
        }
        else {
            super.remove(world, i, j, k, block, n);
        }
    }
    
    @Override
    public boolean canPlace(final World world, final int n, final int n2, final int n3) {
        return false;
    }
    
    @Override
    public boolean canPlace(final World world, final int n, final int n2, final int n3, final int n4) {
        return false;
    }
    
    @Override
    public int b() {
        return -1;
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
    public boolean interact(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman, final int n4, final float n5, final float n6, final float n7) {
        if (!world.isStatic && world.getTileEntity(n, n2, n3) == null) {
            world.setAir(n, n2, n3);
            return true;
        }
        return false;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return null;
    }
    
    @Override
    public void dropNaturally(final World world, final int i, final int j, final int k, final int n, final float n2, final int n3) {
        if (world.isStatic) {
            return;
        }
        final TileEntityPiston e = this.e(world, i, j, k);
        if (e == null) {
            return;
        }
        e.a().b(world, i, j, k, e.p(), 0);
    }
    
    @Override
    public void doPhysics(final World world, final int i, final int j, final int k, final Block block) {
        if (!world.isStatic) {
            world.getTileEntity(i, j, k);
        }
    }
    
    public static TileEntity a(final Block block, final int i, final int j, final boolean flag, final boolean flag2) {
        return new TileEntityPiston(block, i, j, flag, flag2);
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        final TileEntityPiston e = this.e(world, n, n2, n3);
        if (e == null) {
            return null;
        }
        float a = e.a(0.0f);
        if (e.b()) {
            a = 1.0f - a;
        }
        return this.a(world, n, n2, n3, e.a(), a, e.c());
    }
    
    @Override
    public void updateShape(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        final TileEntityPiston e = this.e(iblockaccess, i, j, k);
        if (e != null) {
            final Block a = e.a();
            if (a == this || a.getMaterial() == Material.AIR) {
                return;
            }
            a.updateShape(iblockaccess, i, j, k);
            float a2 = e.a(0.0f);
            if (e.b()) {
                a2 = 1.0f - a2;
            }
            final int c = e.c();
            this.minX = a.x() - Facing.b[c] * a2;
            this.minY = a.z() - Facing.c[c] * a2;
            this.minZ = a.B() - Facing.d[c] * a2;
            this.maxX = a.y() - Facing.b[c] * a2;
            this.maxY = a.A() - Facing.c[c] * a2;
            this.maxZ = a.C() - Facing.d[c] * a2;
        }
    }
    
    public AxisAlignedBB a(final World world, final int i, final int j, final int k, final Block block, final float n, final int n2) {
        if (block == this || block.getMaterial() == Material.AIR) {
            return null;
        }
        final AxisAlignedBB a = block.a(world, i, j, k);
        if (a == null) {
            return null;
        }
        if (Facing.b[n2] < 0) {
            final AxisAlignedBB axisAlignedBB = a;
            axisAlignedBB.a -= Facing.b[n2] * n;
        }
        else {
            final AxisAlignedBB axisAlignedBB2 = a;
            axisAlignedBB2.d -= Facing.b[n2] * n;
        }
        if (Facing.c[n2] < 0) {
            final AxisAlignedBB axisAlignedBB3 = a;
            axisAlignedBB3.b -= Facing.c[n2] * n;
        }
        else {
            final AxisAlignedBB axisAlignedBB4 = a;
            axisAlignedBB4.e -= Facing.c[n2] * n;
        }
        if (Facing.d[n2] < 0) {
            final AxisAlignedBB axisAlignedBB5 = a;
            axisAlignedBB5.c -= Facing.d[n2] * n;
        }
        else {
            final AxisAlignedBB axisAlignedBB6 = a;
            axisAlignedBB6.f -= Facing.d[n2] * n;
        }
        return a;
    }
    
    private TileEntityPiston e(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final TileEntity tileEntity = blockAccess.getTileEntity(n, n2, n3);
        if (tileEntity instanceof TileEntityPiston) {
            return (TileEntityPiston)tileEntity;
        }
        return null;
    }
}
