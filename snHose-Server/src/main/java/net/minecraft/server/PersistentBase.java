package net.minecraft.server.v1_7_R4;

public abstract class PersistentBase
{
    public final String id;
    private boolean a;
    
    public PersistentBase(final String id) {
        this.id = id;
    }
    
    public abstract void a(final NBTTagCompound p0);
    
    public abstract void b(final NBTTagCompound p0);
    
    public void c() {
        this.a(true);
    }
    
    public void a(final boolean a) {
        this.a = a;
    }
    
    public boolean d() {
        return this.a;
    }
}
