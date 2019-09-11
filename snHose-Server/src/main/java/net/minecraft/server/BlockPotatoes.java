package net.minecraft.server;

public class BlockPotatoes extends BlockCrops
{
    @Override
    protected Item i() {
        return Items.POTATO;
    }
    
    @Override
    protected Item P() {
        return Items.POTATO;
    }
    
    @Override
    public void dropNaturally(final World world, final int n, final int n2, final int n3, final int l, final float f, final int i1) {
        super.dropNaturally(world, n, n2, n3, l, f, i1);
        if (world.isStatic) {
            return;
        }
        if (l >= 7 && world.random.nextInt(50) == 0) {
            this.a(world, n, n2, n3, new ItemStack(Items.POTATO_POISON));
        }
    }
}
