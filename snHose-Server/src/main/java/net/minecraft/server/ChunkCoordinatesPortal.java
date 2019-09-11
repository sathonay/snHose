package net.minecraft.server;

public class ChunkCoordinatesPortal extends ChunkCoordinates
{
    public long d;
    final /* synthetic */ PortalTravelAgent e;
    
    public ChunkCoordinatesPortal(final PortalTravelAgent e, final int n, final int n2, final int n3, final long d) {
        this.e = e;
        super(n, n2, n3);
        this.d = d;
    }
}
