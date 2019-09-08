package net.minecraft.server.v1_7_R4;

public interface PacketLoginInListener extends PacketListener
{
    void a(final PacketLoginInStart p0);
    
    void a(final PacketLoginInEncryptionBegin p0);
}
