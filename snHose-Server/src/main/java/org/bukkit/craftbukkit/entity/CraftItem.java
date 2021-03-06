package org.bukkit.craftbukkit.entity;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityItem;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.craftbukkit.CraftServer;

public class CraftItem extends CraftEntity implements Item {
    private final EntityItem item;

    public CraftItem(CraftServer server, Entity entity, EntityItem item) {
        super(server, entity);
        this.item = item;
    }

    public CraftItem(CraftServer server, EntityItem entity) {
        this(server, entity, entity);
    }

    @Override
    public org.bukkit.entity.Entity getOwner() {
        return (this.item.owner == null) ? null : this.item.owner.getBukkitEntity();
    }

    @Override
    public void setOwner(org.bukkit.entity.Entity newOwner) {
        item.owner = ((CraftEntity)newOwner).getHandle();
    }

    public ItemStack getItemStack() {
        return CraftItemStack.asCraftMirror(item.getItemStack());
    }

    public void setItemStack(ItemStack stack) {
        item.setItemStack(CraftItemStack.asNMSCopy(stack));
    }

    public int getPickupDelay() {
        return item.pickupDelay;
    }

    public void setPickupDelay(int delay) {
        item.pickupDelay = delay;
    }

    @Override
    public String toString() {
        return "CraftItem";
    }

    public EntityType getType() {
        return EntityType.DROPPED_ITEM;
    }
}
