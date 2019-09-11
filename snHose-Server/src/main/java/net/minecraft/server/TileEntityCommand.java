package net.minecraft.server;

public class TileEntityCommand extends TileEntity
{
    private final CommandBlockListenerAbstract a;
    
    public TileEntityCommand() {
        this.a = new TileEntityCommandListener(this);
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a.a(nbtTagCompound);
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        this.a.b(nbtTagCompound);
    }
    
    @Override
    public Packet getUpdatePacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.b(nbttagcompound);
        return new PacketPlayOutTileEntityData(this.x, this.y, this.z, 2, nbttagcompound);
    }
    
    public CommandBlockListenerAbstract getCommandBlock() {
        return this.a;
    }
}
