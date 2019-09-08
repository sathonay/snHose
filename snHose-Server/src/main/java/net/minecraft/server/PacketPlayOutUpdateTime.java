package net.minecraft.server.v1_7_R4;

public class PacketPlayOutUpdateTime extends Packet
{
    private long a;
    private long b;
    
    public PacketPlayOutUpdateTime() {
    }
    
    public PacketPlayOutUpdateTime(final long a, final long b, final boolean b2) {
        this.a = a;
        this.b = b;
        if (!b2) {
            this.b = -this.b;
            if (this.b == 0L) {
                this.b = -1L;
            }
        }
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readLong();
        this.b = packetDataSerializer.readLong();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeLong(this.a);
        packetDataSerializer.writeLong(this.b);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("time=%d,dtime=%d", this.a, this.b);
    }
}
