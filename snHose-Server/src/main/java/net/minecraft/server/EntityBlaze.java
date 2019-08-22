package net.minecraft.server;

public class EntityBlaze extends EntityMonster {
    private float bp;
    private int bq;
    private int br;

    public EntityBlaze(final World world) {
        super(world);
        this.bp = 0.5f;
        this.fireProof = true;
        this.b = 10;
    }

    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.e).setValue(6.0);
    }

    @Override
    protected void c() {
        super.c();
        this.datawatcher.a(16, new Byte((byte)0));
    }

    @Override
    protected String t() {
        return "mob.blaze.breathe";
    }

    @Override
    protected String aT() {
        return "mob.blaze.hit";
    }

    @Override
    protected String aU() {
        return "mob.blaze.death";
    }

    @Override
    public float d(final float n) {
        return 1.0f;
    }

    @Override
    public void e() {
        if (!this.world.isStatic) {
            if (this.L()) {
                this.damageEntity(DamageSource.DROWN, 1.0f);
            }
            --this.bq;
            if (this.bq <= 0) {
                this.bq = 100;
                this.bp = 0.5f + (float)this.random.nextGaussian() * 3.0f;
            }
            if (this.bT() != null && this.bT().locY + this.bT().getHeadHeight() > this.locY + this.getHeadHeight() + this.bp) {
                this.motY += (0.30000001192092896 - this.motY) * 0.30000001192092896;
            }
        }
        if (this.random.nextInt(24) == 0) {
            this.world.makeSound(this.locX + 0.5, this.locY + 0.5, this.locZ + 0.5, "fire.fire", 1.0f + this.random.nextFloat(), this.random.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.onGround && this.motY < 0.0) {
            this.motY *= 0.6;
        }
        for (int i = 0; i < 2; ++i) {
            this.world.addParticle("largesmoke", this.locX + (this.random.nextDouble() - 0.5) * this.width, this.locY + this.random.nextDouble() * this.length, this.locZ + (this.random.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0);
        }
        super.e();
    }

    @Override
    protected void a(final Entity entity, final float var0) {
        if (this.attackTicks <= 0 && var0 < 2.0f && entity.boundingBox.e > this.boundingBox.b && entity.boundingBox.b < this.boundingBox.e) {
            this.attackTicks = 20;
            this.n(entity);
        } else if (var0 < 30.0f && this.hasLineOfSight(entity)) {
            final double n = entity.locX - this.locX;
            final double d1 = entity.boundingBox.b + entity.length / 2.0f - (this.locY + this.length / 2.0f);
            final double n2 = entity.locZ - this.locZ;
            if (this.attackTicks == 0) {
                ++this.br;
                if (this.br == 1) {
                    this.attackTicks = 60;
                    this.a(true);
                }
                else if (this.br <= 4) {
                    this.attackTicks = 6;
                }
                else {
                    this.attackTicks = 100;
                    this.br = 0;
                    this.a(false);
                }
                if (this.br > 1) {
                    final float n3 = MathHelper.c(var0) * 0.5f;
                    this.world.a(null, 1009, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
                    for (int i = 0; i < 1; ++i) {
                        final EntitySmallFireball entity2 = new EntitySmallFireball(this.world, this, n + this.random.nextGaussian() * n3, d1, n2 + this.random.nextGaussian() * n3);
                        entity2.locY = this.locY + this.length / 2.0f + 0.5;
                        this.world.addEntity(entity2);
                    }
                }
            }
            this.yaw = (float)(Math.atan2(n2, n) * 180.0 / 3.1415927410125732) - 90.0f;
            this.bn = true;
        }
    }

    @Override
    protected void b(final float n) {
    }

    @Override
    protected Item getLoot() {
        return Items.BLAZE_ROD;
    }

    @Override
    public boolean isBurning() {
        return this.bZ();
    }

    @Override
    protected void dropDeathLoot(final boolean b, final int n) {
        if (b) {
            for (int nextInt = this.random.nextInt(2 + n), i = 0; i < nextInt; ++i) {
                this.a(Items.BLAZE_ROD, 1);
            }
        }
    }

    public boolean bZ() {
        return (this.datawatcher.getByte(16) & 0x1) != 0x0;
    }

    public void a(final boolean b) {
        final byte byte1 = this.datawatcher.getByte(16);
        final byte b2 = (byte) (b ? (byte1 | 0x1) : (byte1 & 0xFFFFFFFE));
        this.datawatcher.watch(16, b2);
    }

    @Override
    protected boolean j_() {
        return true;
    }
}
