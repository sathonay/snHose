package net.minecraft.server;

import java.security.*;
import net.minecraft.util.io.netty.buffer.*;

public class PacketLoginOutEncryptionBegin extends Packet
{
    private String a;
    private PublicKey b;
    private byte[] c;
    
    public PacketLoginOutEncryptionBegin() {
    }
    
    public PacketLoginOutEncryptionBegin(final String a, final PublicKey b, final byte[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.c(20);
        this.b = MinecraftEncryption.a(Packet.a((ByteBuf)packetDataSerializer));
        this.c = Packet.a((ByteBuf)packetDataSerializer);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.a(this.a);
        Packet.a(packetDataSerializer, this.b.getEncoded());
        Packet.a(packetDataSerializer, this.c);
    }
    
    public void a(final PacketLoginOutListener packetLoginOutListener) {
        packetLoginOutListener.a(this);
    }
}
