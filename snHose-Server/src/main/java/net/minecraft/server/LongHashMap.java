package net.minecraft.server.v1_7_R4;

public class LongHashMap
{
    private transient LongHashMapEntry[] entries;
    private transient int count;
    private int c;
    private final float d;
    private transient volatile int e;
    
    public LongHashMap() {
        this.d = 0.75f;
        this.c = 12;
        this.entries = new LongHashMapEntry[16];
    }
    
    private static int g(final long n) {
        return a((int)(n ^ n >>> 32));
    }
    
    private static int a(int n) {
        n ^= (n >>> 20 ^ n >>> 12);
        return n ^ n >>> 7 ^ n >>> 4;
    }
    
    private static int a(final int n, final int n2) {
        return n & n2 - 1;
    }
    
    public int count() {
        return this.count;
    }
    
    public Object getEntry(final long n) {
        for (LongHashMapEntry c = this.entries[a(g(n), this.entries.length)]; c != null; c = c.c) {
            if (c.a == n) {
                return c.b;
            }
        }
        return null;
    }
    
    public boolean contains(final long n) {
        return this.c(n) != null;
    }
    
    final LongHashMapEntry c(final long n) {
        for (LongHashMapEntry c = this.entries[a(g(n), this.entries.length)]; c != null; c = c.c) {
            if (c.a == n) {
                return c;
            }
        }
        return null;
    }
    
    public void put(final long n, final Object b) {
        final int g = g(n);
        final int a = a(g, this.entries.length);
        for (LongHashMapEntry c = this.entries[a]; c != null; c = c.c) {
            if (c.a == n) {
                c.b = b;
                return;
            }
        }
        ++this.e;
        this.a(g, n, b, a);
    }
    
    private void b(final int n) {
        if (this.entries.length == 1073741824) {
            this.c = Integer.MAX_VALUE;
            return;
        }
        final LongHashMapEntry[] entries = new LongHashMapEntry[n];
        this.a(entries);
        this.entries = entries;
        this.c = (int)(n * this.d);
    }
    
    private void a(final LongHashMapEntry[] array) {
        final LongHashMapEntry[] entries = this.entries;
        final int length = array.length;
        for (int i = 0; i < entries.length; ++i) {
            LongHashMapEntry longHashMapEntry = entries[i];
            if (longHashMapEntry != null) {
                entries[i] = null;
                do {
                    final LongHashMapEntry c = longHashMapEntry.c;
                    final int a = a(longHashMapEntry.d, length);
                    longHashMapEntry.c = array[a];
                    array[a] = longHashMapEntry;
                    longHashMapEntry = c;
                } while (longHashMapEntry != null);
            }
        }
    }
    
    public Object remove(final long n) {
        final LongHashMapEntry e = this.e(n);
        return (e == null) ? null : e.b;
    }
    
    final LongHashMapEntry e(final long n) {
        final int a = a(g(n), this.entries.length);
        LongHashMapEntry longHashMapEntry2;
        LongHashMapEntry c;
        for (LongHashMapEntry longHashMapEntry = longHashMapEntry2 = this.entries[a]; longHashMapEntry2 != null; longHashMapEntry2 = c) {
            c = longHashMapEntry2.c;
            if (longHashMapEntry2.a == n) {
                ++this.e;
                --this.count;
                if (longHashMapEntry == longHashMapEntry2) {
                    this.entries[a] = c;
                }
                else {
                    longHashMapEntry.c = c;
                }
                return longHashMapEntry2;
            }
            longHashMapEntry = longHashMapEntry2;
        }
        return longHashMapEntry2;
    }
    
    private void a(final int n, final long n2, final Object o, final int n3) {
        this.entries[n3] = new LongHashMapEntry(n, n2, o, this.entries[n3]);
        if (this.count++ >= this.c) {
            this.b(2 * this.entries.length);
        }
    }
}
