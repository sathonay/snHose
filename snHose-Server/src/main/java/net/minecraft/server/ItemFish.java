package net.minecraft.server;

public class ItemFish extends ItemFood
{
    private final boolean b;
    
    public ItemFish(final boolean b) {
        super(0, 0.0f, false);
        this.b = b;
    }
    
    @Override
    public int getNutrition(final ItemStack itemStack) {
        final EnumFish a = EnumFish.a(itemStack);
        if (this.b && a.i()) {
            return a.e();
        }
        return a.c();
    }
    
    @Override
    public float getSaturationModifier(final ItemStack itemStack) {
        final EnumFish a = EnumFish.a(itemStack);
        if (this.b && a.i()) {
            return a.f();
        }
        return a.d();
    }
    
    @Override
    public String i(final ItemStack itemStack) {
        if (EnumFish.a(itemStack) == EnumFish.PUFFERFISH) {
            return PotionBrewer.m;
        }
        return null;
    }
    
    @Override
    protected void c(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (EnumFish.a(itemStack) == EnumFish.PUFFERFISH) {
            entityHuman.addEffect(new MobEffect(MobEffectList.POISON.id, 1200, 3));
            entityHuman.addEffect(new MobEffect(MobEffectList.HUNGER.id, 300, 2));
            entityHuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 300, 1));
        }
        super.c(itemStack, world, entityHuman);
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        final EnumFish a = EnumFish.a(itemStack);
        return this.getName() + "." + a.b() + "." + ((this.b && a.i()) ? "cooked" : "raw");
    }
}
