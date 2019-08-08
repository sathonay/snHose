package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityCreature;
import net.minecraft.server.EntityLiving;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class CraftCreature extends CraftLivingEntity implements Creature {
    public CraftCreature(CraftServer server, EntityCreature entity) {
        super(server, entity);
    }

    private boolean pushable = true, damageable = true, stationary = false, stationaryHead = false, attack = true;

    public void setTarget(LivingEntity target) {
        EntityCreature entity = getHandle();
        if (target == null) {
            entity.target = null;
            entity.setGoalTarget(null);
        } else if (target instanceof CraftLivingEntity) {
            entity.target = ((CraftLivingEntity) target).getHandle();
            entity.pathEntity = entity.world.findPath(entity, entity.target, 16.0F, true, false, false, true);
            entity.setGoalTarget(((CraftLivingEntity) target).getHandle());
        }
    }

    public CraftLivingEntity getTarget() {
        if (getHandle().target == null) return null;
        if (!(getHandle().target instanceof EntityLiving)) return null;

        return (CraftLivingEntity) getHandle().target.getBukkitEntity();
    }

    @Override
    public void setStationary(boolean stationary) {
        this.stationary = stationary;
    }

    @Override
    public void setStationaryHead(boolean stationaryHead) {
        this.stationaryHead = stationaryHead;
    }

    @Override
    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    @Override
    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    @Override
    public void setDamageable(boolean damageable) {
        this.damageable = damageable;
    }

    @Override
    public void setMobAI(boolean mobAI) {
        this.stationary = !mobAI;
        this.stationaryHead = !mobAI;
        this.pushable = mobAI;
        this.attack = mobAI;
        this.damageable = !mobAI;
    }

    public boolean isPushable() {
        return pushable;
    }

    public boolean isDamageable() {
        return damageable;
    }

    public boolean isStationary() {
        return stationary;
    }

    public boolean isStationaryHead() {
        return stationaryHead;
    }

    public boolean isAttack() {
        return attack;
    }

    @Override
    public EntityCreature getHandle() {
        return (EntityCreature) entity;
    }

    @Override
    public String toString() {
        return "CraftCreature";
    }
}
