package org.bukkit.event.entity;

import org.bukkit.entity.EnderPearl;
import org.bukkit.event.HandlerList;

public class EnderpearlLandEvent extends EntityEvent {

    private static final HandlerList handlers = new HandlerList();

    public EnderpearlLandEvent(final EnderPearl enderPearl) {
        super(enderPearl);
    }

    @Override
    public EnderPearl getEntity() {
        return (EnderPearl) entity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
