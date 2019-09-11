package net.minecraft.server;

public class ItemGlassBottle extends Item
{
    public ItemGlassBottle() {
        this.a(CreativeModeTab.k);
    }
    
    @Override
    public ItemStack a(final ItemStack itemstack, final World world, final EntityHuman entityHuman) {
        final MovingObjectPosition a = this.a(world, entityHuman, true);
        if (a == null) {
            return itemstack;
        }
        if (a.type == EnumMovingObjectType.BLOCK) {
            final int b = a.b;
            final int c = a.c;
            final int d = a.d;
            if (!world.a(entityHuman, b, c, d)) {
                return itemstack;
            }
            if (!entityHuman.a(b, c, d, a.face, itemstack)) {
                return itemstack;
            }
            if (world.getType(b, c, d).getMaterial() == Material.WATER) {
                --itemstack.count;
                if (itemstack.count <= 0) {
                    return new ItemStack(Items.POTION);
                }
                if (!entityHuman.inventory.pickup(new ItemStack(Items.POTION))) {
                    entityHuman.drop(new ItemStack(Items.POTION, 1, 0), false);
                }
            }
        }
        return itemstack;
    }
}
