package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class AttributeMapServer extends AttributeMapBase
{
    private final Set d;
    protected final Map c;
    
    public AttributeMapServer() {
        this.d = Sets.newHashSet();
        this.c = new InsensitiveStringMap();
    }
    
    public AttributeModifiable c(final IAttribute attribute) {
        return (AttributeModifiable)super.a(attribute);
    }
    
    public AttributeModifiable b(final String s) {
        AttributeInstance a = super.a(s);
        if (a == null) {
            a = this.c.get(s);
        }
        return (AttributeModifiable)a;
    }
    
    @Override
    public AttributeInstance b(final IAttribute attribute) {
        if (this.b.containsKey(attribute.getName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        final AttributeModifiable attributeModifiable = new AttributeModifiable(this, attribute);
        this.b.put(attribute.getName(), attributeModifiable);
        if (attribute instanceof AttributeRanged && ((AttributeRanged)attribute).f() != null) {
            this.c.put(((AttributeRanged)attribute).f(), attributeModifiable);
        }
        this.a.put(attribute, attributeModifiable);
        return attributeModifiable;
    }
    
    @Override
    public void a(final AttributeModifiable attributeModifiable) {
        if (attributeModifiable.getAttribute().c()) {
            this.d.add(attributeModifiable);
        }
    }
    
    public Set getAttributes() {
        return this.d;
    }
    
    public Collection c() {
        final Set<AttributeInstance> hashSet = Sets.newHashSet();
        for (final AttributeInstance attributeInstance : this.a()) {
            if (attributeInstance.getAttribute().c()) {
                hashSet.add(attributeInstance);
            }
        }
        return hashSet;
    }
}
