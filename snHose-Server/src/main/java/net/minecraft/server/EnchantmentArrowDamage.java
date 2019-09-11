package net.minecraft.server;

public class EnchantmentArrowDamage extends Enchantment
{
    public EnchantmentArrowDamage(final int i, final int j) {
        super(i, j, EnchantmentSlotType.BOW);
        this.b("arrowDamage");
    }
    
    @Override
    public int a(final int n) {
        return 1 + (n - 1) * 10;
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
