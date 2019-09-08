package net.minecraft.server.v1_7_R4;

public class PacketPlayOutRespawn extends Packet
{
    private int a;
    private EnumDifficulty b;
    private EnumGamemode c;
    private WorldType d;
    
    public PacketPlayOutRespawn() {
    }
    
    public PacketPlayOutRespawn(final int a, final EnumDifficulty b, final WorldType d, final EnumGamemode c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readInt();
        this.b = EnumDifficulty.getById(packetDataSerializer.readUnsignedByte());
        this.c = EnumGamemode.getById(packetDataSerializer.readUnsignedByte());
        this.d = WorldType.getType(packetDataSerializer.c(16));
        if (this.d == null) {
            this.d = WorldType.NORMAL;
        }
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeInt(this.a);
        packetDataSerializer.writeByte(this.b.a());
        packetDataSerializer.writeByte(this.c.getId());
        packetDataSerializer.a(this.d.name());
    }
}
