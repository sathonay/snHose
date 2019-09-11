package net.minecraft.server;

public class PacketPlayOutHeldItemSlot extends Packet
{
    private int a;
    
    public PacketPlayOutHeldItemSlot() {
    }
    
    public PacketPlayOutHeldItemSlot(final int a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
}
