package net.minecraft.server;

public class Position implements IPosition
{
    protected final double a;
    protected final double b;
    protected final double c;
    
    public Position(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double getX() {
        return this.a;
    }
    
    @Override
    public double getY() {
        return this.b;
    }
    
    @Override
    public double getZ() {
        return this.c;
    }
}
