package net.minecraft.server;

public class PacketPlayInAbilities extends Packet
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private float e;
    private float f;
    
    public PacketPlayInAbilities() {
    }
    
    public PacketPlayInAbilities(final PlayerAbilities playerAbilities) {
        this.a(playerAbilities.isInvulnerable);
        this.b(playerAbilities.isFlying);
        this.c(playerAbilities.canFly);
        this.d(playerAbilities.canInstantlyBuild);
        this.a(playerAbilities.a());
        this.b(playerAbilities.b());
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        final byte byte1 = packetDataSerializer.readByte();
        this.a((byte1 & 0x1) > 0);
        this.b((byte1 & 0x2) > 0);
        this.c((byte1 & 0x4) > 0);
        this.d((byte1 & 0x8) > 0);
        this.a(packetDataSerializer.readFloat());
        this.b(packetDataSerializer.readFloat());
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        int i = 0;
        if (this.c()) {
            i = (byte)(i | 0x1);
        }
        if (this.isFlying()) {
            i = (byte)(i | 0x2);
        }
        if (this.e()) {
            i = (byte)(i | 0x4);
        }
        if (this.f()) {
            i = (byte)(i | 0x8);
        }
        packetDataSerializer.writeByte(i);
        packetDataSerializer.writeFloat(this.e);
        packetDataSerializer.writeFloat(this.f);
    }
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("invuln=%b, flying=%b, canfly=%b, instabuild=%b, flyspeed=%.4f, walkspped=%.4f", this.c(), this.isFlying(), this.e(), this.f(), this.g(), this.h());
    }
    
    public boolean c() {
        return this.a;
    }
    
    public void a(final boolean a) {
        this.a = a;
    }
    
    public boolean isFlying() {
        return this.b;
    }
    
    public void b(final boolean b) {
        this.b = b;
    }
    
    public boolean e() {
        return this.c;
    }
    
    public void c(final boolean c) {
        this.c = c;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public void d(final boolean d) {
        this.d = d;
    }
    
    public float g() {
        return this.e;
    }
    
    public void a(final float e) {
        this.e = e;
    }
    
    public float h() {
        return this.f;
    }
    
    public void b(final float f) {
        this.f = f;
    }
}
