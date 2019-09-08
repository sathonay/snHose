package net.minecraft.server.v1_7_R4;

public class ItemGoldenApple extends ItemFood
{
    public ItemGoldenApple(final int n, final float n2, final boolean b) {
        super(n, n2, b);
        this.a(true);
    }
    
    @Override
    public EnumItemRarity f(final ItemStack itemStack) {
        if (itemStack.getData() == 0) {
            return EnumItemRarity.RARE;
        }
        return EnumItemRarity.EPIC;
    }
    
    @Override
    protected void c(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (!world.isStatic) {
            entityHuman.addEffect(new MobEffect(MobEffectList.ABSORPTION.id, 2400, 0));
        }
        if (itemStack.getData() > 0) {
            if (!world.isStatic) {
                entityHuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 600, 4));
                entityHuman.addEffect(new MobEffect(MobEffectList.RESISTANCE.id, 6000, 0));
                entityHuman.addEffect(new MobEffect(MobEffectList.FIRE_RESISTANCE.id, 6000, 0));
            }
        }
        else {
            super.c(itemStack, world, entityHuman);
        }
    }
}
