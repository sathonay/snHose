package net.minecraft.server.v1_7_R4;

public class MobEffectHealthBoost extends MobEffectList
{
    public MobEffectHealthBoost(final int i, final boolean flag, final int j) {
        super(i, flag, j);
    }
    
    @Override
    public void a(final EntityLiving entityliving, final AttributeMapBase attributemapbase, final int i) {
        super.a(entityliving, attributemapbase, i);
        if (entityliving.getHealth() > entityliving.getMaxHealth()) {
            entityliving.setHealth(entityliving.getMaxHealth());
        }
    }
}
