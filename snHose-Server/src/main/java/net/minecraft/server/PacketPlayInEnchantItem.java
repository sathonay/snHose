package net.minecraft.server.v1_7_R4;

public class PacketPlayInEnchantItem extends Packet
{
    private int a;
    private int b;
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readByte();
        this.b = packetDataSerializer.readByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
        packetDataSerializer.writeByte(this.b);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, button=%d", this.a, this.b);
    }
    
    public int c() {
        return this.a;
    }
    
    public int d() {
        return this.b;
    }
}
