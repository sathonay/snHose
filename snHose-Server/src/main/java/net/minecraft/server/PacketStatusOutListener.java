package net.minecraft.server;

public interface PacketStatusOutListener extends PacketListener
{
    void a(final PacketStatusOutServerInfo p0);
    
    void a(final PacketStatusOutPong p0);
}
