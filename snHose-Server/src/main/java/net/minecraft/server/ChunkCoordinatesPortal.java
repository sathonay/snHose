package net.minecraft.server;

public class ChunkCoordinatesPortal extends ChunkCoordinates
{
    public long d;
    final /* synthetic */ PortalTravelAgent e;
    
    public ChunkCoordinatesPortal(final PortalTravelAgent e, final int n, final int n2, final int n3, final long d) {
        super(n, n2, n3);
        this.e = e;
        this.d = d;
    }
}
