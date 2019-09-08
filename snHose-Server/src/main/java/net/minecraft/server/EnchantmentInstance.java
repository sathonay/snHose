package net.minecraft.server.v1_7_R4;

public class EnchantmentInstance extends WeightedRandomChoice
{
    public final Enchantment enchantment;
    public final int level;
    
    public EnchantmentInstance(final Enchantment enchantment, final int level) {
        super(enchantment.getRandomWeight());
        this.enchantment = enchantment;
        this.level = level;
    }
    
    public EnchantmentInstance(final int n, final int n2) {
        this(Enchantment.byId[n], n2);
    }
}
