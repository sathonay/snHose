package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMineshaftStart extends StructureStart
{
    public WorldGenMineshaftStart() {
    }
    
    public WorldGenMineshaftStart(final World world, final Random random, final int n, final int n2) {
        super(n, n2);
        final WorldGenMineshaftRoom worldGenMineshaftRoom = new WorldGenMineshaftRoom(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this.a.add(worldGenMineshaftRoom);
        worldGenMineshaftRoom.a(worldGenMineshaftRoom, this.a, random);
        this.c();
        this.a(world, random, 10);
    }
}
