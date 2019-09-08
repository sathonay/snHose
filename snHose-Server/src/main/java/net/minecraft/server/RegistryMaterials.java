package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class RegistryMaterials extends RegistrySimple implements Registry
{
    protected final RegistryID a;
    protected final Map b;
    
    public RegistryMaterials() {
        this.a = new RegistryID();
        this.b = ((BiMap)this.c).inverse();
    }
    
    public void a(final int n, final String s, final Object o) {
        this.a.a(o, n);
        this.a(c(s), o);
    }
    
    @Override
    protected Map a() {
        return HashBiMap.create();
    }
    
    public Object get(final String s) {
        return super.get(c(s));
    }
    
    public String c(final Object o) {
        return this.b.get(o);
    }
    
    public boolean b(final String s) {
        return super.d(c(s));
    }
    
    public int b(final Object o) {
        return this.a.b(o);
    }
    
    public Object a(final int n) {
        return this.a.a(n);
    }
    
    @Override
    public Iterator iterator() {
        return this.a.iterator();
    }
    
    public boolean b(final int n) {
        return this.a.b(n);
    }
    
    private static String c(final String s) {
        return (s.indexOf(58) == -1) ? ("minecraft:" + s) : s;
    }
}
