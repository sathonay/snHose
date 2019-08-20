package net.minecraft.server;

public class EntityMinecartFurnace extends EntityMinecartAbstract {
    private int c;
    public double a;
    public double b;

    public EntityMinecartFurnace(final World world) {
        super(world);
    }

    public EntityMinecartFurnace(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
    }

    @Override
    public int m() {
        return 2;
    }

    @Override
    protected void c() {
        super.c();
        this.datawatcher.a(16, new Byte((byte)0));
    }

    @Override
    public void h() {
        super.h();
        if (this.c > 0) {
            --this.c;
        }
        if (this.c <= 0) {
            final double n = 0.0;
            this.b = n;
            this.a = n;
        }
        this.f(this.c > 0);
        if (this.e() && this.random.nextInt(4) == 0) {
            this.world.addParticle("largesmoke", this.locX, this.locY + 0.8, this.locZ, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void a(final DamageSource damagesource) {
        super.a(damagesource);
        if (!damagesource.isExplosion()) {
            this.a(new ItemStack(Blocks.FURNACE, 1), 0.0f);
        }
    }

    @Override
    protected void a(final int i, final int j, final int k, final double d0, final double d2, final Block block, final int l) {
        super.a(i, j, k, d0, d2, block, l);
        final double var0 = this.a * this.a + this.b * this.b;
        if (var0 > 1.0E-4 && this.motX * this.motX + this.motZ * this.motZ > 0.001) {
            final double n = MathHelper.sqrt(var0);
            final double d1 = (double) MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
            this.a = (this.motX / d1) * n;
            this.b = (this.motZ / d1) * n;
        }
    }

    @Override
    protected void i() {
        final double var0 = this.a * this.a + this.b * this.b;
        if (var0 > 1.0E-4) {
            final double n = MathHelper.sqrt(var0);
            this.a /= n;
            this.b /= n;
            final double n2 = 0.05;
            this.motX *= 0.800000011920929;
            this.motY *= 0.0;
            this.motZ *= 0.800000011920929;
            this.motX += this.a * n2;
            this.motZ += this.b * n2;
        }
        else {
            this.motX *= 0.9800000190734863;
            this.motY *= 0.0;
            this.motZ *= 0.9800000190734863;
        }
        super.i();
    }

    @Override
    public boolean c(final EntityHuman entityHuman) {
        final ItemStack itemInHand = entityHuman.inventory.getItemInHand();
        if (itemInHand != null && itemInHand.getItem() == Items.COAL) {
            if (!entityHuman.abilities.canInstantlyBuild) {
                final ItemStack itemStack = itemInHand;
                if (--itemStack.count == 0) {
                    entityHuman.inventory.setItem(entityHuman.inventory.itemInHandIndex, null);
                }
            }
            this.c += 3600;
        }
        this.a = this.locX - entityHuman.locX;
        this.b = this.locZ - entityHuman.locZ;
        return true;
    }

    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setDouble("PushX", this.a);
        nbttagcompound.setDouble("PushZ", this.b);
        nbttagcompound.setShort("Fuel", (short)this.c);
    }

    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.a = nbttagcompound.getDouble("PushX");
        this.b = nbttagcompound.getDouble("PushZ");
        this.c = nbttagcompound.getShort("Fuel");
    }

    protected boolean e() {
        return (this.datawatcher.getByte(16) & 0x1) != 0x0;
    }

    protected void f(final boolean b) {
        this.datawatcher.watch(16, (byte) (b ? (this.datawatcher.getByte(16) | 0x1) : (this.datawatcher.getByte(16) & 0xFFFFFFFE)));
    }

    @Override
    public Block o() {
        return Blocks.BURNING_FURNACE;
    }

    @Override
    public int q() {
        return 2;
    }
}
