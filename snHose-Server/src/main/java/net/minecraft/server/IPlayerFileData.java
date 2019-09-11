package net.minecraft.server;

public interface IPlayerFileData
{
    void save(final EntityHuman p0);
    
    NBTTagCompound load(final EntityHuman p0);
    
    String[] getSeenPlayers();
}
