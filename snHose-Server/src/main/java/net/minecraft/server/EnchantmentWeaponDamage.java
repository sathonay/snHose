package net.minecraft.server;

public class EnchantmentWeaponDamage extends Enchantment
{
    private static final String[] E;
    private static final int[] F;
    private static final int[] G;
    private static final int[] H;
    public final int a;
    
    public EnchantmentWeaponDamage(final int i, final int j, final int a) {
        super(i, j, EnchantmentSlotType.WEAPON);
        this.a = a;
    }
    
    @Override
    public int a(final int n) {
        return EnchantmentWeaponDamage.F[this.a] + (n - 1) * EnchantmentWeaponDamage.G[this.a];
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + EnchantmentWeaponDamage.H[this.a];
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public float a(final int n, final EnumMonsterType enumMonsterType) {
        if (this.a == 0) {
            return n * 1.25f;
        }
        if (this.a == 1 && enumMonsterType == EnumMonsterType.UNDEAD) {
            return n * 2.5f;
        }
        if (this.a == 2 && enumMonsterType == EnumMonsterType.ARTHROPOD) {
            return n * 2.5f;
        }
        return 0.0f;
    }
    
    @Override
    public String a() {
        return "enchantment.damage." + EnchantmentWeaponDamage.E[this.a];
    }
    
    @Override
    public boolean a(final Enchantment enchantment) {
        return !(enchantment instanceof EnchantmentWeaponDamage);
    }
    
    @Override
    public boolean canEnchant(final ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemAxe || super.canEnchant(itemstack);
    }
    
    @Override
    public void a(final EntityLiving entityLiving, final Entity entity, final int n) {
        if (entity instanceof EntityLiving) {
            final EntityLiving entityLiving2 = (EntityLiving)entity;
            if (this.a == 2 && entityLiving2.getMonsterType() == EnumMonsterType.ARTHROPOD) {
                entityLiving2.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT.id, 20 + entityLiving.aI().nextInt(10 * n), 3));
            }
        }
    }
    
    static {
        E = new String[] { "all", "undead", "arthropods" };
        F = new int[] { 1, 5, 5 };
        G = new int[] { 11, 8, 8 };
        H = new int[] { 20, 20, 20 };
    }
}
