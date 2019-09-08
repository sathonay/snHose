package net.minecraft.server.v1_7_R4;

public interface PacketLoginOutListener extends PacketListener
{
    void a(final PacketLoginOutEncryptionBegin p0);
    
    void a(final PacketLoginOutSuccess p0);
    
    void a(final PacketLoginOutDisconnect p0);
}
