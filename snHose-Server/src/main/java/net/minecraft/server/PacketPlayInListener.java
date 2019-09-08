package net.minecraft.server.v1_7_R4;

public interface PacketPlayInListener extends PacketListener
{
    void a(final PacketPlayInArmAnimation p0);
    
    void a(final PacketPlayInChat p0);
    
    void a(final PacketPlayInTabComplete p0);
    
    void a(final PacketPlayInClientCommand p0);
    
    void a(final PacketPlayInSettings p0);
    
    void a(final PacketPlayInTransaction p0);
    
    void a(final PacketPlayInEnchantItem p0);
    
    void a(final PacketPlayInWindowClick p0);
    
    void a(final PacketPlayInCloseWindow p0);
    
    void a(final PacketPlayInCustomPayload p0);
    
    void a(final PacketPlayInUseEntity p0);
    
    void a(final PacketPlayInKeepAlive p0);
    
    void a(final PacketPlayInFlying p0);
    
    void a(final PacketPlayInAbilities p0);
    
    void a(final PacketPlayInBlockDig p0);
    
    void a(final PacketPlayInEntityAction p0);
    
    void a(final PacketPlayInSteerVehicle p0);
    
    void a(final PacketPlayInHeldItemSlot p0);
    
    void a(final PacketPlayInSetCreativeSlot p0);
    
    void a(final PacketPlayInUpdateSign p0);
    
    void a(final PacketPlayInBlockPlace p0);
}
