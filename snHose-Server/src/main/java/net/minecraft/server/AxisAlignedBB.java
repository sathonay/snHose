package net.minecraft.server;

public class AxisAlignedBB
{
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    
    public static AxisAlignedBB a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        return new AxisAlignedBB(n, n2, n3, n4, n5, n6);
    }
    
    protected AxisAlignedBB(final double a, final double b, final double c, final double d, final double e, final double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public AxisAlignedBB b(final double a, final double b, final double c, final double d, final double e, final double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        return this;
    }
    
    public AxisAlignedBB a(final double n, final double n2, final double n3) {
        double a = this.a;
        double b = this.b;
        double c = this.c;
        double d = this.d;
        double e = this.e;
        double f = this.f;
        if (n < 0.0) {
            a += n;
        }
        if (n > 0.0) {
            d += n;
        }
        if (n2 < 0.0) {
            b += n2;
        }
        if (n2 > 0.0) {
            e += n2;
        }
        if (n3 < 0.0) {
            c += n3;
        }
        if (n3 > 0.0) {
            f += n3;
        }
        return a(a, b, c, d, e, f);
    }
    
    public AxisAlignedBB grow(final double n, final double n2, final double n3) {
        return a(this.a - n, this.b - n2, this.c - n3, this.d + n, this.e + n2, this.f + n3);
    }
    
    public AxisAlignedBB a(final AxisAlignedBB axisAlignedBB) {
        return a(Math.min(this.a, axisAlignedBB.a), Math.min(this.b, axisAlignedBB.b), Math.min(this.c, axisAlignedBB.c), Math.max(this.d, axisAlignedBB.d), Math.max(this.e, axisAlignedBB.e), Math.max(this.f, axisAlignedBB.f));
    }
    
    public AxisAlignedBB c(final double n, final double n2, final double n3) {
        return a(this.a + n, this.b + n2, this.c + n3, this.d + n, this.e + n2, this.f + n3);
    }
    
    public double a(final AxisAlignedBB axisAlignedBB, double n) {
        if (axisAlignedBB.e <= this.b || axisAlignedBB.b >= this.e) {
            return n;
        }
        if (axisAlignedBB.f <= this.c || axisAlignedBB.c >= this.f) {
            return n;
        }
        if (n > 0.0 && axisAlignedBB.d <= this.a) {
            final double n2 = this.a - axisAlignedBB.d;
            if (n2 < n) {
                n = n2;
            }
        }
        if (n < 0.0 && axisAlignedBB.a >= this.d) {
            final double n3 = this.d - axisAlignedBB.a;
            if (n3 > n) {
                n = n3;
            }
        }
        return n;
    }
    
    public double b(final AxisAlignedBB axisAlignedBB, double n) {
        if (axisAlignedBB.d <= this.a || axisAlignedBB.a >= this.d) {
            return n;
        }
        if (axisAlignedBB.f <= this.c || axisAlignedBB.c >= this.f) {
            return n;
        }
        if (n > 0.0 && axisAlignedBB.e <= this.b) {
            final double n2 = this.b - axisAlignedBB.e;
            if (n2 < n) {
                n = n2;
            }
        }
        if (n < 0.0 && axisAlignedBB.b >= this.e) {
            final double n3 = this.e - axisAlignedBB.b;
            if (n3 > n) {
                n = n3;
            }
        }
        return n;
    }
    
    public double c(final AxisAlignedBB axisAlignedBB, double n) {
        if (axisAlignedBB.d <= this.a || axisAlignedBB.a >= this.d) {
            return n;
        }
        if (axisAlignedBB.e <= this.b || axisAlignedBB.b >= this.e) {
            return n;
        }
        if (n > 0.0 && axisAlignedBB.f <= this.c) {
            final double n2 = this.c - axisAlignedBB.f;
            if (n2 < n) {
                n = n2;
            }
        }
        if (n < 0.0 && axisAlignedBB.c >= this.f) {
            final double n3 = this.f - axisAlignedBB.c;
            if (n3 > n) {
                n = n3;
            }
        }
        return n;
    }
    
    public boolean b(final AxisAlignedBB axisAlignedBB) {
        return axisAlignedBB.d > this.a && axisAlignedBB.a < this.d && axisAlignedBB.e > this.b && axisAlignedBB.b < this.e && axisAlignedBB.f > this.c && axisAlignedBB.c < this.f;
    }
    
    public AxisAlignedBB d(final double n, final double n2, final double n3) {
        this.a += n;
        this.b += n2;
        this.c += n3;
        this.d += n;
        this.e += n2;
        this.f += n3;
        return this;
    }
    
    public boolean a(final Vec3D vec3D) {
        return vec3D.a > this.a && vec3D.a < this.d && vec3D.b > this.b && vec3D.b < this.e && vec3D.c > this.c && vec3D.c < this.f;
    }
    
    public double a() {
        return (this.d - this.a + (this.e - this.b) + (this.f - this.c)) / 3.0;
    }
    
    public AxisAlignedBB shrink(final double n, final double n2, final double n3) {
        return a(this.a + n, this.b + n2, this.c + n3, this.d - n, this.e - n2, this.f - n3);
    }
    
    public AxisAlignedBB clone() {
        return a(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    public MovingObjectPosition a(final Vec3D vec3D, final Vec3D vec3D2) {
        Vec3D b = vec3D.b(vec3D2, this.a);
        Vec3D b2 = vec3D.b(vec3D2, this.d);
        Vec3D c = vec3D.c(vec3D2, this.b);
        Vec3D c2 = vec3D.c(vec3D2, this.e);
        Vec3D d = vec3D.d(vec3D2, this.c);
        Vec3D d2 = vec3D.d(vec3D2, this.f);
        if (!this.b(b)) {
            b = null;
        }
        if (!this.b(b2)) {
            b2 = null;
        }
        if (!this.c(c)) {
            c = null;
        }
        if (!this.c(c2)) {
            c2 = null;
        }
        if (!this.d(d)) {
            d = null;
        }
        if (!this.d(d2)) {
            d2 = null;
        }
        Vec3D vec3D3 = null;
        if (b != null && (vec3D3 == null || vec3D.distanceSquared(b) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = b;
        }
        if (b2 != null && (vec3D3 == null || vec3D.distanceSquared(b2) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = b2;
        }
        if (c != null && (vec3D3 == null || vec3D.distanceSquared(c) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = c;
        }
        if (c2 != null && (vec3D3 == null || vec3D.distanceSquared(c2) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = c2;
        }
        if (d != null && (vec3D3 == null || vec3D.distanceSquared(d) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = d;
        }
        if (d2 != null && (vec3D3 == null || vec3D.distanceSquared(d2) < vec3D.distanceSquared(vec3D3))) {
            vec3D3 = d2;
        }
        if (vec3D3 == null) {
            return null;
        }
        int n = -1;
        if (vec3D3 == b) {
            n = 4;
        }
        if (vec3D3 == b2) {
            n = 5;
        }
        if (vec3D3 == c) {
            n = 0;
        }
        if (vec3D3 == c2) {
            n = 1;
        }
        if (vec3D3 == d) {
            n = 2;
        }
        if (vec3D3 == d2) {
            n = 3;
        }
        return new MovingObjectPosition(0, 0, 0, n, vec3D3);
    }
    
    private boolean b(final Vec3D vec3D) {
        return vec3D != null && vec3D.b >= this.b && vec3D.b <= this.e && vec3D.c >= this.c && vec3D.c <= this.f;
    }
    
    private boolean c(final Vec3D vec3D) {
        return vec3D != null && vec3D.a >= this.a && vec3D.a <= this.d && vec3D.c >= this.c && vec3D.c <= this.f;
    }
    
    private boolean d(final Vec3D vec3D) {
        return vec3D != null && vec3D.a >= this.a && vec3D.a <= this.d && vec3D.b >= this.b && vec3D.b <= this.e;
    }
    
    public void d(final AxisAlignedBB axisAlignedBB) {
        this.a = axisAlignedBB.a;
        this.b = axisAlignedBB.b;
        this.c = axisAlignedBB.c;
        this.d = axisAlignedBB.d;
        this.e = axisAlignedBB.e;
        this.f = axisAlignedBB.f;
    }
    
    @Override
    public String toString() {
        return "box[" + this.a + ", " + this.b + ", " + this.c + " -> " + this.d + ", " + this.e + ", " + this.f + "]";
    }
}
