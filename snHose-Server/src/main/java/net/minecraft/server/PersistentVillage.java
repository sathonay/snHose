package net.minecraft.server.v1_7_R4;

import java.util.*;

public class PersistentVillage extends PersistentBase
{
    private World world;
    private final List b;
    private final List c;
    private final List villages;
    private int time;
    
    public PersistentVillage(final String s) {
        super(s);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.villages = new ArrayList();
    }
    
    public PersistentVillage(final World world) {
        super("villages");
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.villages = new ArrayList();
        this.world = world;
        this.c();
    }
    
    public void a(final World world) {
        this.world = world;
        final Iterator<Village> iterator = this.villages.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(world);
        }
    }
    
    public void a(final int n, final int n2, final int n3) {
        if (this.b.size() > 64) {
            return;
        }
        if (!this.d(n, n2, n3)) {
            this.b.add(new ChunkCoordinates(n, n2, n3));
        }
    }
    
    public void tick() {
        ++this.time;
        final Iterator<Village> iterator = this.villages.iterator();
        while (iterator.hasNext()) {
            iterator.next().tick(this.time);
        }
        this.e();
        this.f();
        this.g();
        if (this.time % 400 == 0) {
            this.c();
        }
    }
    
    private void e() {
        final Iterator<Village> iterator = (Iterator<Village>)this.villages.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isAbandoned()) {
                iterator.remove();
                this.c();
            }
        }
    }
    
    public List getVillages() {
        return this.villages;
    }
    
    public Village getClosestVillage(final int n, final int n2, final int n3, final int n4) {
        Village village = null;
        float n5 = Float.MAX_VALUE;
        for (final Village village2 : this.villages) {
            final float e = village2.getCenter().e(n, n2, n3);
            if (e >= n5) {
                continue;
            }
            final float n6 = n4 + village2.getSize();
            if (e > n6 * n6) {
                continue;
            }
            village = village2;
            n5 = e;
        }
        return village;
    }
    
    private void f() {
        if (this.b.isEmpty()) {
            return;
        }
        this.a(this.b.remove(0));
    }
    
    private void g() {
        for (int i = 0; i < this.c.size(); ++i) {
            final VillageDoor villageDoor = this.c.get(i);
            boolean b = false;
            for (final Village village : this.villages) {
                final int n = (int)village.getCenter().e(villageDoor.locX, villageDoor.locY, villageDoor.locZ);
                final int n2 = 32 + village.getSize();
                if (n > n2 * n2) {
                    continue;
                }
                village.addDoor(villageDoor);
                b = true;
                break;
            }
            if (!b) {
                final Village village2 = new Village(this.world);
                village2.addDoor(villageDoor);
                this.villages.add(village2);
                this.c();
            }
        }
        this.c.clear();
    }
    
    private void a(final ChunkCoordinates chunkCoordinates) {
        final int n = 16;
        final int n2 = 4;
        final int n3 = 16;
        for (int i = chunkCoordinates.x - n; i < chunkCoordinates.x + n; ++i) {
            for (int j = chunkCoordinates.y - n2; j < chunkCoordinates.y + n2; ++j) {
                for (int k = chunkCoordinates.z - n3; k < chunkCoordinates.z + n3; ++k) {
                    if (this.e(i, j, k)) {
                        final VillageDoor b = this.b(i, j, k);
                        if (b == null) {
                            this.c(i, j, k);
                        }
                        else {
                            b.addedTime = this.time;
                        }
                    }
                }
            }
        }
    }
    
    private VillageDoor b(final int i, final int j, final int k) {
        for (final VillageDoor villageDoor : this.c) {
            if (villageDoor.locX == i && villageDoor.locZ == k && Math.abs(villageDoor.locY - j) <= 1) {
                return villageDoor;
            }
        }
        final Iterator<Village> iterator2 = this.villages.iterator();
        while (iterator2.hasNext()) {
            final VillageDoor e = iterator2.next().e(i, j, k);
            if (e != null) {
                return e;
            }
        }
        return null;
    }
    
    private void c(final int i, final int j, final int k) {
        final int e = ((BlockDoor)Blocks.WOODEN_DOOR).e(this.world, i, j, k);
        if (e == 0 || e == 2) {
            int n = 0;
            for (int l = -5; l < 0; ++l) {
                if (this.world.i(i + l, j, k)) {
                    --n;
                }
            }
            for (int n2 = 1; n2 <= 5; ++n2) {
                if (this.world.i(i + n2, j, k)) {
                    ++n;
                }
            }
            if (n != 0) {
                this.c.add(new VillageDoor(i, j, k, (n > 0) ? -2 : 2, 0, this.time));
            }
        }
        else {
            int n3 = 0;
            for (int n4 = -5; n4 < 0; ++n4) {
                if (this.world.i(i, j, k + n4)) {
                    --n3;
                }
            }
            for (int n5 = 1; n5 <= 5; ++n5) {
                if (this.world.i(i, j, k + n5)) {
                    ++n3;
                }
            }
            if (n3 != 0) {
                this.c.add(new VillageDoor(i, j, k, 0, (n3 > 0) ? -2 : 2, this.time));
            }
        }
    }
    
    private boolean d(final int n, final int n2, final int n3) {
        for (final ChunkCoordinates chunkCoordinates : this.b) {
            if (chunkCoordinates.x == n && chunkCoordinates.y == n2 && chunkCoordinates.z == n3) {
                return true;
            }
        }
        return false;
    }
    
    private boolean e(final int i, final int j, final int k) {
        return this.world.getType(i, j, k) == Blocks.WOODEN_DOOR;
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        this.time = nbtTagCompound.getInt("Tick");
        final NBTTagList list = nbtTagCompound.getList("Villages", 10);
        for (int i = 0; i < list.size(); ++i) {
            final NBTTagCompound value = list.get(i);
            final Village village = new Village();
            village.a(value);
            this.villages.add(village);
        }
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setInt("Tick", this.time);
        final NBTTagList list = new NBTTagList();
        for (final Village village : this.villages) {
            final NBTTagCompound nbtTagCompound2 = new NBTTagCompound();
            village.b(nbtTagCompound2);
            list.add(nbtTagCompound2);
        }
        nbtTagCompound.set("Villages", list);
    }
}
