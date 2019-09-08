package net.minecraft.server.v1_7_R4;

public class PacketPlayOutSpawnEntityExperienceOrb extends Packet
{
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    
    public PacketPlayOutSpawnEntityExperienceOrb() {
    }
    
    public PacketPlayOutSpawnEntityExperienceOrb(final EntityExperienceOrb entityExperienceOrb) {
        this.a = entityExperienceOrb.getId();
        this.b = MathHelper.floor(entityExperienceOrb.locX * 32.0);
        this.c = MathHelper.floor(entityExperienceOrb.locY * 32.0);
        this.d = MathHelper.floor(entityExperienceOrb.locZ * 32.0);
        this.e = entityExperienceOrb.e();
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.a();
        this.b = packetDataSerializer.readInt();
        this.c = packetDataSerializer.readInt();
        this.d = packetDataSerializer.readInt();
        this.e = packetDataSerializer.readShort();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a);
        packetDataSerializer.writeInt(this.b);
        packetDataSerializer.writeInt(this.c);
        packetDataSerializer.writeInt(this.d);
        packetDataSerializer.writeShort(this.e);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, value=%d, x=%.2f, y=%.2f, z=%.2f", this.a, this.e, this.b / 32.0f, this.c / 32.0f, this.d / 32.0f);
    }
}
