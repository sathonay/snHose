package net.minecraft.server.v1_7_R4;

public class BlockAir extends Block
{
    protected BlockAir() {
        super(Material.AIR);
    }
    
    @Override
    public int b() {
        return -1;
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return null;
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public boolean a(final int n, final boolean b) {
        return false;
    }
    
    @Override
    public void dropNaturally(final World world, final int n, final int n2, final int n3, final int n4, final float n5, final int n6) {
    }
}
