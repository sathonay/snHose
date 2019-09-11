package net.minecraft.server;

import java.util.*;

public class InsensitiveStringMap implements Map
{
    private final Map a;
    
    public InsensitiveStringMap() {
        this.a = new LinkedHashMap();
    }
    
    @Override
    public int size() {
        return this.a.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.a.containsKey(o.toString().toLowerCase());
    }
    
    @Override
    public boolean containsValue(final Object o) {
        return this.a.containsKey(o);
    }
    
    @Override
    public Object get(final Object o) {
        return this.a.get(o.toString().toLowerCase());
    }
    
    public Object put(final String s, final Object o) {
        return this.a.put(s.toLowerCase(), o);
    }
    
    @Override
    public Object remove(final Object o) {
        return this.a.remove(o.toString().toLowerCase());
    }
    
    @Override
    public void putAll(final Map map) {
        for (final Entry<String, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void clear() {
        this.a.clear();
    }
    
    @Override
    public Set keySet() {
        return this.a.keySet();
    }
    
    @Override
    public Collection values() {
        return this.a.values();
    }
    
    @Override
    public Set entrySet() {
        return this.a.entrySet();
    }
}
