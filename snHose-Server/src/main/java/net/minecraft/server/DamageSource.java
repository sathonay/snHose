package net.minecraft.server;

public class DamageSource
{
    public static DamageSource FIRE;
    public static DamageSource BURN;
    public static DamageSource LAVA;
    public static DamageSource STUCK;
    public static DamageSource DROWN;
    public static DamageSource STARVE;
    public static DamageSource CACTUS;
    public static DamageSource FALL;
    public static DamageSource OUT_OF_WORLD;
    public static DamageSource GENERIC;
    public static DamageSource MAGIC;
    public static DamageSource WITHER;
    public static DamageSource ANVIL;
    public static DamageSource FALLING_BLOCK;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    public String translationIndex;
    
    public static DamageSource mobAttack(final EntityLiving entityLiving) {
        return new EntityDamageSource("mob", entityLiving);
    }
    
    public static DamageSource playerAttack(final EntityHuman entityHuman) {
        return new EntityDamageSource("player", entityHuman);
    }
    
    public static DamageSource arrow(final EntityArrow entity, final Entity entity2) {
        return new EntityDamageSourceIndirect("arrow", entity, entity2).b();
    }
    
    public static DamageSource fireball(final EntityFireball entity, final Entity entity2) {
        if (entity2 == null) {
            return new EntityDamageSourceIndirect("onFire", entity, entity).setExplosion().b();
        }
        return new EntityDamageSourceIndirect("fireball", entity, entity2).setExplosion().b();
    }
    
    public static DamageSource projectile(final Entity entity, final Entity entity2) {
        return new EntityDamageSourceIndirect("thrown", entity, entity2).b();
    }
    
    public static DamageSource b(final Entity entity, final Entity entity2) {
        return new EntityDamageSourceIndirect("indirectMagic", entity, entity2).setIgnoreArmor().setMagic();
    }
    
    public static DamageSource a(final Entity entity) {
        return new EntityDamageSource("thorns", entity).setMagic();
    }
    
    public static DamageSource explosion(final Explosion explosion) {
        if (explosion != null && explosion.c() != null) {
            return new EntityDamageSource("explosion.player", explosion.c()).q().d();
        }
        return new DamageSource("explosion").q().d();
    }
    
    public boolean a() {
        return this.u;
    }
    
    public DamageSource b() {
        this.u = true;
        return this;
    }
    
    public boolean isExplosion() {
        return this.x;
    }
    
    public DamageSource d() {
        this.x = true;
        return this;
    }
    
    public boolean ignoresArmor() {
        return this.p;
    }
    
    public float getExhaustionCost() {
        return this.s;
    }
    
    public boolean ignoresInvulnerability() {
        return this.q;
    }
    
    public boolean isStarvation() {
        return this.r;
    }
    
    protected DamageSource(final String translationIndex) {
        this.s = 0.3f;
        this.translationIndex = translationIndex;
    }
    
    public Entity i() {
        return this.getEntity();
    }
    
    public Entity getEntity() {
        return null;
    }
    
    protected DamageSource setIgnoreArmor() {
        this.p = true;
        this.s = 0.0f;
        return this;
    }
    
    protected DamageSource l() {
        this.q = true;
        return this;
    }
    
    protected DamageSource m() {
        this.r = true;
        this.s = 0.0f;
        return this;
    }
    
    protected DamageSource setExplosion() {
        this.t = true;
        return this;
    }
    
    public IChatBaseComponent getLocalizedDeathMessage(final EntityLiving entityLiving) {
        final EntityLiving ax = entityLiving.aX();
        final String string = "death.attack." + this.translationIndex;
        final String string2 = string + ".player";
        if (ax != null && LocaleI18n.c(string2)) {
            return new ChatMessage(string2, new Object[] { entityLiving.getScoreboardDisplayName(), ax.getScoreboardDisplayName() });
        }
        return new ChatMessage(string, new Object[] { entityLiving.getScoreboardDisplayName() });
    }
    
    public boolean o() {
        return this.t;
    }
    
    public String p() {
        return this.translationIndex;
    }
    
    public DamageSource q() {
        this.v = true;
        return this;
    }
    
    public boolean r() {
        return this.v;
    }
    
    public boolean isMagic() {
        return this.w;
    }
    
    public DamageSource setMagic() {
        this.w = true;
        return this;
    }
    
    static {
        DamageSource.FIRE = new DamageSource("inFire").setExplosion();
        DamageSource.BURN = new DamageSource("onFire").setIgnoreArmor().setExplosion();
        DamageSource.LAVA = new DamageSource("lava").setExplosion();
        DamageSource.STUCK = new DamageSource("inWall").setIgnoreArmor();
        DamageSource.DROWN = new DamageSource("drown").setIgnoreArmor();
        DamageSource.STARVE = new DamageSource("starve").setIgnoreArmor().m();
        DamageSource.CACTUS = new DamageSource("cactus");
        DamageSource.FALL = new DamageSource("fall").setIgnoreArmor();
        DamageSource.OUT_OF_WORLD = new DamageSource("outOfWorld").setIgnoreArmor().l();
        DamageSource.GENERIC = new DamageSource("generic").setIgnoreArmor();
        DamageSource.MAGIC = new DamageSource("magic").setIgnoreArmor().setMagic();
        DamageSource.WITHER = new DamageSource("wither").setIgnoreArmor();
        DamageSource.ANVIL = new DamageSource("anvil");
        DamageSource.FALLING_BLOCK = new DamageSource("fallingBlock");
    }
}
