package net.minecraft.server;

public class PacketStatusInPing extends Packet
{
    private long a;
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readLong();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeLong(this.a);
    }
    
    public void a(final PacketStatusInListener packetStatusInListener) {
        packetStatusInListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
    
    public long c() {
        return this.a;
    }
}
