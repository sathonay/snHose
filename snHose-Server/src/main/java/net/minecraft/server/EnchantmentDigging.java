package net.minecraft.server.v1_7_R4;

public class EnchantmentDigging extends Enchantment
{
    protected EnchantmentDigging(final int i, final int j) {
        super(i, j, EnchantmentSlotType.DIGGER);
        this.b("digging");
    }
    
    @Override
    public int a(final int n) {
        return 1 + 10 * (n - 1);
    }
    
    @Override
    public int b(final int i) {
        return super.a(i) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public boolean canEnchant(final ItemStack itemstack) {
        return itemstack.getItem() == Items.SHEARS || super.canEnchant(itemstack);
    }
}
