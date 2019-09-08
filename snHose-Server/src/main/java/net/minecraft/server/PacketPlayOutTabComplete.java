package net.minecraft.server.v1_7_R4;

import net.minecraft.util.org.apache.commons.lang3.*;

public class PacketPlayOutTabComplete extends Packet
{
    private String[] a;
    
    public PacketPlayOutTabComplete() {
    }
    
    public PacketPlayOutTabComplete(final String[] a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = new String[packetDataSerializer.a()];
        for (int i = 0; i < this.a.length; ++i) {
            this.a[i] = packetDataSerializer.c(32767);
        }
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a.length);
        final String[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            packetDataSerializer.a(a[i]);
        }
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public String b() {
        return String.format("candidates='%s'", ArrayUtils.toString(this.a));
    }
}
