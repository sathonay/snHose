package net.minecraft.server;

public class EnchantmentLootBonus extends Enchantment
{
    protected EnchantmentLootBonus(final int i, final int j, final EnchantmentSlotType enchantmentslottype) {
        super(i, j, enchantmentslottype);
        if (enchantmentslottype == EnchantmentSlotType.DIGGER) {
            this.b("lootBonusDigger");
        }
        else if (enchantmentslottype == EnchantmentSlotType.FISHING_ROD) {
            this.b("lootBonusFishing");
        }
        else {
            this.b("lootBonus");
        }
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
    
    @Override
    public boolean a(final Enchantment enchantment) {
        return super.a(enchantment) && enchantment.id != EnchantmentLootBonus.SILK_TOUCH.id;
    }
}
