package net.minecraft.server;

public class ItemExpBottle extends Item
{
    public ItemExpBottle() {
        this.a(CreativeModeTab.f);
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (!entityHuman.abilities.canInstantlyBuild) {
            --itemStack.count;
        }
        world.makeSound(entityHuman, "random.bow", 0.5f, 0.4f / (ItemExpBottle.g.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            world.addEntity(new EntityThrownExpBottle(world, entityHuman));
        }
        return itemStack;
    }
}
