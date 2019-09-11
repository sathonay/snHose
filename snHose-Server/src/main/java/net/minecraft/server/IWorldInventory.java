package net.minecraft.server;

public interface IWorldInventory extends IInventory
{
    int[] getSlotsForFace(final int p0);
    
    boolean canPlaceItemThroughFace(final int p0, final ItemStack p1, final int p2);
    
    boolean canTakeItemThroughFace(final int p0, final ItemStack p1, final int p2);
}
