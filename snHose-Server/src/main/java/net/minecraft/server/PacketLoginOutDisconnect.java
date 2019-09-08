package net.minecraft.server.v1_7_R4;

public class PacketLoginOutDisconnect extends Packet
{
    private IChatBaseComponent a;
    
    public PacketLoginOutDisconnect() {
    }
    
    public PacketLoginOutDisconnect(final IChatBaseComponent a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = ChatSerializer.a(packetDataSerializer.c(32767));
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.a(ChatSerializer.a(this.a));
    }
    
    public void a(final PacketLoginOutListener packetLoginOutListener) {
        packetLoginOutListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
}
