package net.minecraft.server;

public interface PacketListener
{
    void a(final IChatBaseComponent p0);
    
    void a(final EnumProtocol p0, final EnumProtocol p1);
    
    void a();
}
