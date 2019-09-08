package net.minecraft.server.v1_7_R4;

public class EntityAIBodyControl
{
    private EntityLiving entity;
    private int b;
    private float c;
    
    public EntityAIBodyControl(final EntityLiving entity) {
        this.entity = entity;
    }
    
    public void a() {
        final double n = this.entity.locX - this.entity.lastX;
        final double n2 = this.entity.locZ - this.entity.lastZ;
        if (n * n + n2 * n2 > 2.500000277905201E-7) {
            this.entity.aM = this.entity.yaw;
            this.entity.aO = this.a(this.entity.aM, this.entity.aO, 75.0f);
            this.c = this.entity.aO;
            this.b = 0;
            return;
        }
        float n3 = 75.0f;
        if (Math.abs(this.entity.aO - this.c) > 15.0f) {
            this.b = 0;
            this.c = this.entity.aO;
        }
        else {
            ++this.b;
            if (this.b > 10) {
                n3 = Math.max(1.0f - (this.b - 10) / 10.0f, 0.0f) * 75.0f;
            }
        }
        this.entity.aM = this.a(this.entity.aO, this.entity.aM, n3);
    }
    
    private float a(final float n, final float n2, final float n3) {
        float g = MathHelper.g(n - n2);
        if (g < -n3) {
            g = -n3;
        }
        if (g >= n3) {
            g = n3;
        }
        return n - g;
    }
}
