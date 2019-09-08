package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.base.*;
import net.minecraft.util.com.google.common.collect.*;

public class RegistryID implements Registry
{
    private IdentityHashMap a;
    private List b;
    
    public RegistryID() {
        this.a = new IdentityHashMap(512);
        this.b = Lists.newArrayList();
    }
    
    public void a(final Object o, final int n) {
        this.a.put(o, n);
        while (this.b.size() <= n) {
            this.b.add(null);
        }
        this.b.set(n, o);
    }
    
    public int b(final Object o) {
        final Integer n = this.a.get(o);
        return (n == null) ? -1 : n;
    }
    
    public Object a(final int n) {
        if (n >= 0 && n < this.b.size()) {
            return this.b.get(n);
        }
        return null;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.filter(this.b.iterator(), Predicates.notNull());
    }
    
    public boolean b(final int n) {
        return this.a(n) != null;
    }
}
