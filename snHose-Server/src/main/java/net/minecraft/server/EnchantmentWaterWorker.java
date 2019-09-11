package net.minecraft.server;

public class EnchantmentWaterWorker extends Enchantment
{
    public EnchantmentWaterWorker(final int i, final int j) {
        super(i, j, EnchantmentSlotType.ARMOR_HEAD);
        this.b("waterWorker");
    }
    
    @Override
    public int a(final int n) {
        return 1;
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + 40;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
