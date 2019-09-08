package net.minecraft.server.v1_7_R4;

public interface PacketStatusOutListener extends PacketListener
{
    void a(final PacketStatusOutServerInfo p0);
    
    void a(final PacketStatusOutPong p0);
}
