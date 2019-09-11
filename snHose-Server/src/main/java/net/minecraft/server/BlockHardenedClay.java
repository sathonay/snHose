package net.minecraft.server;

public class BlockHardenedClay extends Block
{
    public BlockHardenedClay() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return MaterialMapColor.q;
    }
}
