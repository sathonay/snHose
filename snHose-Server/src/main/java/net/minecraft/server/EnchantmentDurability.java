package net.minecraft.server;

import java.util.*;

public class EnchantmentDurability extends Enchantment
{
    protected EnchantmentDurability(final int i, final int j) {
        super(i, j, EnchantmentSlotType.BREAKABLE);
        this.b("durability");
    }
    
    @Override
    public int a(final int n) {
        return 5 + (n - 1) * 8;
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
    public boolean canEnchant(final ItemStack itemstack) {
        return itemstack.g() || super.canEnchant(itemstack);
    }
    
    public static boolean a(final ItemStack itemStack, final int n, final Random random) {
        return (!(itemStack.getItem() instanceof ItemArmor) || random.nextFloat() >= 0.6f) && random.nextInt(n + 1) > 0;
    }
}
