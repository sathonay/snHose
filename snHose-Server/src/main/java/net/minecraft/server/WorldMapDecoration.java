package net.minecraft.server.v1_7_R4;

public class WorldMapDecoration
{
    public byte type;
    public byte locX;
    public byte locY;
    public byte rotation;
    final /* synthetic */ WorldMap e;
    
    public WorldMapDecoration(final WorldMap e, final byte type, final byte locX, final byte locY, final byte rotation) {
        this.e = e;
        this.type = type;
        this.locX = locX;
        this.locY = locY;
        this.rotation = rotation;
    }
}
