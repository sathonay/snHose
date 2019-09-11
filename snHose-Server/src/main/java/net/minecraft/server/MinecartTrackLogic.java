package net.minecraft.server;

import java.util.*;

public class MinecartTrackLogic
{
    private World b;
    private int c;
    private int d;
    private int e;
    private final boolean f;
    private List g;
    final /* synthetic */ BlockMinecartTrackAbstract a;
    
    public MinecartTrackLogic(final BlockMinecartTrackAbstract a, final World b, final int i, final int j, final int k) {
        this.a = a;
        this.g = new ArrayList();
        this.b = b;
        this.c = i;
        this.d = j;
        this.e = k;
        final Block type = b.getType(i, j, k);
        int data = b.getData(i, j, k);
        if (((BlockMinecartTrackAbstract)type).a) {
            this.f = true;
            data &= 0xFFFFFFF7;
        }
        else {
            this.f = false;
        }
        this.a(data);
    }
    
    private void a(final int n) {
        this.g.clear();
        if (n == 0) {
            this.g.add(new ChunkPosition(this.c, this.d, this.e - 1));
            this.g.add(new ChunkPosition(this.c, this.d, this.e + 1));
        }
        else if (n == 1) {
            this.g.add(new ChunkPosition(this.c - 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c + 1, this.d, this.e));
        }
        else if (n == 2) {
            this.g.add(new ChunkPosition(this.c - 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c + 1, this.d + 1, this.e));
        }
        else if (n == 3) {
            this.g.add(new ChunkPosition(this.c - 1, this.d + 1, this.e));
            this.g.add(new ChunkPosition(this.c + 1, this.d, this.e));
        }
        else if (n == 4) {
            this.g.add(new ChunkPosition(this.c, this.d + 1, this.e - 1));
            this.g.add(new ChunkPosition(this.c, this.d, this.e + 1));
        }
        else if (n == 5) {
            this.g.add(new ChunkPosition(this.c, this.d, this.e - 1));
            this.g.add(new ChunkPosition(this.c, this.d + 1, this.e + 1));
        }
        else if (n == 6) {
            this.g.add(new ChunkPosition(this.c + 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c, this.d, this.e + 1));
        }
        else if (n == 7) {
            this.g.add(new ChunkPosition(this.c - 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c, this.d, this.e + 1));
        }
        else if (n == 8) {
            this.g.add(new ChunkPosition(this.c - 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c, this.d, this.e - 1));
        }
        else if (n == 9) {
            this.g.add(new ChunkPosition(this.c + 1, this.d, this.e));
            this.g.add(new ChunkPosition(this.c, this.d, this.e - 1));
        }
    }
    
    private void b() {
        for (int i = 0; i < this.g.size(); ++i) {
            final MinecartTrackLogic a = this.a(this.g.get(i));
            if (a == null || !a.a(this)) {
                this.g.remove(i--);
            }
            else {
                this.g.set(i, new ChunkPosition(a.c, a.d, a.e));
            }
        }
    }
    
    private boolean a(final int i, final int j, final int k) {
        return BlockMinecartTrackAbstract.b_(this.b, i, j, k) || BlockMinecartTrackAbstract.b_(this.b, i, j + 1, k) || BlockMinecartTrackAbstract.b_(this.b, i, j - 1, k);
    }
    
    private MinecartTrackLogic a(final ChunkPosition chunkPosition) {
        if (BlockMinecartTrackAbstract.b_(this.b, chunkPosition.x, chunkPosition.y, chunkPosition.z)) {
            return new MinecartTrackLogic(this.a, this.b, chunkPosition.x, chunkPosition.y, chunkPosition.z);
        }
        if (BlockMinecartTrackAbstract.b_(this.b, chunkPosition.x, chunkPosition.y + 1, chunkPosition.z)) {
            return new MinecartTrackLogic(this.a, this.b, chunkPosition.x, chunkPosition.y + 1, chunkPosition.z);
        }
        if (BlockMinecartTrackAbstract.b_(this.b, chunkPosition.x, chunkPosition.y - 1, chunkPosition.z)) {
            return new MinecartTrackLogic(this.a, this.b, chunkPosition.x, chunkPosition.y - 1, chunkPosition.z);
        }
        return null;
    }
    
    private boolean a(final MinecartTrackLogic minecartTrackLogic) {
        for (int i = 0; i < this.g.size(); ++i) {
            final ChunkPosition chunkPosition = this.g.get(i);
            if (chunkPosition.x == minecartTrackLogic.c && chunkPosition.z == minecartTrackLogic.e) {
                return true;
            }
        }
        return false;
    }
    
    private boolean b(final int n, final int n2, final int n3) {
        for (int i = 0; i < this.g.size(); ++i) {
            final ChunkPosition chunkPosition = this.g.get(i);
            if (chunkPosition.x == n && chunkPosition.z == n3) {
                return true;
            }
        }
        return false;
    }
    
    protected int a() {
        int n = 0;
        if (this.a(this.c, this.d, this.e - 1)) {
            ++n;
        }
        if (this.a(this.c, this.d, this.e + 1)) {
            ++n;
        }
        if (this.a(this.c - 1, this.d, this.e)) {
            ++n;
        }
        if (this.a(this.c + 1, this.d, this.e)) {
            ++n;
        }
        return n;
    }
    
    private boolean b(final MinecartTrackLogic minecartTrackLogic) {
        return this.a(minecartTrackLogic) || (this.g.size() != 2 && (!this.g.isEmpty() || true));
    }
    
    private void c(final MinecartTrackLogic minecartTrackLogic) {
        this.g.add(new ChunkPosition(minecartTrackLogic.c, minecartTrackLogic.d, minecartTrackLogic.e));
        final boolean b = this.b(this.c, this.d, this.e - 1);
        final boolean b2 = this.b(this.c, this.d, this.e + 1);
        final boolean b3 = this.b(this.c - 1, this.d, this.e);
        final boolean b4 = this.b(this.c + 1, this.d, this.e);
        int n = -1;
        if (b || b2) {
            n = 0;
        }
        if (b3 || b4) {
            n = 1;
        }
        if (!this.f) {
            if (b2 && b4 && !b && !b3) {
                n = 6;
            }
            if (b2 && b3 && !b && !b4) {
                n = 7;
            }
            if (b && b3 && !b2 && !b4) {
                n = 8;
            }
            if (b && b4 && !b2 && !b3) {
                n = 9;
            }
        }
        if (n == 0) {
            if (BlockMinecartTrackAbstract.b_(this.b, this.c, this.d + 1, this.e - 1)) {
                n = 4;
            }
            if (BlockMinecartTrackAbstract.b_(this.b, this.c, this.d + 1, this.e + 1)) {
                n = 5;
            }
        }
        if (n == 1) {
            if (BlockMinecartTrackAbstract.b_(this.b, this.c + 1, this.d + 1, this.e)) {
                n = 2;
            }
            if (BlockMinecartTrackAbstract.b_(this.b, this.c - 1, this.d + 1, this.e)) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        int l = n;
        if (this.f) {
            l = ((this.b.getData(this.c, this.d, this.e) & 0x8) | n);
        }
        this.b.setData(this.c, this.d, this.e, l, 3);
    }
    
    private boolean c(final int n, final int n2, final int n3) {
        final MinecartTrackLogic a = this.a(new ChunkPosition(n, n2, n3));
        if (a == null) {
            return false;
        }
        a.b();
        return a.b(this);
    }
    
    public void a(final boolean b, final boolean b2) {
        final boolean c = this.c(this.c, this.d, this.e - 1);
        final boolean c2 = this.c(this.c, this.d, this.e + 1);
        final boolean c3 = this.c(this.c - 1, this.d, this.e);
        final boolean c4 = this.c(this.c + 1, this.d, this.e);
        int n = -1;
        if ((c || c2) && !c3 && !c4) {
            n = 0;
        }
        if ((c3 || c4) && !c && !c2) {
            n = 1;
        }
        if (!this.f) {
            if (c2 && c4 && !c && !c3) {
                n = 6;
            }
            if (c2 && c3 && !c && !c4) {
                n = 7;
            }
            if (c && c3 && !c2 && !c4) {
                n = 8;
            }
            if (c && c4 && !c2 && !c3) {
                n = 9;
            }
        }
        if (n == -1) {
            if (c || c2) {
                n = 0;
            }
            if (c3 || c4) {
                n = 1;
            }
            if (!this.f) {
                if (b) {
                    if (c2 && c4) {
                        n = 6;
                    }
                    if (c3 && c2) {
                        n = 7;
                    }
                    if (c4 && c) {
                        n = 9;
                    }
                    if (c && c3) {
                        n = 8;
                    }
                }
                else {
                    if (c && c3) {
                        n = 8;
                    }
                    if (c4 && c) {
                        n = 9;
                    }
                    if (c3 && c2) {
                        n = 7;
                    }
                    if (c2 && c4) {
                        n = 6;
                    }
                }
            }
        }
        if (n == 0) {
            if (BlockMinecartTrackAbstract.b_(this.b, this.c, this.d + 1, this.e - 1)) {
                n = 4;
            }
            if (BlockMinecartTrackAbstract.b_(this.b, this.c, this.d + 1, this.e + 1)) {
                n = 5;
            }
        }
        if (n == 1) {
            if (BlockMinecartTrackAbstract.b_(this.b, this.c + 1, this.d + 1, this.e)) {
                n = 2;
            }
            if (BlockMinecartTrackAbstract.b_(this.b, this.c - 1, this.d + 1, this.e)) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        this.a(n);
        int l = n;
        if (this.f) {
            l = ((this.b.getData(this.c, this.d, this.e) & 0x8) | n);
        }
        if (b2 || this.b.getData(this.c, this.d, this.e) != l) {
            this.b.setData(this.c, this.d, this.e, l, 3);
            for (int i = 0; i < this.g.size(); ++i) {
                final MinecartTrackLogic a = this.a(this.g.get(i));
                if (a != null) {
                    a.b();
                    if (a.b(this)) {
                        a.c(this);
                    }
                }
            }
        }
    }
}
