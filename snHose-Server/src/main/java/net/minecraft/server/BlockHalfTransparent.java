package net.minecraft.server;

public class BlockHalfTransparent extends Block
{
    private boolean a;
    private String b;
    
    protected BlockHalfTransparent(final String b, final Material material, final boolean a) {
        super(material);
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean c() {
        return false;
    }
}
