package net.minecraft.server.v1_7_R4;

import java.util.*;

public abstract class StructureStart
{
    protected LinkedList a;
    protected StructureBoundingBox b;
    private int c;
    private int d;
    
    public StructureStart() {
        this.a = new LinkedList();
    }
    
    public StructureStart(final int c, final int d) {
        this.a = new LinkedList();
        this.c = c;
        this.d = d;
    }
    
    public StructureBoundingBox a() {
        return this.b;
    }
    
    public LinkedList b() {
        return this.a;
    }
    
    public void a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final StructurePiece structurePiece = iterator.next();
            if (structurePiece.c().a(structureBoundingBox) && !structurePiece.a(world, random, structureBoundingBox)) {
                iterator.remove();
            }
        }
    }
    
    protected void c() {
        this.b = StructureBoundingBox.a();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            this.b.b(iterator.next().c());
        }
    }
    
    public NBTTagCompound a(final int n, final int n2) {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setString("id", WorldGenFactory.a(this));
        nbtTagCompound.setInt("ChunkX", n);
        nbtTagCompound.setInt("ChunkZ", n2);
        nbtTagCompound.set("BB", this.b.h());
        final NBTTagList list = new NBTTagList();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().b());
        }
        nbtTagCompound.set("Children", list);
        this.a(nbtTagCompound);
        return nbtTagCompound;
    }
    
    public void a(final NBTTagCompound nbtTagCompound) {
    }
    
    public void a(final World world, final NBTTagCompound nbtTagCompound) {
        this.c = nbtTagCompound.getInt("ChunkX");
        this.d = nbtTagCompound.getInt("ChunkZ");
        if (nbtTagCompound.hasKey("BB")) {
            this.b = new StructureBoundingBox(nbtTagCompound.getIntArray("BB"));
        }
        final NBTTagList list = nbtTagCompound.getList("Children", 10);
        for (int i = 0; i < list.size(); ++i) {
            this.a.add(WorldGenFactory.b(list.get(i), world));
        }
        this.b(nbtTagCompound);
    }
    
    public void b(final NBTTagCompound nbtTagCompound) {
    }
    
    protected void a(final World world, final Random random, final int n) {
        final int n2 = 63 - n;
        int n3 = this.b.c() + 1;
        if (n3 < n2) {
            n3 += random.nextInt(n2 - n3);
        }
        final int n4 = n3 - this.b.e;
        this.b.a(0, n4, 0);
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().c().a(0, n4, 0);
        }
    }
    
    protected void a(final World world, final Random random, final int n, final int n2) {
        final int n3 = n2 - n + 1 - this.b.c();
        int n4;
        if (n3 > 1) {
            n4 = n + random.nextInt(n3);
        }
        else {
            n4 = n;
        }
        final int n5 = n4 - this.b.b;
        this.b.a(0, n5, 0);
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().c().a(0, n5, 0);
        }
    }
    
    public boolean d() {
        return true;
    }
    
    public int e() {
        return this.c;
    }
    
    public int f() {
        return this.d;
    }
}
