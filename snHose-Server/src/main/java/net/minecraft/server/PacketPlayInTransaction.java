package net.minecraft.server.v1_7_R4;

public class PacketPlayInTransaction extends Packet
{
    private int a;
    private short b;
    private boolean c;
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readByte();
        this.b = packetDataSerializer.readShort();
        this.c = (packetDataSerializer.readByte() != 0);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
        packetDataSerializer.writeShort(this.b);
        packetDataSerializer.writeByte(this.c ? 1 : 0);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, uid=%d, accepted=%b", this.a, this.b, this.c);
    }
    
    public int c() {
        return this.a;
    }
    
    public short d() {
        return this.b;
    }
}
