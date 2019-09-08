package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenMineshaft extends StructureGenerator
{
    private double e;
    
    public WorldGenMineshaft() {
        this.e = 0.004;
    }
    
    @Override
    public String a() {
        return "Mineshaft";
    }
    
    public WorldGenMineshaft(final Map map) {
        this.e = 0.004;
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            if (entry.getKey().equals("chance")) {
                this.e = MathHelper.a((String)entry.getValue(), this.e);
            }
        }
    }
    
    @Override
    protected boolean a(final int n, final int n2) {
        return this.b.nextDouble() < this.e && this.b.nextInt(80) < Math.max(Math.abs(n), Math.abs(n2));
    }
    
    @Override
    protected StructureStart b(final int n, final int n2) {
        return new WorldGenMineshaftStart(this.c, this.b, n, n2);
    }
}
