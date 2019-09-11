package net.minecraft.server;

public class PathEntity
{
    private final PathPoint[] a;
    private int b;
    private int c;
    
    public PathEntity(final PathPoint[] a) {
        this.a = a;
        this.c = a.length;
    }
    
    public void a() {
        ++this.b;
    }
    
    public boolean b() {
        return this.b >= this.c;
    }
    
    public PathPoint c() {
        if (this.c > 0) {
            return this.a[this.c - 1];
        }
        return null;
    }
    
    public PathPoint a(final int n) {
        return this.a[n];
    }
    
    public int d() {
        return this.c;
    }
    
    public void b(final int c) {
        this.c = c;
    }
    
    public int e() {
        return this.b;
    }
    
    public void c(final int b) {
        this.b = b;
    }
    
    public Vec3D a(final Entity entity, final int n) {
        return Vec3D.a(this.a[n].a + (int)(entity.width + 1.0f) * 0.5, this.a[n].b, this.a[n].c + (int)(entity.width + 1.0f) * 0.5);
    }
    
    public Vec3D a(final Entity entity) {
        return this.a(entity, this.b);
    }
    
    public boolean a(final PathEntity pathEntity) {
        if (pathEntity == null) {
            return false;
        }
        if (pathEntity.a.length != this.a.length) {
            return false;
        }
        for (int i = 0; i < this.a.length; ++i) {
            if (this.a[i].a != pathEntity.a[i].a || this.a[i].b != pathEntity.a[i].b || this.a[i].c != pathEntity.a[i].c) {
                return false;
            }
        }
        return true;
    }
    
    public boolean b(final Vec3D vec3D) {
        final PathPoint c = this.c();
        return c != null && c.a == (int)vec3D.a && c.c == (int)vec3D.c;
    }
}
