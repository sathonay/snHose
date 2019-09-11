package net.minecraft.server;

public class PacketPlayInHeldItemSlot extends Packet
{
    private int itemInHandIndex;
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.itemInHandIndex = packetDataSerializer.readShort();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeShort(this.itemInHandIndex);
    }
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    public int c() {
        return this.itemInHandIndex;
    }
}
