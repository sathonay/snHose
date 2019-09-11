package net.minecraft.server;

public class PacketPlayOutSpawnEntityWeather extends Packet
{
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    
    public PacketPlayOutSpawnEntityWeather() {
    }
    
    public PacketPlayOutSpawnEntityWeather(final Entity entity) {
        this.a = entity.getId();
        this.b = MathHelper.floor(entity.locX * 32.0);
        this.c = MathHelper.floor(entity.locY * 32.0);
        this.d = MathHelper.floor(entity.locZ * 32.0);
        if (entity instanceof EntityLightning) {
            this.e = 1;
        }
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.a();
        this.e = packetDataSerializer.readByte();
        this.b = packetDataSerializer.readInt();
        this.c = packetDataSerializer.readInt();
        this.d = packetDataSerializer.readInt();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a);
        packetDataSerializer.writeByte(this.e);
        packetDataSerializer.writeInt(this.b);
        packetDataSerializer.writeInt(this.c);
        packetDataSerializer.writeInt(this.d);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f", this.a, this.e, this.b / 32.0f, this.c / 32.0f, this.d / 32.0f);
    }
}
