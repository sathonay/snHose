package net.minecraft.server.v1_7_R4;

import java.util.*;

public class EntityBat extends EntityAmbient
{
    private ChunkCoordinates h;
    
    public EntityBat(final World world) {
        super(world);
        this.a(0.5f, 0.9f);
        this.setAsleep(true);
    }
    
    @Override
    protected void c() {
        super.c();
        this.datawatcher.a(16, new Byte((byte)0));
    }
    
    @Override
    protected float bf() {
        return 0.1f;
    }
    
    @Override
    protected float bg() {
        return super.bg() * 0.95f;
    }
    
    @Override
    protected String t() {
        if (this.isAsleep() && this.random.nextInt(4) != 0) {
            return null;
        }
        return "mob.bat.idle";
    }
    
    @Override
    protected String aT() {
        return "mob.bat.hurt";
    }
    
    @Override
    protected String aU() {
        return "mob.bat.death";
    }
    
    @Override
    public boolean S() {
        return false;
    }
    
    @Override
    protected void o(final Entity entity) {
    }
    
    @Override
    protected void bo() {
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(6.0);
    }
    
    public boolean isAsleep() {
        return (this.datawatcher.getByte(16) & 0x1) != 0x0;
    }
    
    public void setAsleep(final boolean b) {
        final byte byte1 = this.datawatcher.getByte(16);
        if (b) {
            this.datawatcher.watch(16, (byte)(byte1 | 0x1));
        }
        else {
            this.datawatcher.watch(16, (byte)(byte1 & 0xFFFFFFFE));
        }
    }
    
    @Override
    protected boolean bk() {
        return true;
    }
    
    @Override
    public void h() {
        super.h();
        if (this.isAsleep()) {
            final double motX = 0.0;
            this.motZ = motX;
            this.motY = motX;
            this.motX = motX;
            this.locY = MathHelper.floor(this.locY) + 1.0 - this.length;
        }
        else {
            this.motY *= 0.6000000238418579;
        }
    }
    
    @Override
    protected void bn() {
        super.bn();
        if (this.isAsleep()) {
            if (!this.world.getType(MathHelper.floor(this.locX), (int)this.locY + 1, MathHelper.floor(this.locZ)).r()) {
                this.setAsleep(false);
                this.world.a(null, 1015, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
            }
            else {
                if (this.random.nextInt(200) == 0) {
                    this.aO = this.random.nextInt(360);
                }
                if (this.world.findNearbyPlayer(this, 4.0) != null) {
                    this.setAsleep(false);
                    this.world.a(null, 1015, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
                }
            }
        }
        else {
            if (this.h != null && (!this.world.isEmpty(this.h.x, this.h.y, this.h.z) || this.h.y < 1)) {
                this.h = null;
            }
            if (this.h == null || this.random.nextInt(30) == 0 || this.h.e((int)this.locX, (int)this.locY, (int)this.locZ) < 4.0f) {
                this.h = new ChunkCoordinates((int)this.locX + this.random.nextInt(7) - this.random.nextInt(7), (int)this.locY + this.random.nextInt(6) - 2, (int)this.locZ + this.random.nextInt(7) - this.random.nextInt(7));
            }
            final double n = this.h.x + 0.5 - this.locX;
            final double n2 = this.h.y + 0.1 - this.locY;
            final double n3 = this.h.z + 0.5 - this.locZ;
            this.motX += (Math.signum(n) * 0.5 - this.motX) * 0.10000000149011612;
            this.motY += (Math.signum(n2) * 0.699999988079071 - this.motY) * 0.10000000149011612;
            this.motZ += (Math.signum(n3) * 0.5 - this.motZ) * 0.10000000149011612;
            final float g = MathHelper.g((float)(Math.atan2(this.motZ, this.motX) * 180.0 / 3.1415927410125732) - 90.0f - this.yaw);
            this.be = 0.5f;
            this.yaw += g;
            if (this.random.nextInt(100) == 0 && this.world.getType(MathHelper.floor(this.locX), (int)this.locY + 1, MathHelper.floor(this.locZ)).r()) {
                this.setAsleep(true);
            }
        }
    }
    
    @Override
    protected boolean g_() {
        return false;
    }
    
    @Override
    protected void b(final float n) {
    }
    
    @Override
    protected void a(final double n, final boolean b) {
    }
    
    @Override
    public boolean az() {
        return true;
    }
    
    @Override
    public boolean damageEntity(final DamageSource damagesource, final float f) {
        if (this.isInvulnerable()) {
            return false;
        }
        if (!this.world.isStatic && this.isAsleep()) {
            this.setAsleep(false);
        }
        return super.damageEntity(damagesource, f);
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.datawatcher.watch(16, nbttagcompound.getByte("BatFlags"));
    }
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setByte("BatFlags", this.datawatcher.getByte(16));
    }
    
    @Override
    public boolean canSpawn() {
        final int floor = MathHelper.floor(this.boundingBox.b);
        if (floor >= 63) {
            return false;
        }
        final int lightLevel = this.world.getLightLevel(MathHelper.floor(this.locX), floor, MathHelper.floor(this.locZ));
        int n = 4;
        final Calendar v = this.world.V();
        if ((v.get(2) + 1 == 10 && v.get(5) >= 20) || (v.get(2) + 1 == 11 && v.get(5) <= 3)) {
            n = 7;
        }
        else if (this.random.nextBoolean()) {
            return false;
        }
        return lightLevel <= this.random.nextInt(n) && super.canSpawn();
    }
}
