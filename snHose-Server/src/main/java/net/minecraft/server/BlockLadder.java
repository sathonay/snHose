package net.minecraft.server;

import java.util.*;

public class BlockLadder extends Block
{
    protected BlockLadder() {
        super(Material.ORIENTABLE);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int i, final int j, final int k) {
        this.updateShape(world, i, j, k);
        return super.a(world, i, j, k);
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        this.b(blockAccess.getData(n, n2, n3));
    }
    
    public void b(final int n) {
        final float n2 = 0.125f;
        if (n == 2) {
            this.a(0.0f, 0.0f, 1.0f - n2, 1.0f, 1.0f, 1.0f);
        }
        if (n == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, n2);
        }
        if (n == 4) {
            this.a(1.0f - n2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 5) {
            this.a(0.0f, 0.0f, 0.0f, n2, 1.0f, 1.0f);
        }
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
        return 8;
    }
    
    @Override
    public boolean canPlace(final World world, final int n, final int n2, final int n3) {
        return world.getType(n - 1, n2, n3).r() || world.getType(n + 1, n2, n3).r() || world.getType(n, n2, n3 - 1).r() || world.getType(n, n2, n3 + 1).r();
    }
    
    @Override
    public int getPlacedData(final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, final int n8) {
        int n9 = n8;
        if ((n9 == 0 || n4 == 2) && world.getType(n, n2, n3 + 1).r()) {
            n9 = 2;
        }
        if ((n9 == 0 || n4 == 3) && world.getType(n, n2, n3 - 1).r()) {
            n9 = 3;
        }
        if ((n9 == 0 || n4 == 4) && world.getType(n + 1, n2, n3).r()) {
            n9 = 4;
        }
        if ((n9 == 0 || n4 == 5) && world.getType(n - 1, n2, n3).r()) {
            n9 = 5;
        }
        return n9;
    }
    
    @Override
    public void doPhysics(final World world, final int n, final int n2, final int n3, final Block block) {
        final int data = world.getData(n, n2, n3);
        boolean b = false;
        if (data == 2 && world.getType(n, n2, n3 + 1).r()) {
            b = true;
        }
        if (data == 3 && world.getType(n, n2, n3 - 1).r()) {
            b = true;
        }
        if (data == 4 && world.getType(n + 1, n2, n3).r()) {
            b = true;
        }
        if (data == 5 && world.getType(n - 1, n2, n3).r()) {
            b = true;
        }
        if (!b) {
            this.b(world, n, n2, n3, data, 0);
            world.setAir(n, n2, n3);
        }
        super.doPhysics(world, n, n2, n3, block);
    }
    
    @Override
    public int a(final Random random) {
        return 1;
    }
}
