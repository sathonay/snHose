package net.minecraft.server.v1_7_R4;

public class MovingObjectPosition
{
    public EnumMovingObjectType type;
    public int b;
    public int c;
    public int d;
    public int face;
    public Vec3D pos;
    public Entity entity;
    
    public MovingObjectPosition(final int n, final int n2, final int n3, final int n4, final Vec3D vec3D) {
        this(n, n2, n3, n4, vec3D, true);
    }
    
    public MovingObjectPosition(final int b, final int c, final int d, final int face, final Vec3D vec3D, final boolean b2) {
        this.type = (b2 ? EnumMovingObjectType.BLOCK : EnumMovingObjectType.MISS);
        this.b = b;
        this.c = c;
        this.d = d;
        this.face = face;
        this.pos = Vec3D.a(vec3D.a, vec3D.b, vec3D.c);
    }
    
    public MovingObjectPosition(final Entity entity) {
        this(entity, Vec3D.a(entity.locX, entity.locY, entity.locZ));
    }
    
    public MovingObjectPosition(final Entity entity, final Vec3D pos) {
        this.type = EnumMovingObjectType.ENTITY;
        this.entity = entity;
        this.pos = pos;
    }
    
    @Override
    public String toString() {
        return "HitResult{type=" + this.type + ", x=" + this.b + ", y=" + this.c + ", z=" + this.d + ", f=" + this.face + ", pos=" + this.pos + ", entity=" + this.entity + '}';
    }
}
