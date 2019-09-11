package net.minecraft.server;

import java.util.*;

public class WorldGenMineshaftRoom extends StructurePiece
{
    private List a;
    
    public WorldGenMineshaftRoom() {
        this.a = new LinkedList();
    }
    
    public WorldGenMineshaftRoom(final int n, final Random random, final int n2, final int n3) {
        super(n);
        this.a = new LinkedList();
        this.f = new StructureBoundingBox(n2, 50, n3, n2 + 7 + random.nextInt(6), 54 + random.nextInt(6), n3 + 7 + random.nextInt(6));
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        final int d = this.d();
        int n = this.f.c() - 3 - 1;
        if (n <= 0) {
            n = 1;
        }
        for (int i = 0; i < this.f.b(); i += 4) {
            i += random.nextInt(this.f.b());
            if (i + 3 > this.f.b()) {
                break;
            }
            final StructurePiece a = b(structurePiece, list, random, this.f.a + i, this.f.b + random.nextInt(n) + 1, this.f.c - 1, 2, d);
            if (a != null) {
                final StructureBoundingBox c = a.c();
                this.a.add(new StructureBoundingBox(c.a, c.b, this.f.c, c.d, c.e, this.f.c + 1));
            }
        }
        for (int j = 0; j < this.f.b(); j += 4) {
            j += random.nextInt(this.f.b());
            if (j + 3 > this.f.b()) {
                break;
            }
            final StructurePiece a2 = b(structurePiece, list, random, this.f.a + j, this.f.b + random.nextInt(n) + 1, this.f.f + 1, 0, d);
            if (a2 != null) {
                final StructureBoundingBox c2 = a2.c();
                this.a.add(new StructureBoundingBox(c2.a, c2.b, this.f.f - 1, c2.d, c2.e, this.f.f));
            }
        }
        for (int k = 0; k < this.f.d(); k += 4) {
            k += random.nextInt(this.f.d());
            if (k + 3 > this.f.d()) {
                break;
            }
            final StructurePiece a3 = b(structurePiece, list, random, this.f.a - 1, this.f.b + random.nextInt(n) + 1, this.f.c + k, 1, d);
            if (a3 != null) {
                final StructureBoundingBox c3 = a3.c();
                this.a.add(new StructureBoundingBox(this.f.a, c3.b, c3.c, this.f.a + 1, c3.e, c3.f));
            }
        }
        for (int l = 0; l < this.f.d(); l += 4) {
            l += random.nextInt(this.f.d());
            if (l + 3 > this.f.d()) {
                break;
            }
            final StructurePiece a4 = b(structurePiece, list, random, this.f.d + 1, this.f.b + random.nextInt(n) + 1, this.f.c + l, 3, d);
            if (a4 != null) {
                final StructureBoundingBox c4 = a4.c();
                this.a.add(new StructureBoundingBox(this.f.d - 1, c4.b, c4.c, this.f.d, c4.e, c4.f));
            }
        }
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        this.a(world, structureBoundingBox, this.f.a, this.f.b, this.f.c, this.f.d, this.f.b, this.f.f, Blocks.DIRT, Blocks.AIR, true);
        this.a(world, structureBoundingBox, this.f.a, this.f.b + 1, this.f.c, this.f.d, Math.min(this.f.b + 3, this.f.e), this.f.f, Blocks.AIR, Blocks.AIR, false);
        for (final StructureBoundingBox structureBoundingBox2 : this.a) {
            this.a(world, structureBoundingBox, structureBoundingBox2.a, structureBoundingBox2.e - 2, structureBoundingBox2.c, structureBoundingBox2.d, structureBoundingBox2.e, structureBoundingBox2.f, Blocks.AIR, Blocks.AIR, false);
        }
        this.a(world, structureBoundingBox, this.f.a, this.f.b + 4, this.f.c, this.f.d, this.f.e, this.f.f, Blocks.AIR, false);
        return true;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        final NBTTagList list = new NBTTagList();
        final Iterator<StructureBoundingBox> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().h());
        }
        nbtTagCompound.set("Entrances", list);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        final NBTTagList list = nbtTagCompound.getList("Entrances", 11);
        for (int i = 0; i < list.size(); ++i) {
            this.a.add(new StructureBoundingBox(list.c(i)));
        }
    }
}
