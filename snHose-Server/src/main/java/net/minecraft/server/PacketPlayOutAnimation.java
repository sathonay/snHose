package net.minecraft.server.v1_7_R4;

public class PacketPlayOutAnimation extends Packet
{
    private int a;
    private int b;
    
    public PacketPlayOutAnimation() {
    }
    
    public PacketPlayOutAnimation(final Entity entity, final int b) {
        this.a = entity.getId();
        this.b = b;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.a();
        this.b = packetDataSerializer.readUnsignedByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a);
        packetDataSerializer.writeByte(this.b);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, type=%d", this.a, this.b);
    }
}
