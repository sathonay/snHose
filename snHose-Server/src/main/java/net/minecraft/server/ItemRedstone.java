package net.minecraft.server.v1_7_R4;

public class ItemRedstone extends Item
{
    public ItemRedstone() {
        this.a(CreativeModeTab.d);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, int i, int j, int k, final int l, final float n, final float n2, final float n3) {
        if (world.getType(i, j, k) != Blocks.SNOW) {
            if (l == 0) {
                --j;
            }
            if (l == 1) {
                ++j;
            }
            if (l == 2) {
                --k;
            }
            if (l == 3) {
                ++k;
            }
            if (l == 4) {
                --i;
            }
            if (l == 5) {
                ++i;
            }
            if (!world.isEmpty(i, j, k)) {
                return false;
            }
        }
        if (!entityHuman.a(i, j, k, l, itemstack)) {
            return false;
        }
        if (Blocks.REDSTONE_WIRE.canPlace(world, i, j, k)) {
            --itemstack.count;
            world.setTypeUpdate(i, j, k, Blocks.REDSTONE_WIRE);
        }
        return true;
    }
}
