package net.minecraft.server.v1_7_R4;

public class ItemSoup extends ItemFood
{
    public ItemSoup(final int n) {
        super(n, false);
        this.e(1);
    }
    
    @Override
    public ItemStack b(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        super.b(itemStack, world, entityHuman);
        return new ItemStack(Items.BOWL);
    }
}
