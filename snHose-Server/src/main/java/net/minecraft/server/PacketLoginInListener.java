package net.minecraft.server;

public interface PacketLoginInListener extends PacketListener
{
    void a(final PacketLoginInStart p0);
    
    void a(final PacketLoginInEncryptionBegin p0);
}
