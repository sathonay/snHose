package net.minecraft.server.v1_7_R4;

public class Tuple
{
    private Object a;
    private Object b;
    
    public Tuple(final Object a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public Object a() {
        return this.a;
    }
    
    public Object b() {
        return this.b;
    }
}
