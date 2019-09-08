package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public abstract class AttributeMapBase
{
    protected final Map a;
    protected final Map b;
    
    public AttributeMapBase() {
        this.a = new HashMap();
        this.b = new InsensitiveStringMap();
    }
    
    public AttributeInstance a(final IAttribute attribute) {
        return this.a.get(attribute);
    }
    
    public AttributeInstance a(final String s) {
        return this.b.get(s);
    }
    
    public abstract AttributeInstance b(final IAttribute p0);
    
    public Collection a() {
        return this.b.values();
    }
    
    public void a(final AttributeModifiable attributeModifiable) {
    }
    
    public void a(final Multimap multimap) {
        for (final Map.Entry<String, V> entry : multimap.entries()) {
            final AttributeInstance a = this.a(entry.getKey());
            if (a != null) {
                a.b((AttributeModifier)entry.getValue());
            }
        }
    }
    
    public void b(final Multimap multimap) {
        for (final Map.Entry<String, V> entry : multimap.entries()) {
            final AttributeInstance a = this.a(entry.getKey());
            if (a != null) {
                a.b((AttributeModifier)entry.getValue());
                a.a((AttributeModifier)entry.getValue());
            }
        }
    }
}
