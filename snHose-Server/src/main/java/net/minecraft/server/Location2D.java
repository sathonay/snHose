package net.minecraft.server.v1_7_R4;

import java.util.*;

class Location2D
{
    double a;
    double b;
    
    Location2D() {
    }
    
    Location2D(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    double a(final Location2D location2D) {
        final double n = this.a - location2D.a;
        final double n2 = this.b - location2D.b;
        return Math.sqrt(n * n + n2 * n2);
    }
    
    void a() {
        final double n = this.b();
        this.a /= n;
        this.b /= n;
    }
    
    float b() {
        return MathHelper.sqrt(this.a * this.a + this.b * this.b);
    }
    
    public void b(final Location2D location2D) {
        this.a -= location2D.a;
        this.b -= location2D.b;
    }
    
    public boolean a(final double a, final double b, final double a2, final double b2) {
        boolean b3 = false;
        if (this.a < a) {
            this.a = a;
            b3 = true;
        }
        else if (this.a > a2) {
            this.a = a2;
            b3 = true;
        }
        if (this.b < b) {
            this.b = b;
            b3 = true;
        }
        else if (this.b > b2) {
            this.b = b2;
            b3 = true;
        }
        return b3;
    }
    
    public int a(final World world) {
        final int floor = MathHelper.floor(this.a);
        final int floor2 = MathHelper.floor(this.b);
        for (int i = 256; i > 0; --i) {
            if (world.getType(floor, i, floor2).getMaterial() != Material.AIR) {
                return i + 1;
            }
        }
        return 257;
    }
    
    public boolean b(final World world) {
        final int floor = MathHelper.floor(this.a);
        final int floor2 = MathHelper.floor(this.b);
        final int j = 256;
        if (j > 0) {
            final Material material = world.getType(floor, j, floor2).getMaterial();
            return !material.isLiquid() && material != Material.FIRE;
        }
        return false;
    }
    
    public void a(final Random random, final double var1, final double var2, final double var3, final double var4) {
        this.a = MathHelper.a(random, var1, var3);
        this.b = MathHelper.a(random, var2, var4);
    }
}
