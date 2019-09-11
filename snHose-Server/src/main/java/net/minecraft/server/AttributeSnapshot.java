package net.minecraft.server;

import java.util.*;

public class AttributeSnapshot
{
    private final String b;
    private final double c;
    private final Collection d;
    final /* synthetic */ PacketPlayOutUpdateAttributes a;
    
    public AttributeSnapshot(final PacketPlayOutUpdateAttributes a, final String b, final double c, final Collection d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String a() {
        return this.b;
    }
    
    public double b() {
        return this.c;
    }
    
    public Collection c() {
        return this.d;
    }
}
