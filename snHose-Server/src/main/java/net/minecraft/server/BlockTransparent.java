package net.minecraft.server;

public class BlockTransparent extends Block
{
    protected boolean P;
    
    protected BlockTransparent(final Material material, final boolean p2) {
        super(material);
        this.P = p2;
    }
    
    @Override
    public boolean c() {
        return false;
    }
}
