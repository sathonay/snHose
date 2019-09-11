package net.minecraft.server;

import java.util.*;

public class WorldGenNetherStart extends StructureStart
{
    public WorldGenNetherStart() {
    }
    
    public WorldGenNetherStart(final World world, final Random random, final int n, final int n2) {
        super(n, n2);
        final WorldGenNetherPiece15 worldGenNetherPiece15 = new WorldGenNetherPiece15(random, (n << 4) + 2, (n2 << 4) + 2);
        this.a.add(worldGenNetherPiece15);
        worldGenNetherPiece15.a(worldGenNetherPiece15, this.a, random);
        final ArrayList e = worldGenNetherPiece15.e;
        while (!e.isEmpty()) {
            e.remove(random.nextInt(e.size())).a(worldGenNetherPiece15, this.a, random);
        }
        this.c();
        this.a(world, random, 48, 70);
    }
}
