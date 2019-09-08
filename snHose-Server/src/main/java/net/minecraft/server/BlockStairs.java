package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockStairs extends Block
{
    private static final int[][] a;
    private final Block b;
    private final int M;
    private boolean N;
    private int O;
    
    protected BlockStairs(final Block b, final int m) {
        super(b.material);
        this.b = b;
        this.M = m;
        this.c(b.strength);
        this.b(b.durability / 3.0f);
        this.a(b.stepSound);
        this.g(255);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        if (this.N) {
            this.a(0.5f * (this.O % 2), 0.5f * (this.O / 2 % 2), 0.5f * (this.O / 4 % 2), 0.5f + 0.5f * (this.O % 2), 0.5f + 0.5f * (this.O / 2 % 2), 0.5f + 0.5f * (this.O / 4 % 2));
        }
        else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
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
        return 10;
    }
    
    public void e(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        if ((blockAccess.getData(n, n2, n3) & 0x4) != 0x0) {
            this.a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }
    
    public static boolean a(final Block block) {
        return block instanceof BlockStairs;
    }
    
    private boolean f(final IBlockAccess blockAccess, final int n, final int n2, final int n3, final int n4) {
        return a(blockAccess.getType(n, n2, n3)) && blockAccess.getData(n, n2, n3) == n4;
    }
    
    public boolean f(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final int data = blockAccess.getData(n, n2, n3);
        final int n4 = data & 0x3;
        float f1 = 0.5f;
        float f2 = 1.0f;
        if ((data & 0x4) != 0x0) {
            f1 = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.5f;
        boolean b = true;
        if (n4 == 0) {
            f3 = 0.5f;
            f6 = 1.0f;
            final Block type = blockAccess.getType(n + 1, n2, n3);
            final int data2 = blockAccess.getData(n + 1, n2, n3);
            if (a(type) && (data & 0x4) == (data2 & 0x4)) {
                final int n5 = data2 & 0x3;
                if (n5 == 3 && !this.f(blockAccess, n, n2, n3 + 1, data)) {
                    f6 = 0.5f;
                    b = false;
                }
                else if (n5 == 2 && !this.f(blockAccess, n, n2, n3 - 1, data)) {
                    f5 = 0.5f;
                    b = false;
                }
            }
        }
        else if (n4 == 1) {
            f4 = 0.5f;
            f6 = 1.0f;
            final Block type2 = blockAccess.getType(n - 1, n2, n3);
            final int data3 = blockAccess.getData(n - 1, n2, n3);
            if (a(type2) && (data & 0x4) == (data3 & 0x4)) {
                final int n6 = data3 & 0x3;
                if (n6 == 3 && !this.f(blockAccess, n, n2, n3 + 1, data)) {
                    f6 = 0.5f;
                    b = false;
                }
                else if (n6 == 2 && !this.f(blockAccess, n, n2, n3 - 1, data)) {
                    f5 = 0.5f;
                    b = false;
                }
            }
        }
        else if (n4 == 2) {
            f5 = 0.5f;
            f6 = 1.0f;
            final Block type3 = blockAccess.getType(n, n2, n3 + 1);
            final int data4 = blockAccess.getData(n, n2, n3 + 1);
            if (a(type3) && (data & 0x4) == (data4 & 0x4)) {
                final int n7 = data4 & 0x3;
                if (n7 == 1 && !this.f(blockAccess, n + 1, n2, n3, data)) {
                    f4 = 0.5f;
                    b = false;
                }
                else if (n7 == 0 && !this.f(blockAccess, n - 1, n2, n3, data)) {
                    f3 = 0.5f;
                    b = false;
                }
            }
        }
        else if (n4 == 3) {
            final Block type4 = blockAccess.getType(n, n2, n3 - 1);
            final int data5 = blockAccess.getData(n, n2, n3 - 1);
            if (a(type4) && (data & 0x4) == (data5 & 0x4)) {
                final int n8 = data5 & 0x3;
                if (n8 == 1 && !this.f(blockAccess, n + 1, n2, n3, data)) {
                    f4 = 0.5f;
                    b = false;
                }
                else if (n8 == 0 && !this.f(blockAccess, n - 1, n2, n3, data)) {
                    f3 = 0.5f;
                    b = false;
                }
            }
        }
        this.a(f3, f1, f5, f4, f2, f6);
        return b;
    }
    
    public boolean g(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final int data = blockAccess.getData(n, n2, n3);
        final int n4 = data & 0x3;
        float f1 = 0.5f;
        float f2 = 1.0f;
        if ((data & 0x4) != 0x0) {
            f1 = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.5f;
        float f6 = 1.0f;
        boolean b = false;
        if (n4 == 0) {
            final Block type = blockAccess.getType(n - 1, n2, n3);
            final int data2 = blockAccess.getData(n - 1, n2, n3);
            if (a(type) && (data & 0x4) == (data2 & 0x4)) {
                final int n5 = data2 & 0x3;
                if (n5 == 3 && !this.f(blockAccess, n, n2, n3 - 1, data)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    b = true;
                }
                else if (n5 == 2 && !this.f(blockAccess, n, n2, n3 + 1, data)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    b = true;
                }
            }
        }
        else if (n4 == 1) {
            final Block type2 = blockAccess.getType(n + 1, n2, n3);
            final int data3 = blockAccess.getData(n + 1, n2, n3);
            if (a(type2) && (data & 0x4) == (data3 & 0x4)) {
                f3 = 0.5f;
                f4 = 1.0f;
                final int n6 = data3 & 0x3;
                if (n6 == 3 && !this.f(blockAccess, n, n2, n3 - 1, data)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    b = true;
                }
                else if (n6 == 2 && !this.f(blockAccess, n, n2, n3 + 1, data)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    b = true;
                }
            }
        }
        else if (n4 == 2) {
            final Block type3 = blockAccess.getType(n, n2, n3 - 1);
            final int data4 = blockAccess.getData(n, n2, n3 - 1);
            if (a(type3) && (data & 0x4) == (data4 & 0x4)) {
                f5 = 0.0f;
                f6 = 0.5f;
                final int n7 = data4 & 0x3;
                if (n7 == 1 && !this.f(blockAccess, n - 1, n2, n3, data)) {
                    b = true;
                }
                else if (n7 == 0 && !this.f(blockAccess, n + 1, n2, n3, data)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    b = true;
                }
            }
        }
        else if (n4 == 3) {
            final Block type4 = blockAccess.getType(n, n2, n3 + 1);
            final int data5 = blockAccess.getData(n, n2, n3 + 1);
            if (a(type4) && (data & 0x4) == (data5 & 0x4)) {
                final int n8 = data5 & 0x3;
                if (n8 == 1 && !this.f(blockAccess, n - 1, n2, n3, data)) {
                    b = true;
                }
                else if (n8 == 0 && !this.f(blockAccess, n + 1, n2, n3, data)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    b = true;
                }
            }
        }
        if (b) {
            this.a(f3, f1, f5, f4, f2, f6);
        }
        return b;
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final AxisAlignedBB axisalignedbb, final List list, final Entity entity) {
        this.e(world, i, j, k);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        final boolean f = this.f((IBlockAccess)world, i, j, k);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        if (f && this.g(world, i, j, k)) {
            super.a(world, i, j, k, axisalignedbb, list, entity);
        }
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public void attack(final World world, final int i, final int j, final int k, final EntityHuman entityhuman) {
        this.b.attack(world, i, j, k, entityhuman);
    }
    
    @Override
    public void postBreak(final World world, final int i, final int j, final int k, final int l) {
        this.b.postBreak(world, i, j, k, l);
    }
    
    @Override
    public float a(final Entity entity) {
        return this.b.a(entity);
    }
    
    @Override
    public int a(final World world) {
        return this.b.a(world);
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final Entity entity, final Vec3D vec3d) {
        this.b.a(world, i, j, k, entity, vec3d);
    }
    
    @Override
    public boolean v() {
        return this.b.v();
    }
    
    @Override
    public boolean a(final int i, final boolean flag) {
        return this.b.a(i, flag);
    }
    
    @Override
    public boolean canPlace(final World world, final int i, final int j, final int k) {
        return this.b.canPlace(world, i, j, k);
    }
    
    @Override
    public void onPlace(final World world, final int n, final int n2, final int n3) {
        this.doPhysics(world, n, n2, n3, Blocks.AIR);
        this.b.onPlace(world, n, n2, n3);
    }
    
    @Override
    public void remove(final World world, final int i, final int j, final int k, final Block block, final int l) {
        this.b.remove(world, i, j, k, block, l);
    }
    
    @Override
    public void b(final World world, final int i, final int j, final int k, final Entity entity) {
        this.b.b(world, i, j, k, entity);
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final Random random) {
        this.b.a(world, i, j, k, random);
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityhuman, final int n, final float n2, final float n3, final float n4) {
        return this.b.interact(world, i, j, k, entityhuman, 0, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void wasExploded(final World world, final int i, final int j, final int k, final Explosion explosion) {
        this.b.wasExploded(world, i, j, k, explosion);
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return this.b.f(this.M);
    }
    
    @Override
    public void postPlace(final World world, final int i, final int j, final int k, final EntityLiving entityLiving, final ItemStack itemStack) {
        final int n = MathHelper.floor(entityLiving.yaw * 4.0f / 360.0f + 0.5) & 0x3;
        final int n2 = world.getData(i, j, k) & 0x4;
        if (n == 0) {
            world.setData(i, j, k, 0x2 | n2, 2);
        }
        if (n == 1) {
            world.setData(i, j, k, 0x1 | n2, 2);
        }
        if (n == 2) {
            world.setData(i, j, k, 0x3 | n2, 2);
        }
        if (n == 3) {
            world.setData(i, j, k, 0x0 | n2, 2);
        }
    }
    
    @Override
    public int getPlacedData(final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, final int n8) {
        if (n4 == 0 || (n4 != 1 && n6 > 0.5)) {
            return n8 | 0x4;
        }
        return n8;
    }
    
    @Override
    public MovingObjectPosition a(final World world, final int n, final int n2, final int n3, final Vec3D vec3d, final Vec3D vec3d2) {
        final MovingObjectPosition[] array = new MovingObjectPosition[8];
        final int data = world.getData(n, n2, n3);
        final int[] array2 = BlockStairs.a[(data & 0x3) + (((data & 0x4) == 0x4) ? 4 : 0)];
        this.N = true;
        for (int i = 0; i < 8; ++i) {
            this.O = i;
            final int[] array3 = array2;
            for (int length = array3.length, j = 0; j < length; ++j) {
                if (array3[j] == i) {}
            }
            array[i] = super.a(world, n, n2, n3, vec3d, vec3d2);
        }
        final int[] array4 = array2;
        for (int length2 = array4.length, k = 0; k < length2; ++k) {
            array[array4[k]] = null;
        }
        MovingObjectPosition movingObjectPosition = null;
        double n4 = 0.0;
        for (final MovingObjectPosition movingObjectPosition2 : array) {
            if (movingObjectPosition2 != null) {
                final double distanceSquared = movingObjectPosition2.pos.distanceSquared(vec3d2);
                if (distanceSquared > n4) {
                    movingObjectPosition = movingObjectPosition2;
                    n4 = distanceSquared;
                }
            }
        }
        return movingObjectPosition;
    }
    
    static {
        a = new int[][] { { 2, 6 }, { 3, 7 }, { 2, 3 }, { 6, 7 }, { 0, 4 }, { 1, 5 }, { 0, 1 }, { 4, 5 } };
    }
}
