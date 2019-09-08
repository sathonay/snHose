package net.minecraft.server.v1_7_R4;

public class EnchantmentInfiniteArrows extends Enchantment
{
    public EnchantmentInfiniteArrows(final int i, final int j) {
        super(i, j, EnchantmentSlotType.BOW);
        this.b("arrowInfinite");
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
