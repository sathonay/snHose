package net.minecraft.server;

public class PacketPlayOutPosition extends Packet {

    private double a;
    private double b;
    private double c;
    private float d;
    private float e;
    private boolean f;
    private byte relativeBitMask; // Spigot

    public PacketPlayOutPosition() {}

    // Spigot start
    public PacketPlayOutPosition(double d0, double d1, double d2, float f, float f1, boolean flag) {
        this(d0, d1, d2, f, f1, flag, (byte) 0);
    }

    public PacketPlayOutPosition(double d0, double d1, double d2, float f, float f1, boolean flag, byte relativeBitMask) {
        this.a = d0;
        this.b = d1;
        this.c = d2;
        this.d = f;
        this.e = f1;
        this.f = flag;
        this.relativeBitMask = relativeBitMask;
        // Spigot end
    }

    public void a(PacketDataSerializer packetdataserializer) {
        this.a = packetdataserializer.readDouble();
        this.b = packetdataserializer.readDouble();
        this.c = packetdataserializer.readDouble();
        this.d = packetdataserializer.readFloat();
        this.e = packetdataserializer.readFloat();
        this.f = packetdataserializer.readBoolean();
    }

    public void b(PacketDataSerializer packetdataserializer) {
        // Spigot start - protocol patch
        packetdataserializer.writeDouble(this.a);
        packetdataserializer.writeDouble(this.b - (packetdataserializer.version >= 16 ? 1.62 : 0));
        packetdataserializer.writeDouble(this.c);
        packetdataserializer.writeFloat(this.d);
        packetdataserializer.writeFloat(this.e);
        if ( packetdataserializer.version < 16 )
        {
            packetdataserializer.writeBoolean( this.f );
        } else
        {
            packetdataserializer.writeByte( relativeBitMask );
        }
        // Spigot end
    }

    public void a(PacketPlayOutListener packetplayoutlistener) {
        packetplayoutlistener.a(this);
    }

    public void handle(PacketListener packetlistener) {
        this.a((PacketPlayOutListener) packetlistener);
    }
}
