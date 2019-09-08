package net.minecraft.server.v1_7_R4;

public class RegistryBlocks extends RegistryMaterials
{
    private final String d;
    private Object e;
    
    public RegistryBlocks(final String d) {
        this.d = d;
    }
    
    @Override
    public void a(final int n, final String s, final Object e) {
        if (this.d.equals(s)) {
            this.e = e;
        }
        super.a(n, s, e);
    }
    
    @Override
    public Object get(final String s) {
        final Object value = super.get(s);
        return (value == null) ? this.e : value;
    }
    
    @Override
    public Object a(final int n) {
        final Object a = super.a(n);
        return (a == null) ? this.e : a;
    }
}
