package net.minecraft.server;

public class PacketPlayInLook extends PacketPlayInFlying
{
    public PacketPlayInLook() {
        this.hasLook = true;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.yaw = packetDataSerializer.readFloat();
        this.pitch = packetDataSerializer.readFloat();
        super.a(packetDataSerializer);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeFloat(this.yaw);
        packetDataSerializer.writeFloat(this.pitch);
        super.b(packetDataSerializer);
    }
}
