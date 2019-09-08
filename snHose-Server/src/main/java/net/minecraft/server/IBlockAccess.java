package net.minecraft.server.v1_7_R4;

public interface IBlockAccess
{
    Block getType(final int p0, final int p1, final int p2);
    
    TileEntity getTileEntity(final int p0, final int p1, final int p2);
    
    int getData(final int p0, final int p1, final int p2);
    
    int getBlockPower(final int p0, final int p1, final int p2, final int p3);
}
