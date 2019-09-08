package net.minecraft.server.v1_7_R4;

public class PacketPlayOutWindowData extends Packet
{
    private int a;
    private int b;
    private int c;
    
    public PacketPlayOutWindowData() {
    }
    
    public PacketPlayOutWindowData(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readUnsignedByte();
        this.b = packetDataSerializer.readShort();
        this.c = packetDataSerializer.readShort();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
        packetDataSerializer.writeShort(this.b);
        packetDataSerializer.writeShort(this.c);
    }
}
