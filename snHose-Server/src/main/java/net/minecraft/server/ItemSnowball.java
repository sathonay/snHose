package net.minecraft.server.v1_7_R4;

public class ItemSnowball extends Item
{
    public ItemSnowball() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.f);
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entity) {
        if (!entity.abilities.canInstantlyBuild) {
            --itemStack.count;
        }
        world.makeSound(entity, "random.bow", 0.5f, 0.4f / (ItemSnowball.g.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            world.addEntity(new EntitySnowball(world, entity));
        }
        return itemStack;
    }
}
