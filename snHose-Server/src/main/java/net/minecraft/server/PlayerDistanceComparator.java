package net.minecraft.server;

import java.util.*;

public class PlayerDistanceComparator implements Comparator<EntityPlayer> {
    private final ChunkCoordinates a;
    
    public PlayerDistanceComparator(final ChunkCoordinates a) {
        this.a = a;
    }
    
    public int a(final EntityPlayer entityPlayer, final EntityPlayer entityPlayer2) {
        final double e = entityPlayer.e(this.a.x, this.a.y, this.a.z);
        final double e2 = entityPlayer2.e(this.a.x, this.a.y, this.a.z);
        if (e < e2) {
            return -1;
        }
        if (e > e2) {
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(EntityPlayer o1, EntityPlayer o2) {
        return a(o1, o2);
    }
}
