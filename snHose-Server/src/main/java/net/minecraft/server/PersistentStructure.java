package net.minecraft.server;

public class PersistentStructure extends PersistentBase
{
    private NBTTagCompound a;
    
    public PersistentStructure(final String s) {
        super(s);
        this.a = new NBTTagCompound();
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        this.a = nbtTagCompound.getCompound("Features");
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.set("Features", this.a);
    }
    
    public void a(final NBTTagCompound nbtTagCompound, final int n, final int n2) {
        this.a.set(b(n, n2), nbtTagCompound);
    }
    
    public static String b(final int n, final int n2) {
        return "[" + n + "," + n2 + "]";
    }
    
    public NBTTagCompound a() {
        return this.a;
    }
}
