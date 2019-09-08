package net.minecraft.server.v1_7_R4;

import java.util.*;

public class EntityWitch extends EntityMonster implements IRangedEntity
{
    private static final UUID bp;
    private static final AttributeModifier bq;
    private static final Item[] br;
    private int bs;
    
    public EntityWitch(final World world) {
        super(world);
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalArrowAttack(this, 1.0, 60, 10.0f));
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 1.0));
        this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0f));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 0, true));
    }
    
    @Override
    protected void c() {
        super.c();
        this.getDataWatcher().a(21, (byte)0);
    }
    
    @Override
    protected String t() {
        return "mob.witch.idle";
    }
    
    @Override
    protected String aT() {
        return "mob.witch.hurt";
    }
    
    @Override
    protected String aU() {
        return "mob.witch.death";
    }
    
    public void a(final boolean b) {
        this.getDataWatcher().watch(21, (byte)(byte)(b ? 1 : 0));
    }
    
    public boolean bZ() {
        return this.getDataWatcher().getByte(21) == 1;
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(26.0);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.25);
    }
    
    public boolean bk() {
        return true;
    }
    
    @Override
    public void e() {
        if (!this.world.isStatic) {
            if (this.bZ()) {
                if (this.bs-- <= 0) {
                    this.a(false);
                    final ItemStack be = this.be();
                    this.setEquipment(0, null);
                    if (be != null && be.getItem() == Items.POTION) {
                        final List<MobEffect> g = Items.POTION.g(be);
                        if (g != null) {
                            final Iterator<MobEffect> iterator = g.iterator();
                            while (iterator.hasNext()) {
                                this.addEffect(new MobEffect(iterator.next()));
                            }
                        }
                    }
                    this.getAttributeInstance(GenericAttributes.d).b(EntityWitch.bq);
                }
            }
            else {
                int j = -1;
                if (this.random.nextFloat() < 0.15f && this.a(Material.WATER) && !this.hasEffect(MobEffectList.WATER_BREATHING)) {
                    j = 8237;
                }
                else if (this.random.nextFloat() < 0.15f && this.isBurning() && !this.hasEffect(MobEffectList.FIRE_RESISTANCE)) {
                    j = 16307;
                }
                else if (this.random.nextFloat() < 0.05f && this.getHealth() < this.getMaxHealth()) {
                    j = 16341;
                }
                else if (this.random.nextFloat() < 0.25f && this.getGoalTarget() != null && !this.hasEffect(MobEffectList.FASTER_MOVEMENT) && this.getGoalTarget().f(this) > 121.0) {
                    j = 16274;
                }
                else if (this.random.nextFloat() < 0.25f && this.getGoalTarget() != null && !this.hasEffect(MobEffectList.FASTER_MOVEMENT) && this.getGoalTarget().f(this) > 121.0) {
                    j = 16274;
                }
                if (j > -1) {
                    this.setEquipment(0, new ItemStack(Items.POTION, 1, j));
                    this.bs = this.be().n();
                    this.a(true);
                    final AttributeInstance attributeInstance = this.getAttributeInstance(GenericAttributes.d);
                    attributeInstance.b(EntityWitch.bq);
                    attributeInstance.a(EntityWitch.bq);
                }
            }
            if (this.random.nextFloat() < 7.5E-4f) {
                this.world.broadcastEntityEffect(this, (byte)15);
            }
        }
        super.e();
    }
    
    @Override
    protected float applyMagicModifier(final DamageSource damagesource, float applyMagicModifier) {
        applyMagicModifier = super.applyMagicModifier(damagesource, applyMagicModifier);
        if (damagesource.getEntity() == this) {
            applyMagicModifier = 0.0f;
        }
        if (damagesource.isMagic()) {
            applyMagicModifier *= 0.15;
        }
        return applyMagicModifier;
    }
    
    @Override
    protected void dropDeathLoot(final boolean b, final int n) {
        for (int n2 = this.random.nextInt(3) + 1, i = 0; i < n2; ++i) {
            int nextInt = this.random.nextInt(3);
            final Item item = EntityWitch.br[this.random.nextInt(EntityWitch.br.length)];
            if (n > 0) {
                nextInt += this.random.nextInt(n + 1);
            }
            for (int j = 0; j < nextInt; ++j) {
                this.a(item, 1);
            }
        }
    }
    
    @Override
    public void a(final EntityLiving entityLiving, final float n) {
        if (this.bZ()) {
            return;
        }
        final EntityPotion entityPotion;
        final EntityPotion entity = entityPotion = new EntityPotion(this.world, this, 32732);
        entityPotion.pitch += 20.0f;
        final double d0 = entityLiving.locX + entityLiving.motX - this.locX;
        final double n2 = entityLiving.locY + entityLiving.getHeadHeight() - 1.100000023841858 - this.locY;
        final double d2 = entityLiving.locZ + entityLiving.motZ - this.locZ;
        final float sqrt = MathHelper.sqrt(d0 * d0 + d2 * d2);
        if (sqrt >= 8.0f && !entityLiving.hasEffect(MobEffectList.SLOWER_MOVEMENT)) {
            entity.setPotionValue(32698);
        }
        else if (entityLiving.getHealth() >= 8.0f && !entityLiving.hasEffect(MobEffectList.POISON)) {
            entity.setPotionValue(32660);
        }
        else if (sqrt <= 3.0f && !entityLiving.hasEffect(MobEffectList.WEAKNESS) && this.random.nextFloat() < 0.25f) {
            entity.setPotionValue(32696);
        }
        entity.shoot(d0, n2 + sqrt * 0.2f, d2, 0.75f, 8.0f);
        this.world.addEntity(entity);
    }
    
    static {
        bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        bq = new AttributeModifier(EntityWitch.bp, "Drinking speed penalty", -0.25, 0).a(false);
        br = new Item[] { Items.GLOWSTONE_DUST, Items.SUGAR, Items.REDSTONE, Items.SPIDER_EYE, Items.GLASS_BOTTLE, Items.SULPHUR, Items.STICK, Items.STICK };
    }
}
