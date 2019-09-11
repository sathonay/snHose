package net.minecraft.server;

public class EntityDamageSource extends DamageSource
{
    protected Entity p;
    
    public EntityDamageSource(final String s, final Entity p2) {
        super(s);
        this.p = p2;
    }
    
    @Override
    public Entity getEntity() {
        return this.p;
    }
    
    @Override
    public IChatBaseComponent getLocalizedDeathMessage(final EntityLiving entityLiving) {
        final ItemStack itemStack = (this.p instanceof EntityLiving) ? ((EntityLiving)this.p).be() : null;
        final String string = "death.attack." + this.translationIndex;
        final String string2 = string + ".item";
        if (itemStack != null && itemStack.hasName() && LocaleI18n.c(string2)) {
            return new ChatMessage(string2, new Object[] { entityLiving.getScoreboardDisplayName(), this.p.getScoreboardDisplayName(), itemStack.E() });
        }
        return new ChatMessage(string, new Object[] { entityLiving.getScoreboardDisplayName(), this.p.getScoreboardDisplayName() });
    }
    
    @Override
    public boolean r() {
        return this.p != null && this.p instanceof EntityLiving && !(this.p instanceof EntityHuman);
    }
}
