package net.minecraft.server.v1_7_R4;

public class MobEffectAbsorption extends MobEffectList
{
    protected MobEffectAbsorption(final int i, final boolean flag, final int j) {
        super(i, flag, j);
    }
    
    @Override
    public void a(final EntityLiving entityliving, final AttributeMapBase attributemapbase, final int i) {
        entityliving.setAbsorptionHearts(entityliving.getAbsorptionHearts() - 4 * (i + 1));
        super.a(entityliving, attributemapbase, i);
    }
    
    @Override
    public void b(final EntityLiving entityliving, final AttributeMapBase attributemapbase, final int i) {
        entityliving.setAbsorptionHearts(entityliving.getAbsorptionHearts() + 4 * (i + 1));
        super.b(entityliving, attributemapbase, i);
    }
}
