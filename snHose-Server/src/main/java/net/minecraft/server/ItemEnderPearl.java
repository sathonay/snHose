package net.minecraft.server.v1_7_R4;

public class ItemEnderPearl extends Item
{
    public ItemEnderPearl() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.f);
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (entityHuman.abilities.canInstantlyBuild) {
            return itemStack;
        }
        --itemStack.count;
        world.makeSound(entityHuman, "random.bow", 0.5f, 0.4f / (ItemEnderPearl.g.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            world.addEntity(new EntityEnderPearl(world, entityHuman));
        }
        return itemStack;
    }
}
