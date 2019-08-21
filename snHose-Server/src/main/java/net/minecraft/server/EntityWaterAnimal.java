package net.minecraft.server;

public abstract class EntityWaterAnimal extends EntityCreature implements IAnimal
{
    public EntityWaterAnimal(final World world) {
        super(world);
    }

    @Override
    public boolean aE() {
        return true;
    }

    @Override
    public boolean canSpawn() {
        return this.world.b(this.boundingBox);
    }

    @Override
    public int q() {
        return 120;
    }

    @Override
    protected boolean isTypeNotPersistent() {
        return true;
    }

    @Override
    protected int getExpValue(final EntityHuman entityHuman) {
        return 1 + this.world.random.nextInt(3);
    }

    @Override
    public void C() {
        int airTicks = this.getAirTicks();
        super.C();
        if (this.isAlive() && !this.M()) {
            this.setAirTicks(--airTicks);
            if (this.getAirTicks() == -20) {
                this.setAirTicks(0);
                this.damageEntity(DamageSource.DROWN, 2.0f);
            }
        }
        else {
            this.setAirTicks(300);
        }
    }
}
