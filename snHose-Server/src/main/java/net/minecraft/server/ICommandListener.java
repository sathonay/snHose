package net.minecraft.server;

public interface ICommandListener
{
    String getName();
    
    IChatBaseComponent getScoreboardDisplayName();
    
    void sendMessage(final IChatBaseComponent p0);
    
    boolean a(final int p0, final String p1);
    
    ChunkCoordinates getChunkCoordinates();
    
    World getWorld();
}
