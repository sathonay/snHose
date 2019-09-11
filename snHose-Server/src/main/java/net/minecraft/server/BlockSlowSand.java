package net.minecraft.server;

public class BlockSlowSand extends Block
{
    public BlockSlowSand() {
        super(Material.SAND);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return AxisAlignedBB.a(n, n2, n3, n + 1, n2 + 1 - 0.125f, n3 + 1);
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final Entity entity) {
        entity.motX *= 0.4;
        entity.motZ *= 0.4;
    }
}
