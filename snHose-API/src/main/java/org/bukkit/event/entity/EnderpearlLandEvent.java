package org.bukkit.event.entity;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class EnderpearlLandEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Reason reason;
    private final Entity hit;
    private boolean cancel;

    public EnderpearlLandEvent(final EnderPearl enderPearl, final Reason reason) {
        this(enderPearl, reason, null);
    }
    
    public EnderpearlLandEvent(final EnderPearl enderPearl, final Reason reason, final Entity hit) {
        super(enderPearl);
        this.reason = reason;
        this.hit = hit;
    }

    @Override
    public EnderPearl getEntity() {
        return (EnderPearl) entity;
    }
    
    public Reason getReason() {
        return reason;
    }
    
    /**
     * Returns the entity that was hit by the Enderpearl
     *
     * @return Entity hit
     */
    public Entity getHit() {
        return hit;
    }
    
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public enum Reason {
        /**
         * Called when the pearl hits a block
         */
        BLOCK,
        /**
         * Called when the pearl hits an entity
         */
        ENTITY
    }

}
