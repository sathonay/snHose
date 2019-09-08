package net.minecraft.server.v1_7_R4;

public class ItemBed extends Item
{
    public ItemBed() {
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemStack, final EntityHuman entityHuman, final World world, final int i, int j, final int k, final int n, final float n2, final float n3, final float n4) {
        if (world.isStatic) {
            return true;
        }
        if (n != 1) {
            return false;
        }
        ++j;
        final BlockBed blockBed = (BlockBed)Blocks.BED;
        final int l = MathHelper.floor(entityHuman.yaw * 4.0f / 360.0f + 0.5) & 0x3;
        int n5 = 0;
        int n6 = 0;
        if (l == 0) {
            n6 = 1;
        }
        if (l == 1) {
            n5 = -1;
        }
        if (l == 2) {
            n6 = -1;
        }
        if (l == 3) {
            n5 = 1;
        }
        if (!entityHuman.a(i, j, k, n, itemStack) || !entityHuman.a(i + n5, j, k + n6, n, itemStack)) {
            return false;
        }
        if (world.isEmpty(i, j, k) && world.isEmpty(i + n5, j, k + n6) && World.a(world, i, j - 1, k) && World.a(world, i + n5, j - 1, k + n6)) {
            world.setTypeAndData(i, j, k, blockBed, l, 3);
            if (world.getType(i, j, k) == blockBed) {
                world.setTypeAndData(i + n5, j, k + n6, blockBed, l + 8, 3);
            }
            --itemStack.count;
            return true;
        }
        return false;
    }
}
