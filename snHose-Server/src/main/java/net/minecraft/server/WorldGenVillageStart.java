package net.minecraft.server;

import java.util.*;

public class WorldGenVillageStart extends StructureStart
{
    private boolean c;
    
    public WorldGenVillageStart() {
    }
    
    public WorldGenVillageStart(final World world, final Random random, final int n, final int n2, final int i) {
        super(n, n2);
        final WorldGenVillageStartPiece worldGenVillageStartPiece = new WorldGenVillageStartPiece(world.getWorldChunkManager(), 0, random, (n << 4) + 2, (n2 << 4) + 2, WorldGenVillagePieces.a(random, i), i);
        this.a.add(worldGenVillageStartPiece);
        worldGenVillageStartPiece.a(worldGenVillageStartPiece, this.a, random);
        final List j = worldGenVillageStartPiece.j;
        final List k = worldGenVillageStartPiece.i;
        while (!j.isEmpty() || !k.isEmpty()) {
            if (j.isEmpty()) {
                k.remove(random.nextInt(k.size())).a(worldGenVillageStartPiece, this.a, random);
            }
            else {
                j.remove(random.nextInt(j.size())).a(worldGenVillageStartPiece, this.a, random);
            }
        }
        this.c();
        int n3 = 0;
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (!(iterator.next() instanceof WorldGenVillageRoadPiece)) {
                ++n3;
            }
        }
        this.c = (n3 > 2);
    }
    
    @Override
    public boolean d() {
        return this.c;
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("Valid", this.c);
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.c = nbtTagCompound.getBoolean("Valid");
    }
}
