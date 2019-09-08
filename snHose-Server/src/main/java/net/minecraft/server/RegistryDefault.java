package net.minecraft.server.v1_7_R4;

public class RegistryDefault extends RegistrySimple
{
    private final Object a;
    
    public RegistryDefault(final Object a) {
        this.a = a;
    }
    
    @Override
    public Object get(final Object o) {
        final Object value = super.get(o);
        return (value == null) ? this.a : value;
    }
}
