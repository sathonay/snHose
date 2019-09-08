package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public enum EnumFish
{
    COD("COD", 0, 0, "cod", 2, 0.1f, 5, 0.6f), 
    SALMON("SALMON", 1, 1, "salmon", 2, 0.1f, 6, 0.8f), 
    CLOWNFISH("CLOWNFISH", 2, 2, "clownfish", 1, 0.1f), 
    PUFFERFISH("PUFFERFISH", 3, 3, "pufferfish", 1, 0.1f);
    
    private static final Map e;
    private final int f;
    private final String g;
    private final int j;
    private final float k;
    private final int l;
    private final float m;
    private boolean n;
    
    private EnumFish(final String s, final int n, final int f, final String g, final int j, final float k, final int l, final float m) {
        this.n = false;
        this.f = f;
        this.g = g;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = true;
    }
    
    private EnumFish(final String s, final int n, final int f, final String g, final int j, final float k) {
        this.n = false;
        this.f = f;
        this.g = g;
        this.j = j;
        this.k = k;
        this.l = 0;
        this.m = 0.0f;
        this.n = false;
    }
    
    public int a() {
        return this.f;
    }
    
    public String b() {
        return this.g;
    }
    
    public int c() {
        return this.j;
    }
    
    public float d() {
        return this.k;
    }
    
    public int e() {
        return this.l;
    }
    
    public float f() {
        return this.m;
    }
    
    public boolean i() {
        return this.n;
    }
    
    public static EnumFish a(final int n) {
        final EnumFish enumFish = EnumFish.e.get(n);
        if (enumFish == null) {
            return EnumFish.COD;
        }
        return enumFish;
    }
    
    public static EnumFish a(final ItemStack itemStack) {
        if (itemStack.getItem() instanceof ItemFish) {
            return a(itemStack.getData());
        }
        return EnumFish.COD;
    }
    
    static {
        e = Maps.newHashMap();
        for (final EnumFish enumFish : values()) {
            EnumFish.e.put(enumFish.a(), enumFish);
        }
    }
}
