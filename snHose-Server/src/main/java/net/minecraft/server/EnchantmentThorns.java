package net.minecraft.server;

import java.util.*;

public class EnchantmentThorns extends Enchantment
{
    public EnchantmentThorns(final int i, final int j) {
        super(i, j, EnchantmentSlotType.ARMOR_TORSO);
        this.b("thorns");
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
        return 3;
    }
    
    @Override
    public boolean canEnchant(final ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemArmor || super.canEnchant(itemstack);
    }
    
    @Override
    public void b(final EntityLiving entityliving, final Entity entity, final int n) {
        final Random ai = entityliving.aI();
        final ItemStack a = EnchantmentManager.a(Enchantment.THORNS, entityliving);
        if (a(n, ai)) {
            entity.damageEntity(DamageSource.a(entityliving), b(n, ai));
            entity.makeSound("damage.thorns", 0.5f, 1.0f);
            if (a != null) {
                a.damage(3, entityliving);
            }
        }
        else if (a != null) {
            a.damage(1, entityliving);
        }
    }
    
    public static boolean a(final int n, final Random random) {
        return n > 0 && random.nextFloat() < 0.15f * n;
    }
    
    public static int b(final int n, final Random random) {
        if (n > 10) {
            return n - 10;
        }
        return 1 + random.nextInt(4);
    }
}
