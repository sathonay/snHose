package net.minecraft.server;

import java.util.*;
import net.minecraft.util.org.apache.commons.lang3.*;

public class AttributeModifier
{
    private final double a;
    private final int b;
    private final String c;
    private final UUID d;
    private boolean e;
    
    public AttributeModifier(final String s, final double n, final int n2) {
        this(UUID.randomUUID(), s, n, n2);
    }
    
    public AttributeModifier(final UUID d, final String s, final double a, final int b) {
        this.e = true;
        this.d = d;
        this.c = s;
        this.a = a;
        this.b = b;
        Validate.notEmpty(s, "Modifier name cannot be empty", new Object[0]);
        Validate.inclusiveBetween(0, 2, b, "Invalid operation", new Object[0]);
    }
    
    public UUID a() {
        return this.d;
    }
    
    public String b() {
        return this.c;
    }
    
    public int c() {
        return this.b;
    }
    
    public double d() {
        return this.a;
    }
    
    public boolean e() {
        return this.e;
    }
    
    public AttributeModifier a(final boolean e) {
        this.e = e;
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final AttributeModifier attributeModifier = (AttributeModifier)o;
        if (this.d != null) {
            if (this.d.equals(attributeModifier.d)) {
                return true;
            }
        }
        else if (attributeModifier.d == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.d != null) ? this.d.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "AttributeModifier{amount=" + this.a + ", operation=" + this.b + ", name='" + this.c + '\'' + ", id=" + this.d + ", serialize=" + this.e + '}';
    }
}
