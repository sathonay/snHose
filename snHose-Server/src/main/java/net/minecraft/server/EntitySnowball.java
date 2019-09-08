package net.minecraft.server.v1_7_R4;

public class EntitySnowball extends EntityProjectile
{
    public EntitySnowball(final World world) {
        super(world);
    }
    
    public EntitySnowball(final World world, final EntityLiving entityliving) {
        super(world, entityliving);
    }
    
    public EntitySnowball(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
    }
    
    @Override
    protected void a(final MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.entity != null) {
            int n = 0;
            if (movingObjectPosition.entity instanceof EntityBlaze) {
                n = 3;
            }
            movingObjectPosition.entity.damageEntity(DamageSource.projectile(this, this.getShooter()), n);
        }
        for (int i = 0; i < 8; ++i) {
            this.world.addParticle("snowballpoof", this.locX, this.locY, this.locZ, 0.0, 0.0, 0.0);
        }
        if (!this.world.isStatic) {
            this.die();
        }
    }
}
