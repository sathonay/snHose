package net.minecraft.server;

import java.util.*;

public class WorldGenStronghold2Start extends StructureStart
{
    public WorldGenStronghold2Start() {
    }
    
    public WorldGenStronghold2Start(final World world, final Random random, final int n, final int n2) {
        super(n, n2);
        WorldGenStrongholdPieces.b();
        final WorldGenStrongholdStart worldGenStrongholdStart = new WorldGenStrongholdStart(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this.a.add(worldGenStrongholdStart);
        worldGenStrongholdStart.a(worldGenStrongholdStart, this.a, random);
        final List c = worldGenStrongholdStart.c;
        while (!c.isEmpty()) {
            c.remove(random.nextInt(c.size())).a(worldGenStrongholdStart, this.a, random);
        }
        this.c();
        this.a(world, random, 10);
    }
}
