package net.minecraft.server;

public class BlockCarpet extends Block
{
    protected BlockCarpet() {
        super(Material.WOOL);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        this.a(true);
        this.a(CreativeModeTab.c);
        this.b(0);
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return AxisAlignedBB.a(n + this.minX, n2 + this.minY, n3 + this.minZ, n + this.maxX, n2 + 0 * 0.0625f, n3 + this.maxZ);
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
    public void g() {
        this.b(0);
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        this.b(blockAccess.getData(n, n2, n3));
    }
    
    protected void b(final int n) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1 * (1 + 0) / 16.0f, 1.0f);
    }
    
    @Override
    public boolean canPlace(final World world, final int i, final int j, final int k) {
        return super.canPlace(world, i, j, k) && this.j(world, i, j, k);
    }
    
    @Override
    public void doPhysics(final World world, final int n, final int n2, final int n3, final Block block) {
        this.e(world, n, n2, n3);
    }
    
    private boolean e(final World world, final int i, final int j, final int k) {
        if (!this.j(world, i, j, k)) {
            this.b(world, i, j, k, world.getData(i, j, k), 0);
            world.setAir(i, j, k);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean j(final World world, final int i, final int n, final int k) {
        return !world.isEmpty(i, n - 1, k);
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
}
