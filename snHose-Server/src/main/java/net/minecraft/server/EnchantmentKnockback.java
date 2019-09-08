package net.minecraft.server.v1_7_R4;

public class EnchantmentKnockback extends Enchantment
{
    protected EnchantmentKnockback(final int i, final int j) {
        super(i, j, EnchantmentSlotType.WEAPON);
        this.b("knockback");
    }
    
    @Override
    public int a(final int n) {
        return 5 + 20 * (n - 1);
    }
    
    @Override
    public int b(final int i) {
        return super.a(i) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
