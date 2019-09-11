package net.minecraft.server;

class LongHashMapEntry
{
    final long a;
    Object b;
    LongHashMapEntry c;
    final int d;
    
    LongHashMapEntry(final int d, final long a, final Object b, final LongHashMapEntry c) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
    }
    
    public final long a() {
        return this.a;
    }
    
    public final Object b() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof LongHashMapEntry)) {
            return false;
        }
        final LongHashMapEntry longHashMapEntry = (LongHashMapEntry)o;
        final Long value = this.a();
        final Long value2 = longHashMapEntry.a();
        if (value == value2 || (value != null && value.equals(value2))) {
            final Object b = this.b();
            final Object b2 = longHashMapEntry.b();
            if (b == b2 || (b != null && b.equals(b2))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return g(this.a);
    }
    
    @Override
    public final String toString() {
        return this.a() + "=" + this.b();
    }
}
