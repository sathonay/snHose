package net.minecraft.server;

final class EnchantmentModifierDamage implements EnchantmentModifier
{
    public float a;
    public EnumMonsterType b;
    
    private EnchantmentModifierDamage() {
    }
    
    @Override
    public void a(final Enchantment enchantment, final int i) {
        this.a += enchantment.a(i, this.b);
    }
    
    EnchantmentModifierDamage(final EmptyClass emptyclass) {
        this();
    }
}
