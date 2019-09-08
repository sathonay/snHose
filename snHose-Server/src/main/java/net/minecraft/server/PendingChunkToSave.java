package net.minecraft.server.v1_7_R4;

class PendingChunkToSave
{
    public final ChunkCoordIntPair a;
    public final NBTTagCompound b;
    
    public PendingChunkToSave(final ChunkCoordIntPair a, final NBTTagCompound b) {
        this.a = a;
        this.b = b;
    }
}
