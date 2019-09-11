package net.minecraft.server;

public class EnchantmentFire extends Enchantment
{
    protected EnchantmentFire(final int i, final int j) {
        super(i, j, EnchantmentSlotType.WEAPON);
        this.b("fire");
    }
    
    @Override
    public int a(final int n) {
        return 10 + 20 * (n - 1);
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
