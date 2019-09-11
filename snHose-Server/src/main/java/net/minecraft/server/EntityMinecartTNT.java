package net.minecraft.server;

public class EntityMinecartTNT extends EntityMinecartAbstract
{
    private int fuse;
    
    public EntityMinecartTNT(final World world) {
        super(world);
        this.fuse = -1;
    }
    
    public EntityMinecartTNT(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
        this.fuse = -1;
    }
    
    @Override
    public int m() {
        return 3;
    }
    
    @Override
    public Block o() {
        return Blocks.TNT;
    }
    
    @Override
    public void h() {
        super.h();
        if (this.fuse > 0) {
            --this.fuse;
            this.world.addParticle("smoke", this.locX, this.locY + 0.5, this.locZ, 0.0, 0.0, 0.0);
        }
        else if (this.fuse == 0) {
            this.c(this.motX * this.motX + this.motZ * this.motZ);
        }
        if (this.positionChanged) {
            final double n = this.motX * this.motX + this.motZ * this.motZ;
            if (n >= 0.009999999776482582) {
                this.c(n);
            }
        }
    }
    
    @Override
    public void a(final DamageSource damagesource) {
        super.a(damagesource);
        final double n = this.motX * this.motX + this.motZ * this.motZ;
        if (!damagesource.isExplosion()) {
            this.a(new ItemStack(Blocks.TNT, 1), 0.0f);
        }
        if (damagesource.o() || damagesource.isExplosion() || n >= 0.009999999776482582) {
            this.c(n);
        }
    }
    
    protected void c(final double n) {
        if (!this.world.isStatic) {
            double sqrt = Math.sqrt(n);
            if (sqrt > 5.0) {
                sqrt = 5.0;
            }
            this.world.explode(this, this.locX, this.locY, this.locZ, (float)(4.0 + this.random.nextDouble() * 1.5 * sqrt), true);
            this.die();
        }
    }
    
    @Override
    protected void b(final float f) {
        if (f >= 3.0f) {
            final float n = f / 10.0f;
            this.c(n * n);
        }
        super.b(f);
    }
    
    @Override
    public void a(final int n, final int n2, final int n3, final boolean b) {
        if (b && this.fuse < 0) {
            this.e();
        }
    }
    
    public void e() {
        this.fuse = 80;
        if (!this.world.isStatic) {
            this.world.broadcastEntityEffect(this, (byte)10);
            this.world.makeSound(this, "game.tnt.primed", 1.0f, 1.0f);
        }
    }
    
    public boolean v() {
        return this.fuse > -1;
    }
    
    @Override
    public float a(final Explosion explosion, final World world, final int n, final int j, final int n2, final Block block) {
        if (this.v() && (BlockMinecartTrackAbstract.a(block) || BlockMinecartTrackAbstract.b_(world, n, j + 1, n2))) {
            return 0.0f;
        }
        return super.a(explosion, world, n, j, n2, block);
    }
    
    @Override
    public boolean a(final Explosion explosion, final World world, final int n, final int j, final int n2, final Block block, final float f) {
        return (!this.v() || (!BlockMinecartTrackAbstract.a(block) && !BlockMinecartTrackAbstract.b_(world, n, j + 1, n2))) && super.a(explosion, world, n, j, n2, block, f);
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.hasKeyOfType("TNTFuse", 99)) {
            this.fuse = nbttagcompound.getInt("TNTFuse");
        }
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("TNTFuse", this.fuse);
    }
}
