package net.minecraft.server.v1_7_R4;

public class EnchantmentArrowKnockback extends Enchantment
{
    public EnchantmentArrowKnockback(final int i, final int j) {
        super(i, j, EnchantmentSlotType.BOW);
        this.b("arrowKnockback");
    }
    
    @Override
    public int a(final int n) {
        return 12 + (n - 1) * 20;
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + 25;
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
