package net.minecraft.server.v1_7_R4;

public class Vec3D
{
    public double a;
    public double b;
    public double c;
    
    public static Vec3D a(final double n, final double n2, final double n3) {
        return new Vec3D(n, n2, n3);
    }
    
    protected Vec3D(double a, double b, double c) {
        if (a == -0.0) {
            a = 0.0;
        }
        if (b == -0.0) {
            b = 0.0;
        }
        if (c == -0.0) {
            c = 0.0;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    protected Vec3D b(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        return this;
    }
    
    public Vec3D a() {
        final double n = MathHelper.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
        if (n < 1.0E-4) {
            return a(0.0, 0.0, 0.0);
        }
        return a(this.a / n, this.b / n, this.c / n);
    }
    
    public double b(final Vec3D vec3D) {
        return this.a * vec3D.a + this.b * vec3D.b + this.c * vec3D.c;
    }
    
    public Vec3D add(final double n, final double n2, final double n3) {
        return a(this.a + n, this.b + n2, this.c + n3);
    }
    
    public double d(final Vec3D vec3D) {
        final double n = vec3D.a - this.a;
        final double n2 = vec3D.b - this.b;
        final double n3 = vec3D.c - this.c;
        return MathHelper.sqrt(n * n + n2 * n2 + n3 * n3);
    }
    
    public double distanceSquared(final Vec3D vec3D) {
        final double n = vec3D.a - this.a;
        final double n2 = vec3D.b - this.b;
        final double n3 = vec3D.c - this.c;
        return n * n + n2 * n2 + n3 * n3;
    }
    
    public double d(final double n, final double n2, final double n3) {
        final double n4 = n - this.a;
        final double n5 = n2 - this.b;
        final double n6 = n3 - this.c;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }
    
    public double b() {
        return MathHelper.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    }
    
    public Vec3D b(final Vec3D vec3D, final double n) {
        final double n2 = vec3D.a - this.a;
        final double n3 = vec3D.b - this.b;
        final double n4 = vec3D.c - this.c;
        if (n2 * n2 < 1.0000000116860974E-7) {
            return null;
        }
        final double n5 = (n - this.a) / n2;
        if (n5 < 0.0 || n5 > 1.0) {
            return null;
        }
        return a(this.a + n2 * n5, this.b + n3 * n5, this.c + n4 * n5);
    }
    
    public Vec3D c(final Vec3D vec3D, final double n) {
        final double n2 = vec3D.a - this.a;
        final double n3 = vec3D.b - this.b;
        final double n4 = vec3D.c - this.c;
        if (n3 * n3 < 1.0000000116860974E-7) {
            return null;
        }
        final double n5 = (n - this.b) / n3;
        if (n5 < 0.0 || n5 > 1.0) {
            return null;
        }
        return a(this.a + n2 * n5, this.b + n3 * n5, this.c + n4 * n5);
    }
    
    public Vec3D d(final Vec3D vec3D, final double n) {
        final double n2 = vec3D.a - this.a;
        final double n3 = vec3D.b - this.b;
        final double n4 = vec3D.c - this.c;
        if (n4 * n4 < 1.0000000116860974E-7) {
            return null;
        }
        final double n5 = (n - this.c) / n4;
        if (n5 < 0.0 || n5 > 1.0) {
            return null;
        }
        return a(this.a + n2 * n5, this.b + n3 * n5, this.c + n4 * n5);
    }
    
    @Override
    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }
    
    public void a(final float n) {
        final float cos = MathHelper.cos(n);
        final float sin = MathHelper.sin(n);
        this.b(this.a, this.b * cos + this.c * sin, this.c * cos - this.b * sin);
    }
    
    public void b(final float n) {
        final float cos = MathHelper.cos(n);
        final float sin = MathHelper.sin(n);
        this.b(this.a * cos + this.c * sin, this.b, this.c * cos - this.a * sin);
    }
}
