package net.minecraft.server;

public class BlockOreBlock extends Block
{
    private final MaterialMapColor a;
    
    public BlockOreBlock(final MaterialMapColor a) {
        super(Material.ORE);
        this.a = a;
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return this.a;
    }
}
