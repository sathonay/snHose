package net.minecraft.server;

public class TileEntityFlowerPot extends TileEntity
{
    private Item a;
    private int i;
    
    public TileEntityFlowerPot() {
    }
    
    public TileEntityFlowerPot(final Item a, final int i) {
        this.a = a;
        this.i = i;
    }
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("Item", Item.getId(this.a));
        nbttagcompound.setInt("Data", this.i);
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.a = Item.getById(nbttagcompound.getInt("Item"));
        this.i = nbttagcompound.getInt("Data");
    }
    
    @Override
    public Packet getUpdatePacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.b(nbttagcompound);
        return new PacketPlayOutTileEntityData(this.x, this.y, this.z, 5, nbttagcompound);
    }
    
    public void a(final Item a, final int i) {
        this.a = a;
        this.i = i;
    }
    
    public Item a() {
        return this.a;
    }
    
    public int b() {
        return this.i;
    }
}
