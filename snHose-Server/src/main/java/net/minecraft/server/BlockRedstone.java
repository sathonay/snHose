package net.minecraft.server;

public class BlockRedstone extends BlockOreBlock
{
    public BlockRedstone(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
        this.a(CreativeModeTab.d);
    }
    
    @Override
    public boolean isPowerSource() {
        return true;
    }
    
    @Override
    public int b(final IBlockAccess blockAccess, final int n, final int n2, final int n3, final int n4) {
        return 15;
    }
}
