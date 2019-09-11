package net.minecraft.server;

public class ItemSaddle extends Item
{
    public ItemSaddle() {
        this.maxStackSize = 1;
        this.a(CreativeModeTab.e);
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final EntityHuman entityHuman, final EntityLiving entityLiving) {
        if (entityLiving instanceof EntityPig) {
            final EntityPig entity = (EntityPig)entityLiving;
            if (!entity.hasSaddle() && !entity.isBaby()) {
                entity.setSaddle(true);
                entity.world.makeSound(entity, "mob.horse.leather", 0.5f, 1.0f);
                --itemStack.count;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final EntityLiving entityLiving, final EntityLiving entityLiving2) {
        this.a(itemStack, null, entityLiving);
        return true;
    }
}
