package net.minecraft.server;

public class EnchantmentOxygen extends Enchantment
{
    public EnchantmentOxygen(final int i, final int j) {
        super(i, j, EnchantmentSlotType.ARMOR_HEAD);
        this.b("oxygen");
    }
    
    @Override
    public int a(final int n) {
        return 10 * n;
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + 30;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
}
