package net.minecraft.server;

public class PacketPlayOutCloseWindow extends Packet
{
    private int a;
    
    public PacketPlayOutCloseWindow() {
    }
    
    public PacketPlayOutCloseWindow(final int a) {
        this.a = a;
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readUnsignedByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
    }
}
