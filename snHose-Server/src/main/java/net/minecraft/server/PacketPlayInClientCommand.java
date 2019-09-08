package net.minecraft.server.v1_7_R4;

public class PacketPlayInClientCommand extends Packet
{
    private EnumClientCommand a;
    
    public PacketPlayInClientCommand() {
    }
    
    public PacketPlayInClientCommand(final EnumClientCommand a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = EnumClientCommand.e[packetDataSerializer.readByte() % EnumClientCommand.e.length];
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a.d);
    }
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    public EnumClientCommand c() {
        return this.a;
    }
}
