package net.minecraft.server;

public class EntityEnderSignal extends Entity
{
    private double a;
    private double b;
    private double c;
    private int d;
    private boolean e;
    
    public EntityEnderSignal(final World world) {
        super(world);
        this.a(0.25f, 0.25f);
    }
    
    @Override
    protected void c() {
    }
    
    public EntityEnderSignal(final World world, final double d0, final double d2, final double d3) {
        super(world);
        this.d = 0;
        this.a(0.25f, 0.25f);
        this.setPosition(d0, d2, d3);
        this.height = 0.0f;
    }
    
    public void a(final double a, final int n, final double c) {
        final double n2 = a - this.locX;
        final double n3 = c - this.locZ;
        final float sqrt = MathHelper.sqrt(n2 * n2 + n3 * n3);
        if (sqrt > 12.0f) {
            this.a = this.locX + n2 / sqrt * 12.0;
            this.c = this.locZ + n3 / sqrt * 12.0;
            this.b = this.locY + 8.0;
        }
        else {
            this.a = a;
            this.b = n;
            this.c = c;
        }
        this.d = 0;
        this.e = (this.random.nextInt(5) > 0);
    }
    
    @Override
    public void h() {
        this.S = this.locX;
        this.T = this.locY;
        this.U = this.locZ;
        super.h();
        this.locX += this.motX;
        this.locY += this.motY;
        this.locZ += this.motZ;
        final float sqrt = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
        this.yaw = (float)(Math.atan2(this.motX, this.motZ) * 180.0 / 3.1415927410125732);
        this.pitch = (float)(Math.atan2(this.motY, sqrt) * 180.0 / 3.1415927410125732);
        while (this.pitch - this.lastPitch < -180.0f) {
            this.lastPitch -= 360.0f;
        }
        while (this.pitch - this.lastPitch >= 180.0f) {
            this.lastPitch += 360.0f;
        }
        while (this.yaw - this.lastYaw < -180.0f) {
            this.lastYaw -= 360.0f;
        }
        while (this.yaw - this.lastYaw >= 180.0f) {
            this.lastYaw += 360.0f;
        }
        this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2f;
        this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2f;
        if (!this.world.isStatic) {
            final double n = this.a - this.locX;
            final double n2 = this.c - this.locZ;
            final float n3 = (float)Math.sqrt(n * n + n2 * n2);
            final float n4 = (float)Math.atan2(n2, n);
            double n5 = sqrt + (n3 - sqrt) * 0.0025;
            if (n3 < 1.0f) {
                n5 *= 0.8;
                this.motY *= 0.8;
            }
            this.motX = Math.cos(n4) * n5;
            this.motZ = Math.sin(n4) * n5;
            this.motY += ((this.locY < this.b ? 1.0 : -1.0) - this.motY) * 0.014999999664723873;
        }
        final float n6 = 0.25f;
        if (this.M()) {
            for (int i = 0; i < 4; ++i) {
                this.world.addParticle("bubble", this.locX - this.motX * n6, this.locY - this.motY * n6, this.locZ - this.motZ * n6, this.motX, this.motY, this.motZ);
            }
        }
        else {
            this.world.addParticle("portal", this.locX - this.motX * n6 + this.random.nextDouble() * 0.6 - 0.3, this.locY - this.motY * n6 - 0.5, this.locZ - this.motZ * n6 + this.random.nextDouble() * 0.6 - 0.3, this.motX, this.motY, this.motZ);
        }
        if (!this.world.isStatic) {
            this.setPosition(this.locX, this.locY, this.locZ);
            ++this.d;
            if (this.d > 80 && !this.world.isStatic) {
                this.die();
                if (this.e) {
                    this.world.addEntity(new EntityItem(this.world, this.locX, this.locY, this.locZ, new ItemStack(Items.EYE_OF_ENDER)));
                }
                else {
                    this.world.triggerEffect(2003, (int)Math.round(this.locX), (int)Math.round(this.locY), (int)Math.round(this.locZ), 0);
                }
            }
        }
    }
    
    public void b(final NBTTagCompound nbtTagCompound) {
    }
    
    public void a(final NBTTagCompound nbtTagCompound) {
    }
    
    @Override
    public float d(final float n) {
        return 1.0f;
    }
    
    @Override
    public boolean av() {
        return false;
    }
}
