package net.minecraft.server;

public class SourceBlock implements ISourceBlock
{
    private final World a;
    private final int b;
    private final int c;
    private final int d;
    
    public SourceBlock(final World a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public World k() {
        return this.a;
    }
    
    @Override
    public double getX() {
        return this.b + 0.5;
    }
    
    @Override
    public double getY() {
        return this.c + 0.5;
    }
    
    @Override
    public double getZ() {
        return this.d + 0.5;
    }
    
    @Override
    public int getBlockX() {
        return this.b;
    }
    
    @Override
    public int getBlockY() {
        return this.c;
    }
    
    @Override
    public int getBlockZ() {
        return this.d;
    }
    
    @Override
    public int h() {
        return this.a.getData(this.b, this.c, this.d);
    }
    
    @Override
    public TileEntity getTileEntity() {
        return this.a.getTileEntity(this.b, this.c, this.d);
    }
}
