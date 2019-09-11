package net.minecraft.server;

public class PacketStatusOutPong extends Packet
{
    private long a;
    
    public PacketStatusOutPong() {
    }
    
    public PacketStatusOutPong(final long a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readLong();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeLong(this.a);
    }
    
    public void a(final PacketStatusOutListener packetStatusOutListener) {
        packetStatusOutListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
}
