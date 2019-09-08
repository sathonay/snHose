package net.minecraft.server.v1_7_R4;

public class EnchantmentLure extends Enchantment
{
    protected EnchantmentLure(final int i, final int j, final EnchantmentSlotType enchantmentslottype) {
        super(i, j, enchantmentslottype);
        this.b("fishingSpeed");
    }
    
    @Override
    public int a(final int n) {
        return 15 + (n - 1) * 9;
    }
    
    @Override
    public int b(final int i) {
        return super.a(i) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
}
