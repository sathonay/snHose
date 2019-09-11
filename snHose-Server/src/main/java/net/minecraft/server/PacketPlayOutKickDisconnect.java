package net.minecraft.server;

public class PacketPlayOutKickDisconnect extends Packet
{
    private IChatBaseComponent a;
    
    public PacketPlayOutKickDisconnect() {
    }
    
    public PacketPlayOutKickDisconnect(final IChatBaseComponent a) {
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
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
}
