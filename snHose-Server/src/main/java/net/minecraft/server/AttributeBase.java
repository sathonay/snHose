package net.minecraft.server.v1_7_R4;

public abstract class AttributeBase implements IAttribute
{
    private final String a;
    private final double b;
    private boolean c;
    
    protected AttributeBase(final String a, final double b) {
        this.a = a;
        this.b = b;
        if (a == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
    }
    
    @Override
    public String getName() {
        return this.a;
    }
    
    @Override
    public double b() {
        return this.b;
    }
    
    @Override
    public boolean c() {
        return this.c;
    }
    
    public AttributeBase a(final boolean c) {
        this.c = c;
        return this;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
}
