package net.minecraft.server.v1_7_R4;

public class ItemSign extends Item
{
    public ItemSign() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, int n, int n2, int n3, final int n4, final float n5, final float n6, final float n7) {
        if (n4 == 0) {
            return false;
        }
        if (!world.getType(n, n2, n3).getMaterial().isBuildable()) {
            return false;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (!entityHuman.a(n, n2, n3, n4, itemstack)) {
            return false;
        }
        if (!Blocks.SIGN_POST.canPlace(world, n, n2, n3)) {
            return false;
        }
        if (world.isStatic) {
            return true;
        }
        if (n4 == 1) {
            world.setTypeAndData(n, n2, n3, Blocks.SIGN_POST, MathHelper.floor((entityHuman.yaw + 180.0f) * 16.0f / 360.0f + 0.5) & 0xF, 3);
        }
        else {
            world.setTypeAndData(n, n2, n3, Blocks.WALL_SIGN, n4, 3);
        }
        --itemstack.count;
        final TileEntitySign tileentity = (TileEntitySign)world.getTileEntity(n, n2, n3);
        if (tileentity != null) {
            entityHuman.a(tileentity);
        }
        return true;
    }
}
