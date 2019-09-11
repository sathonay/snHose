package net.minecraft.server;

import java.util.*;

public class BlockRedstoneComparator extends BlockDiodeAbstract implements IContainer
{
    public BlockRedstoneComparator(final boolean flag) {
        super(flag);
        this.isTileEntity = true;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.REDSTONE_COMPARATOR;
    }
    
    @Override
    protected int b(final int n) {
        return 2;
    }
    
    @Override
    protected BlockDiodeAbstract e() {
        return Blocks.REDSTONE_COMPARATOR_ON;
    }
    
    @Override
    protected BlockDiodeAbstract i() {
        return Blocks.REDSTONE_COMPARATOR_OFF;
    }
    
    @Override
    public int b() {
        return 37;
    }
    
    @Override
    protected boolean c(final int n) {
        return this.a || (n & 0x8) != 0x0;
    }
    
    @Override
    protected int f(final IBlockAccess blockAccess, final int n, final int n2, final int n3, final int n4) {
        return this.e(blockAccess, n, n2, n3).a();
    }
    
    private int j(final World iblockaccess, final int i, final int j, final int k, final int l) {
        if (!this.d(l)) {
            return this.h(iblockaccess, i, j, k, l);
        }
        return Math.max(this.h(iblockaccess, i, j, k, l) - this.h((IBlockAccess)iblockaccess, i, j, k, l), 0);
    }
    
    public boolean d(final int n) {
        return (n & 0x4) == 0x4;
    }
    
    @Override
    protected boolean a(final World iblockaccess, final int i, final int j, final int k, final int l) {
        final int h = this.h(iblockaccess, i, j, k, l);
        if (h >= 15) {
            return true;
        }
        if (h == 0) {
            return false;
        }
        final int h2 = this.h((IBlockAccess)iblockaccess, i, j, k, l);
        return h2 == 0 || h >= h2;
    }
    
    @Override
    protected int h(final World world, final int i, final int j, final int k, final int l) {
        int n = super.h(world, i, j, k, l);
        final int m = BlockDirectional.l(l);
        final int n2 = i + Direction.a[m];
        final int n3 = k + Direction.b[m];
        final Block type = world.getType(n2, j, n3);
        if (type.isComplexRedstone()) {
            n = type.g(world, n2, j, n3, Direction.f[m]);
        }
        else if (n < 15 && type.r()) {
            final int n4 = n2 + Direction.a[m];
            final int n5 = n3 + Direction.b[m];
            final Block type2 = world.getType(n4, j, n5);
            if (type2.isComplexRedstone()) {
                n = type2.g(world, n4, j, n5, Direction.f[m]);
            }
        }
        return n;
    }
    
    public TileEntityComparator e(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        return (TileEntityComparator)blockAccess.getTileEntity(n, n2, n3);
    }
    
    @Override
    public boolean interact(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman, final int n4, final float n5, final float n6, final float n7) {
        final int data = world.getData(n, n2, n3);
        final boolean b = this.a | (data & 0x8) != 0x0;
        final boolean b2 = !this.d(data);
        final int n8 = (b2 ? 4 : 0) | (b ? 8 : 0);
        world.makeSound(n + 0.5, n2 + 0.5, n3 + 0.5, "random.click", 0.3f, b2 ? 0.55f : 0.5f);
        world.setData(n, n2, n3, n8 | (data & 0x3), 2);
        this.c(world, n, n2, n3, world.random);
        return true;
    }
    
    @Override
    protected void b(final World world, final int i, final int j, final int k, final Block block) {
        if (!world.a(i, j, k, this)) {
            final int data = world.getData(i, j, k);
            if (this.j(world, i, j, k, data) != this.e((IBlockAccess)world, i, j, k).a() || this.c(data) != this.a(world, i, j, k, data)) {
                if (this.i(world, i, j, k, data)) {
                    world.a(i, j, k, this, this.b(0), -1);
                }
                else {
                    world.a(i, j, k, this, this.b(0), 0);
                }
            }
        }
    }
    
    private void c(final World world, final int n, final int n2, final int n3, final Random random) {
        final int data = world.getData(n, n2, n3);
        final int j = this.j(world, n, n2, n3, data);
        final int a = this.e((IBlockAccess)world, n, n2, n3).a();
        this.e((IBlockAccess)world, n, n2, n3).a(j);
        if (a != j || !this.d(data)) {
            final boolean a2 = this.a(world, n, n2, n3, data);
            final boolean b = this.a || (data & 0x8) != 0x0;
            if (b && !a2) {
                world.setData(n, n2, n3, data & 0xFFFFFFF7, 2);
            }
            else if (!b && a2) {
                world.setData(n, n2, n3, data | 0x8, 2);
            }
            this.e(world, n, n2, n3);
        }
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final Random random) {
        if (this.a) {
            world.setTypeAndData(n, n2, n3, this.i(), world.getData(n, n2, n3) | 0x8, 4);
        }
        this.c(world, n, n2, n3, random);
    }
    
    @Override
    public void onPlace(final World world, final int n, final int n2, final int n3) {
        super.onPlace(world, n, n2, n3);
        world.setTileEntity(n, n2, n3, this.a(world, 0));
    }
    
    @Override
    public void remove(final World world, final int i, final int j, final int k, final Block block, final int l) {
        super.remove(world, i, j, k, block, l);
        world.p(i, j, k);
        this.e(world, i, j, k);
    }
    
    @Override
    public boolean a(final World world, final int n, final int n2, final int n3, final int n4, final int n5) {
        super.a(world, n, n2, n3, n4, n5);
        final TileEntity tileEntity = world.getTileEntity(n, n2, n3);
        return tileEntity != null && tileEntity.c(n4, n5);
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityComparator();
    }
}
