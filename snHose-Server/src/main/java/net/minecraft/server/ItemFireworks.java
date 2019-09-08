package net.minecraft.server.v1_7_R4;

public class ItemFireworks extends Item
{
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7) {
        if (!world.isStatic) {
            world.addEntity(new EntityFireworks(world, n + n5, n2 + n6, n3 + n7, itemstack));
            if (!entityHuman.abilities.canInstantlyBuild) {
                --itemstack.count;
            }
            return true;
        }
        return false;
    }
}
