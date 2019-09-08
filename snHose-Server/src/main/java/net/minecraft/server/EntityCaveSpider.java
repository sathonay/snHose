package net.minecraft.server.v1_7_R4;

public class EntityCaveSpider extends EntitySpider
{
    public EntityCaveSpider(final World world) {
        super(world);
        this.a(0.7f, 0.5f);
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(12.0);
    }
    
    @Override
    public boolean n(final Entity entity) {
        if (super.n(entity)) {
            if (entity instanceof EntityLiving) {
                int n = 0;
                if (this.world.difficulty == EnumDifficulty.NORMAL) {
                    n = 7;
                }
                else if (this.world.difficulty == EnumDifficulty.HARD) {
                    n = 15;
                }
                if (n > 0) {
                    ((EntityLiving)entity).addEffect(new MobEffect(MobEffectList.POISON.id, n * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public GroupDataEntity prepare(final GroupDataEntity groupDataEntity) {
        return groupDataEntity;
    }
}
