package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class AttributeModifiable implements AttributeInstance
{
    private final AttributeMapBase a;
    private final IAttribute b;
    private final Map c;
    private final Map d;
    private final Map e;
    private double f;
    private boolean g;
    private double h;
    
    public AttributeModifiable(final AttributeMapBase a, final IAttribute b) {
        this.c = Maps.newHashMap();
        this.d = Maps.newHashMap();
        this.e = Maps.newHashMap();
        this.g = true;
        this.a = a;
        this.b = b;
        this.f = b.b();
        for (int i = 0; i < 3; ++i) {
            this.c.put(i, new HashSet());
        }
    }
    
    @Override
    public IAttribute getAttribute() {
        return this.b;
    }
    
    @Override
    public double b() {
        return this.f;
    }
    
    @Override
    public void setValue(final double f) {
        if (f == this.b()) {
            return;
        }
        this.f = f;
        this.f();
    }
    
    public Collection a(final int n) {
        return this.c.get(n);
    }
    
    @Override
    public Collection c() {
        final HashSet set = new HashSet();
        for (int i = 0; i < 3; ++i) {
            set.addAll(this.a(i));
        }
        return set;
    }
    
    @Override
    public AttributeModifier a(final UUID uuid) {
        return this.e.get(uuid);
    }
    
    @Override
    public void a(final AttributeModifier attributeModifier) {
        if (this.a(attributeModifier.a()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        Set<AttributeModifier> set = this.d.get(attributeModifier.b());
        if (set == null) {
            set = new HashSet<AttributeModifier>();
            this.d.put(attributeModifier.b(), set);
        }
        this.c.get(attributeModifier.c()).add(attributeModifier);
        set.add(attributeModifier);
        this.e.put(attributeModifier.a(), attributeModifier);
        this.f();
    }
    
    private void f() {
        this.g = true;
        this.a.a(this);
    }
    
    @Override
    public void b(final AttributeModifier attributeModifier) {
        for (int i = 0; i < 3; ++i) {
            ((Set)this.c.get(i)).remove(attributeModifier);
        }
        final Set set = this.d.get(attributeModifier.b());
        if (set != null) {
            set.remove(attributeModifier);
            if (set.isEmpty()) {
                this.d.remove(attributeModifier.b());
            }
        }
        this.e.remove(attributeModifier.a());
        this.f();
    }
    
    @Override
    public double getValue() {
        if (this.g) {
            this.h = this.g();
            this.g = false;
        }
        return this.h;
    }
    
    private double g() {
        double b = this.b();
        final Iterator<AttributeModifier> iterator = this.a(0).iterator();
        while (iterator.hasNext()) {
            b += iterator.next().d();
        }
        double n = b;
        final Iterator<AttributeModifier> iterator2 = this.a(1).iterator();
        while (iterator2.hasNext()) {
            n += b * iterator2.next().d();
        }
        final Iterator<AttributeModifier> iterator3 = this.a(2).iterator();
        while (iterator3.hasNext()) {
            n *= 1.0 + iterator3.next().d();
        }
        return this.b.a(n);
    }
}
