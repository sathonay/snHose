package net.minecraft.server;

import java.util.*;

public class CombatTracker {
    private final List<CombatEntry> a;
    private final EntityLiving b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private String h;
    
    public CombatTracker(final EntityLiving b) {
        this.a = new ArrayList<>();
        this.b = b;
    }
    
    public void a() {
        this.j();
        if (this.b.h_()) {
            final Block type = this.b.world.getType(MathHelper.floor(this.b.locX), MathHelper.floor(this.b.boundingBox.b), MathHelper.floor(this.b.locZ));
            if (type == Blocks.LADDER) {
                this.h = "ladder";
            }
            else if (type == Blocks.VINE) {
                this.h = "vines";
            }
        }
        else if (this.b.M()) {
            this.h = "water";
        }
    }
    
    public void a(final DamageSource damageSource, final float n, final float n2) {
        this.g();
        this.a();
        final CombatEntry combatEntry = new CombatEntry(damageSource, this.b.ticksLived, n, n2, this.h, this.b.fallDistance);
        this.a.add(combatEntry);
        this.c = this.b.ticksLived;
        this.g = true;
        if (combatEntry.f() && !this.f && this.b.isAlive()) {
            this.f = true;
            this.d = this.b.ticksLived;
            this.e = this.d;
            this.b.bu();
        }
    }
    
    public IChatBaseComponent b() {
        if (this.a.size() == 0) {
            return new ChatMessage("death.attack.generic", new Object[] { this.b.getScoreboardDisplayName() });
        }
        final CombatEntry i = this.i();
        final CombatEntry combatEntry = this.a.get(this.a.size() - 1);
        final IChatBaseComponent h = combatEntry.h();
        final Entity entity = combatEntry.a().getEntity();
        IChatBaseComponent localizedDeathMessage;
        if (i != null && combatEntry.a() == DamageSource.FALL) {
            final IChatBaseComponent h2 = i.h();
            if (i.a() == DamageSource.FALL || i.a() == DamageSource.OUT_OF_WORLD) {
                localizedDeathMessage = new ChatMessage("death.fell.accident." + this.a(i), new Object[] { this.b.getScoreboardDisplayName() });
            }
            else if (h2 != null && (h == null || !h2.equals(h))) {
                final Entity entity2 = i.a().getEntity();
                final ItemStack itemStack = (entity2 instanceof EntityLiving) ? ((EntityLiving)entity2).be() : null;
                localizedDeathMessage = (itemStack != null && itemStack.hasName() ? new ChatMessage("death.fell.assist.item", new Object[] { this.b.getScoreboardDisplayName(), h2, itemStack.E() }) : new ChatMessage("death.fell.assist", new Object[] { this.b.getScoreboardDisplayName(), h2 }));
            }
            else if (h != null) {
                final ItemStack itemStack2 = (entity instanceof EntityLiving) ? ((EntityLiving)entity).be() : null;
                if (itemStack2 != null && itemStack2.hasName()) {
                    localizedDeathMessage = new ChatMessage("death.fell.finish.item", new Object[] { this.b.getScoreboardDisplayName(), h, itemStack2.E() });
                }
                else {
                    localizedDeathMessage = new ChatMessage("death.fell.finish", new Object[] { this.b.getScoreboardDisplayName(), h });
                }
            }
            else {
                localizedDeathMessage = new ChatMessage("death.fell.killer", new Object[] { this.b.getScoreboardDisplayName() });
            }
        }
        else {
            localizedDeathMessage = combatEntry.a().getLocalizedDeathMessage(this.b);
        }
        return localizedDeathMessage;
    }
    
    public EntityLiving c() {
        EntityLiving entityLiving = null;
        EntityLiving entityLiving2 = null;
        float c = 0.0f;
        float c2 = 0.0f;
        for (final CombatEntry combatEntry : this.a) {
            if (combatEntry.a().getEntity() instanceof EntityHuman && (entityLiving2 == null || combatEntry.c() > c2)) {
                c2 = combatEntry.c();
                entityLiving2 = (EntityHuman)combatEntry.a().getEntity();
            }
            if (combatEntry.a().getEntity() instanceof EntityLiving && (entityLiving == null || combatEntry.c() > c)) {
                c = combatEntry.c();
                entityLiving = (EntityLiving)combatEntry.a().getEntity();
            }
        }
        if (entityLiving2 != null && c2 >= c / 3.0f) {
            return entityLiving2;
        }
        return entityLiving;
    }
    
    private CombatEntry i() {
        CombatEntry combatEntry = null;
        CombatEntry combatEntry2 = null;
        final int n = 0;
        float i = 0.0f;
        for (int j = 0; j < this.a.size(); ++j) {
            final CombatEntry combatEntry3 = this.a.get(j);
            final CombatEntry combatEntry4 = (j > 0) ? this.a.get(j - 1) : null;
            if ((combatEntry3.a() == DamageSource.FALL || combatEntry3.a() == DamageSource.OUT_OF_WORLD) && combatEntry3.i() > 0.0f && (combatEntry == null || combatEntry3.i() > i)) {
                combatEntry = (j > 0 ? combatEntry4 : combatEntry3);
                i = combatEntry3.i();
            }
            if (combatEntry3.g() != null && (combatEntry2 == null || combatEntry3.c() > n)) {
                combatEntry2 = combatEntry3;
            }
        }
        if (i > 5.0f && combatEntry != null) {
            return combatEntry;
        }
        if (n > 5 && combatEntry2 != null) {
            return combatEntry2;
        }
        return null;
    }
    
    private String a(final CombatEntry combatEntry) {
        return (combatEntry.g() == null) ? "generic" : combatEntry.g();
    }
    
    private void j() {
        this.h = null;
    }
    
    public void g() {
        final int n = this.f ? 300 : 100;
        if (this.g && (!this.b.isAlive() || this.b.ticksLived - this.c > n)) {
            final boolean f = this.f;
            this.g = false;
            this.f = false;
            this.e = this.b.ticksLived;
            if (f) {
                this.b.bv();
            }
            this.a.clear();
        }
    }
}
