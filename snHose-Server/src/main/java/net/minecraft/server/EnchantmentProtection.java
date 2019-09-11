package net.minecraft.server;

public class EnchantmentProtection extends Enchantment
{
    private static final String[] E;
    private static final int[] F;
    private static final int[] G;
    private static final int[] H;
    public final int a;
    
    public EnchantmentProtection(final int i, final int j, final int a) {
        super(i, j, EnchantmentSlotType.ARMOR);
        this.a = a;
        if (a == 2) {
            this.slot = EnchantmentSlotType.ARMOR_FEET;
        }
    }
    
    @Override
    public int a(final int n) {
        return EnchantmentProtection.F[this.a] + (n - 1) * EnchantmentProtection.G[this.a];
    }
    
    @Override
    public int b(final int n) {
        return this.a(n) + EnchantmentProtection.H[this.a];
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }
    
    @Override
    public int a(final int n, final DamageSource damageSource) {
        if (damageSource.ignoresInvulnerability()) {
            return 0;
        }
        final float n2 = (6 + n * n) / 3.0f;
        if (this.a == 0) {
            return MathHelper.d(n2 * 0.75f);
        }
        if (this.a == 1 && damageSource.o()) {
            return MathHelper.d(n2 * 1.25f);
        }
        if (this.a == 2 && damageSource == DamageSource.FALL) {
            return MathHelper.d(n2 * 2.5f);
        }
        if (this.a == 3 && damageSource.isExplosion()) {
            return MathHelper.d(n2 * 1.5f);
        }
        if (this.a == 4 && damageSource.a()) {
            return MathHelper.d(n2 * 1.5f);
        }
        return 0;
    }
    
    @Override
    public String a() {
        return "enchantment.protect." + EnchantmentProtection.E[this.a];
    }
    
    @Override
    public boolean a(final Enchantment enchantment) {
        if (enchantment instanceof EnchantmentProtection) {
            final EnchantmentProtection enchantmentProtection = (EnchantmentProtection)enchantment;
            return enchantmentProtection.a != this.a && (this.a == 2 || enchantmentProtection.a == 2);
        }
        return super.a(enchantment);
    }
    
    public static int a(final Entity entity, int n) {
        final int enchantmentLevel = EnchantmentManager.getEnchantmentLevel(Enchantment.PROTECTION_FIRE.id, entity.getEquipment());
        if (enchantmentLevel > 0) {
            n -= MathHelper.d(n * (enchantmentLevel * 0.15f));
        }
        return n;
    }
    
    public static double a(final Entity entity, double n) {
        final int enchantmentLevel = EnchantmentManager.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS.id, entity.getEquipment());
        if (enchantmentLevel > 0) {
            n -= MathHelper.floor(n * (enchantmentLevel * 0.15f));
        }
        return n;
    }
    
    static {
        E = new String[] { "all", "fire", "fall", "explosion", "projectile" };
        F = new int[] { 1, 10, 5, 5, 3 };
        G = new int[] { 11, 8, 6, 8, 6 };
        H = new int[] { 20, 12, 10, 12, 15 };
    }
}
