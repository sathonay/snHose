package net.minecraft.server;

public interface PacketStatusInListener extends PacketListener
{
    void a(final PacketStatusInPing p0);
    
    void a(final PacketStatusInStart p0);
}
