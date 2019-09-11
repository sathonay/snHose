package net.minecraft.server;

class IntHashMapEntry
{
    final int a;
    Object b;
    IntHashMapEntry c;
    final int d;
    
    IntHashMapEntry(final int d, final int a, final Object b, final IntHashMapEntry c) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
    }
    
    public final int a() {
        return this.a;
    }
    
    public final Object b() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof IntHashMapEntry)) {
            return false;
        }
        final IntHashMapEntry intHashMapEntry = (IntHashMapEntry)o;
        final Integer value = this.a();
        final Integer value2 = intHashMapEntry.a();
        if (value == value2 || (value != null && value.equals(value2))) {
            final Object b = this.b();
            final Object b2 = intHashMapEntry.b();
            if (b == b2 || (b != null && b.equals(b2))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return IntHashMap.f(this.a);
    }
    
    @Override
    public final String toString() {
        return this.a() + "=" + this.b();
    }
}
