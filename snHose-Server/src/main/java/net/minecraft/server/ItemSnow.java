package net.minecraft.server;

public class ItemSnow extends ItemBlockWithAuxData
{
    public ItemSnow(final Block block, final Block block2) {
        super(block, block2);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemStack, final EntityHuman entityHuman, final World world, final int n, final int n2, final int n3, final int n4, final float f, final float f2, final float f3) {
        if (itemStack.count == 0) {
            return false;
        }
        if (!entityHuman.a(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (world.getType(n, n2, n3) == Blocks.SNOW) {
            final int data = world.getData(n, n2, n3);
            final int n5 = data & 0x7;
            if (n5 <= 6 && world.b(this.block.a(world, n, n2, n3)) && world.setData(n, n2, n3, n5 + 1 | (data & 0xFFFFFFF8), 2)) {
                world.makeSound(n + 0.5f, n2 + 0.5f, n3 + 0.5f, this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume1() + 1.0f) / 2.0f, this.block.stepSound.getVolume2() * 0.8f);
                --itemStack.count;
                return true;
            }
        }
        return super.interactWith(itemStack, entityHuman, world, n, n2, n3, n4, f, f2, f3);
    }
}
