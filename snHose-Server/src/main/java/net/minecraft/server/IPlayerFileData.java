package net.minecraft.server.v1_7_R4;

public interface IPlayerFileData
{
    void save(final EntityHuman p0);
    
    NBTTagCompound load(final EntityHuman p0);
    
    String[] getSeenPlayers();
}
