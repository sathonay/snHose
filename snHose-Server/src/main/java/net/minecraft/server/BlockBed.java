package net.minecraft.server;

import java.util.*;

public class BlockBed extends BlockDirectional
{
    public static final int[][] a;
    
    public BlockBed() {
        super(Material.CLOTH);
        this.e();
    }
    
    @Override
    public boolean interact(final World world, int n, final int j, int n2, final EntityHuman entityHuman, final int n3, final float n4, final float n5, final float n6) {
        if (world.isStatic) {
            return true;
        }
        int n7 = world.getData(n, j, n2);
        if (!b(n7)) {
            final int l = BlockDirectional.l(n7);
            n += BlockBed.a[l][0];
            n2 += BlockBed.a[l][1];
            if (world.getType(n, j, n2) != this) {
                return true;
            }
            n7 = world.getData(n, j, n2);
        }
        if (!world.worldProvider.e() || world.getBiome(n, n2) == BiomeBase.HELL) {
            final double n8 = n + 0.5;
            final double n9 = j + 0.5;
            final double n10 = n2 + 0.5;
            world.setAir(n, j, n2);
            final int i = BlockDirectional.l(n7);
            n += BlockBed.a[i][0];
            n2 += BlockBed.a[i][1];
            if (world.getType(n, j, n2) == this) {
                world.setAir(n, j, n2);
                final double n11 = (n8 + n + 0.5) / 2.0;
                final double n12 = (n9 + j + 0.5) / 2.0;
                final double n13 = (n10 + n2 + 0.5) / 2.0;
            }
            world.createExplosion(null, n + 0.5f, j + 0.5f, n2 + 0.5f, 5.0f, true, true);
            return true;
        }
        if (c(n7)) {
            EntityPlayer entityPlayer = null;
            for (final EntityPlayer entityPlayer2 : world.players) {
                if (entityPlayer2.isSleeping()) {
                    final ChunkCoordinates bb = entityPlayer2.bB;
                    if (bb.x != n || bb.y != j || bb.z != n2) {
                        continue;
                    }
                    entityPlayer = entityPlayer2;
                }
            }
            if (entityPlayer != null) {
                entityHuman.b(new ChatMessage("tile.bed.occupied", new Object[0]));
                return true;
            }
            a(world, n, j, n2, false);
        }
        final EnumBedResult a = entityHuman.a(n, j, n2);
        if (a == EnumBedResult.OK) {
            a(world, n, j, n2, true);
            return true;
        }
        if (a == EnumBedResult.NOT_POSSIBLE_NOW) {
            entityHuman.b(new ChatMessage("tile.bed.noSleep", new Object[0]));
        }
        else if (a == EnumBedResult.NOT_SAFE) {
            entityHuman.b(new ChatMessage("tile.bed.notSafe", new Object[0]));
        }
        return true;
    }
    
    @Override
    public int b() {
        return 14;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        this.e();
    }
    
    @Override
    public void doPhysics(final World world, final int n, final int n2, final int n3, final Block block) {
        final int data = world.getData(n, n2, n3);
        final int l = BlockDirectional.l(data);
        if (b(data)) {
            if (world.getType(n - BlockBed.a[l][0], n2, n3 - BlockBed.a[l][1]) != this) {
                world.setAir(n, n2, n3);
            }
        }
        else if (world.getType(n + BlockBed.a[l][0], n2, n3 + BlockBed.a[l][1]) != this) {
            world.setAir(n, n2, n3);
            if (!world.isStatic) {
                this.b(world, n, n2, n3, data, 0);
            }
        }
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        if (b(n)) {
            return Item.getById(0);
        }
        return Items.BED;
    }
    
    private void e() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }
    
    public static boolean b(final int n) {
        return (n & 0x8) != 0x0;
    }
    
    public static boolean c(final int n) {
        return (n & 0x4) != 0x0;
    }
    
    public static void a(final World world, final int n, final int n2, final int n3, final boolean b) {
        final int data = world.getData(n, n2, n3);
        int l;
        if (b) {
            l = (data | 0x4);
        }
        else {
            l = (data & 0xFFFFFFFB);
        }
        world.setData(n, n2, n3, l, 4);
    }
    
    public static ChunkCoordinates a(final World iblockaccess, final int i, final int n, final int k, int n2) {
        final int l = BlockDirectional.l(iblockaccess.getData(i, n, k));
        for (int j = 0; j <= 1; ++j) {
            final int n3 = i - BlockBed.a[l][0] * j - 1;
            final int n4 = k - BlockBed.a[l][1] * j - 1;
            final int n5 = n3 + 2;
            final int n6 = n4 + 2;
            for (int m = n3; m <= n5; ++m) {
                for (int k2 = n4; k2 <= n6; ++k2) {
                    if (World.a(iblockaccess, m, n - 1, k2) && !iblockaccess.getType(m, n, k2).getMaterial().k() && !iblockaccess.getType(m, n + 1, k2).getMaterial().k()) {
                        if (n2 <= 0) {
                            return new ChunkCoordinates(m, n, k2);
                        }
                        --n2;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public void dropNaturally(final World world, final int i, final int j, final int k, final int l, final float f, final int n) {
        if (!b(l)) {
            super.dropNaturally(world, i, j, k, l, f, 0);
        }
    }
    
    @Override
    public int h() {
        return 1;
    }
    
    @Override
    public void a(final World world, int n, final int n2, int n3, final int n4, final EntityHuman entityHuman) {
        if (entityHuman.abilities.canInstantlyBuild && b(n4)) {
            final int l = BlockDirectional.l(n4);
            n -= BlockBed.a[l][0];
            n3 -= BlockBed.a[l][1];
            if (world.getType(n, n2, n3) == this) {
                world.setAir(n, n2, n3);
            }
        }
    }
    
    static {
        a = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
    }
}
