package net.minecraft.server;

public class EnchantmentSilkTouch extends Enchantment
{
    protected EnchantmentSilkTouch(final int i, final int j) {
        super(i, j, EnchantmentSlotType.DIGGER);
        this.b("untouching");
    }
    
    @Override
    public int a(final int n) {
        return 15;
    }
    
    @Override
    public int b(final int i) {
        return super.a(i) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public boolean a(final Enchantment enchantment) {
        return super.a(enchantment) && enchantment.id != EnchantmentSilkTouch.LOOT_BONUS_BLOCKS.id;
    }
    
    @Override
    public boolean canEnchant(final ItemStack itemstack) {
        return itemstack.getItem() == Items.SHEARS || super.canEnchant(itemstack);
    }
}
