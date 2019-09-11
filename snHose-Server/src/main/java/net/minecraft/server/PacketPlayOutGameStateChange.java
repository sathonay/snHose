package net.minecraft.server;

public class PacketPlayOutGameStateChange extends Packet
{
    public static final String[] a;
    private int b;
    private float c;
    
    public PacketPlayOutGameStateChange() {
    }
    
    public PacketPlayOutGameStateChange(final int b, final float c) {
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.b = packetDataSerializer.readUnsignedByte();
        this.c = packetDataSerializer.readFloat();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.b);
        packetDataSerializer.writeFloat(this.c);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    static {
        a = new String[] { "tile.bed.notValid", null, null, "gameMode.changed" };
    }
}
