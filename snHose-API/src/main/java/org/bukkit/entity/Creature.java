package org.bukkit.entity;

/**
 * Represents a Creature. Creatures are non-intelligent monsters or animals
 * which have very simple abilities.
 */
public interface Creature extends LivingEntity {

    /**
     * Instructs this Creature to set the specified LivingEntity as its
     * target.
     * <p>
     * Hostile creatures may attack their target, and friendly creatures may
     * follow their target.
     *
     * @param target New LivingEntity to target, or null to clear the target
     */
    public void setTarget(LivingEntity target);

    /**
     * Gets the current target of this Creature
     *
     * @return Current target of this creature, or null if none exists
     */
    public LivingEntity getTarget();

    public void setStationary(boolean stationary);
    public void setStationaryHead(boolean stationaryHead);
    public void setPushable(boolean pushable);
    public void setAttack(boolean attack);
    public void setDamageable(boolean damageable);
    public void setMobAI(boolean mobAI);


}
