package net.minecraft.server;

public class EntitySelectorEquipable implements IEntitySelector
{
    private final ItemStack d;
    
    public EntitySelectorEquipable(final ItemStack d) {
        this.d = d;
    }
    
    @Override
    public boolean a(final Entity entity) {
        if (!entity.isAlive()) {
            return false;
        }
        if (!(entity instanceof EntityLiving)) {
            return false;
        }
        final EntityLiving entityLiving = (EntityLiving)entity;
        if (entityLiving.getEquipment(EntityInsentient.b(this.d)) != null) {
            return false;
        }
        if (entityLiving instanceof EntityInsentient) {
            return ((EntityInsentient)entityLiving).bJ();
        }
        return entityLiving instanceof EntityHuman;
    }
}
