package net.minecraft.server;

public class ItemEgg extends Item
{
    public ItemEgg() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.l);
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (!entityHuman.abilities.canInstantlyBuild) {
            --itemStack.count;
        }
        world.makeSound(entityHuman, "random.bow", 0.5f, 0.4f / (ItemEgg.g.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            world.addEntity(new EntityEgg(world, entityHuman));
        }
        return itemStack;
    }
}
