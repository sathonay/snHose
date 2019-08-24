//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import net.minecraft.util.org.apache.commons.lang3.Validate;

import java.io.IOException;

public class PacketPlayOutNamedSoundEffect extends Packet {
    private String a;
    private int b;
    private int c = 2147483647;
    private int d;
    private float e;
    private int f;

    public PacketPlayOutNamedSoundEffect() {
    }

    public PacketPlayOutNamedSoundEffect(String var1, double var2, double var4, double var6, float var8, float var9) {
        Validate.notNull(var1, "name", new Object[0]);
        this.a = var1;
        this.b = (int)(var2 * 8.0D);
        this.c = (int)(var4 * 8.0D);
        this.d = (int)(var6 * 8.0D);
        this.e = var8;

        /*
        this.f = (int)(var9 * 63.0F);
        if (this.f < 0) {
            this.f = 0;
        }

        if (this.f > 255) {
            this.f = 255;
        }
         */

        this.f = (int) MathHelper.limit((var9 * 63.0F), 0, 255); //snHose
    }

    public void a(PacketDataSerializer var1) {
        try {
            this.a = var1.c(256);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.b = var1.readInt();
        this.c = var1.readInt();
        this.d = var1.readInt();
        this.e = var1.readFloat();
        this.f = var1.readUnsignedByte();
    }

    public void b(PacketDataSerializer var1) {
        try {
            var1.a(this.a);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        var1.writeInt(this.b);
        var1.writeInt(this.c);
        var1.writeInt(this.d);
        var1.writeFloat(this.e);
        var1.writeByte(this.f);
    }

    @Override
    public void handle(PacketListener packetlistener) {
        this.a((PacketPlayOutListener) packetlistener);
    }

    public void a(PacketPlayOutListener var1) {
        var1.a(this);
    }
}
