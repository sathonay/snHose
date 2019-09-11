package net.minecraft.server;

public abstract class EntityFlying extends EntityInsentient
{
    public EntityFlying(final World world) {
        super(world);
    }
    
    @Override
    protected void b(final float n) {
    }
    
    @Override
    protected void a(final double n, final boolean b) {
    }
    
    @Override
    public void e(final float f, final float f2) {
        if (this.M()) {
            this.a(f, f2, 0.02f);
            this.move(this.motX, this.motY, this.motZ);
            this.motX *= 0.800000011920929;
            this.motY *= 0.800000011920929;
            this.motZ *= 0.800000011920929;
        }
        else if (this.P()) {
            this.a(f, f2, 0.02f);
            this.move(this.motX, this.motY, this.motZ);
            this.motX *= 0.5;
            this.motY *= 0.5;
            this.motZ *= 0.5;
        }
        else {
            float n = 0.91f;
            if (this.onGround) {
                n = this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.boundingBox.b) - 1, MathHelper.floor(this.locZ)).frictionFactor * 0.91f;
            }
            final float n2 = 0.16277136f / (n * n * n);
            this.a(f, f2, this.onGround ? (0.1f * n2) : 0.02f);
            float n3 = 0.91f;
            if (this.onGround) {
                n3 = this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.boundingBox.b) - 1, MathHelper.floor(this.locZ)).frictionFactor * 0.91f;
            }
            this.move(this.motX, this.motY, this.motZ);
            this.motX *= n3;
            this.motY *= n3;
            this.motZ *= n3;
        }
        this.aE = this.aF;
        final double n4 = this.locX - this.lastX;
        final double n5 = this.locZ - this.lastZ;
        float n6 = MathHelper.sqrt(n4 * n4 + n5 * n5) * 4.0f;
        if (n6 > 1.0f) {
            n6 = 1.0f;
        }
        this.aF += (n6 - this.aF) * 0.4f;
        this.aG += this.aF;
    }
    
    @Override
    public boolean h_() {
        return false;
    }
}
