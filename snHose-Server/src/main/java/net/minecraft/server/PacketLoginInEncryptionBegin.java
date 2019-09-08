package net.minecraft.server.v1_7_R4;

import net.minecraft.util.io.netty.buffer.*;
import javax.crypto.*;
import java.security.*;

public class PacketLoginInEncryptionBegin extends Packet
{
    private byte[] a;
    private byte[] b;
    
    public PacketLoginInEncryptionBegin() {
        this.a = new byte[0];
        this.b = new byte[0];
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = Packet.a((ByteBuf)packetDataSerializer);
        this.b = Packet.a((ByteBuf)packetDataSerializer);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        Packet.a(packetDataSerializer, this.a);
        Packet.a(packetDataSerializer, this.b);
    }
    
    public void a(final PacketLoginInListener packetLoginInListener) {
        packetLoginInListener.a(this);
    }
    
    public SecretKey a(final PrivateKey privateKey) {
        return MinecraftEncryption.a(privateKey, this.a);
    }
    
    public byte[] b(final PrivateKey privateKey) {
        if (privateKey == null) {
            return this.b;
        }
        return MinecraftEncryption.b(privateKey, this.b);
    }
}
