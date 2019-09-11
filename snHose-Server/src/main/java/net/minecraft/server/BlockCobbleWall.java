package net.minecraft.server;

public class BlockCobbleWall extends Block
{
    public static final String[] a;
    
    public BlockCobbleWall(final Block block) {
        super(block.material);
        this.c(block.strength);
        this.b(block.durability / 3.0f);
        this.a(block.stepSound);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int b() {
        return 32;
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
    public boolean c() {
        return false;
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final boolean e = this.e(blockAccess, n, n2, n3 - 1);
        final boolean e2 = this.e(blockAccess, n, n2, n3 + 1);
        final boolean e3 = this.e(blockAccess, n - 1, n2, n3);
        final boolean e4 = this.e(blockAccess, n + 1, n2, n3);
        float f = 0.25f;
        float f2 = 0.75f;
        float f3 = 0.25f;
        float f4 = 0.75f;
        float f5 = 1.0f;
        if (e) {
            f3 = 0.0f;
        }
        if (e2) {
            f4 = 1.0f;
        }
        if (e3) {
            f = 0.0f;
        }
        if (e4) {
            f2 = 1.0f;
        }
        if (e && e2 && !e3 && !e4) {
            f5 = 0.8125f;
            f = 0.3125f;
            f2 = 0.6875f;
        }
        else if (!e && !e2 && e3 && e4) {
            f5 = 0.8125f;
            f3 = 0.3125f;
            f4 = 0.6875f;
        }
        this.a(f, 0.0f, f3, f2, f5, f4);
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int i, final int j, final int k) {
        this.updateShape(world, i, j, k);
        this.maxY = 1.5;
        return super.a(world, i, j, k);
    }
    
    public boolean e(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final Block type = blockAccess.getType(n, n2, n3);
        return type == this || type == Blocks.FENCE_GATE || (type.material.k() && type.d() && type.material != Material.PUMPKIN);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    static {
        a = new String[] { "normal", "mossy" };
    }
}
