package net.minecraft.server.v1_7_R4;

public class EnchantmentFlameArrows extends Enchantment
{
    public EnchantmentFlameArrows(final int i, final int j) {
        super(i, j, EnchantmentSlotType.BOW);
        this.b("arrowFire");
    }
    
    @Override
    public int a(final int n) {
        return 20;
    }
    
    @Override
    public int b(final int n) {
        return 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
