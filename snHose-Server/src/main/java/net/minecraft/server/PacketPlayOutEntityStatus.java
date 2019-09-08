package net.minecraft.server.v1_7_R4;

public class PacketPlayOutEntityStatus extends Packet
{
    private int a;
    private byte b;
    
    public PacketPlayOutEntityStatus() {
    }
    
    public PacketPlayOutEntityStatus(final Entity entity, final byte b) {
        this.a = entity.getId();
        this.b = b;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readInt();
        this.b = packetDataSerializer.readByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeInt(this.a);
        packetDataSerializer.writeByte(this.b);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
}
