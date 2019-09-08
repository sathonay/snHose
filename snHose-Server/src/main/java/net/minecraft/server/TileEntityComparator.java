package net.minecraft.server.v1_7_R4;

public class TileEntityComparator extends TileEntity
{
    private int a;
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("OutputSignal", this.a);
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.a = nbttagcompound.getInt("OutputSignal");
    }
    
    public int a() {
        return this.a;
    }
    
    public void a(final int a) {
        this.a = a;
    }
}
