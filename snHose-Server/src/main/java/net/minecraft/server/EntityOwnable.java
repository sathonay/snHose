package net.minecraft.server.v1_7_R4;

public interface EntityOwnable
{
    String getOwnerUUID();
    
    Entity getOwner();
}
