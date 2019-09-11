package net.minecraft.server;

public class PacketPlayOutAttachEntity extends Packet
{
    private int a;
    private int b;
    private int c;
    
    public PacketPlayOutAttachEntity() {
    }
    
    public PacketPlayOutAttachEntity(final int a, final Entity entity, final Entity entity2) {
        this.a = a;
        this.b = entity.getId();
        this.c = ((entity2 != null) ? entity2.getId() : -1);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.b = packetDataSerializer.readInt();
        this.c = packetDataSerializer.readInt();
        this.a = packetDataSerializer.readUnsignedByte();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeInt(this.b);
        packetDataSerializer.writeInt(this.c);
        packetDataSerializer.writeByte(this.a);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
}
