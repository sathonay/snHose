package net.minecraft.server.v1_7_R4;

public class PacketPlayOutTransaction extends Packet
{
    private int a;
    private short b;
    private boolean c;
    
    public PacketPlayOutTransaction() {
    }
    
    public PacketPlayOutTransaction(final int a, final short b, final boolean c) {
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
        this.c = packetDataSerializer.readBoolean();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
        packetDataSerializer.writeShort(this.b);
        packetDataSerializer.writeBoolean(this.c);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, uid=%d, accepted=%b", this.a, this.b, this.c);
    }
}
