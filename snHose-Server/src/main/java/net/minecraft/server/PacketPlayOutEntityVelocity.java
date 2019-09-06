package net.minecraft.server;

import net.minecraft.server.MathHelper;

public class PacketPlayOutEntityVelocity extends Packet {

    private int a;
    private int b;
    private int c;
    private int d;

    public PacketPlayOutEntityVelocity() {}

    public PacketPlayOutEntityVelocity(Entity entity) {
        this(entity.getId(), entity.motX, entity.motY, entity.motZ);
    }

    public PacketPlayOutEntityVelocity(int i, double d0, double d1, double d2) {
        this.a = i;
        final double d3 = 3.9D;
        this.b = (int) (MathHelper.limit(d0, -d3, d3) * 8000.0D);
        this.c = (int) (MathHelper.limit(d1, -d3, d3) * 8000.0D);
        this.d = (int) (MathHelper.limit(d2, -d3, d3) * 8000.0D);
    }

    public void a(PacketDataSerializer packetdataserializer) {
        this.a = packetdataserializer.readInt();
        this.b = packetdataserializer.readShort();
        this.c = packetdataserializer.readShort();
        this.d = packetdataserializer.readShort();
    }

    public void b(PacketDataSerializer packetdataserializer) {
        // Spigot start - protocol patch
        if ( packetdataserializer.version < 16 )
        {
            packetdataserializer.writeInt( this.a );
        } else
        {
            packetdataserializer.b( a );
        }
        // Spigot end
        packetdataserializer.writeShort(this.b);
        packetdataserializer.writeShort(this.c);
        packetdataserializer.writeShort(this.d);
    }

    public void a(PacketPlayOutListener packetplayoutlistener) {
        packetplayoutlistener.a(this);
    }

    public String b() {
        return String.format("id=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.a), Float.valueOf((float) this.b / 8000.0F), Float.valueOf((float) this.c / 8000.0F), Float.valueOf((float) this.d / 8000.0F)});
    }

    public void handle(PacketListener packetlistener) {
        this.a((PacketPlayOutListener) packetlistener);
    }
}
