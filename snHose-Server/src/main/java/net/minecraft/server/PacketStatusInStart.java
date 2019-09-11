package net.minecraft.server;

public class PacketStatusInStart extends Packet
{
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
    }
    
    public void a(final PacketStatusInListener packetStatusInListener) {
        packetStatusInListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
}
