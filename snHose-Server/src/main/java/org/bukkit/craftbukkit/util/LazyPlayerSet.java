package org.bukkit.craftbukkit.util;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import org.bukkit.entity.Player;

public class LazyPlayerSet extends LazyHashSet<Player> {

    @Override
    Set<Player> makeReference() {
        if (reference != null) {
            throw new IllegalStateException("Reference already created!");
        }
        List<EntityPlayer> players = MinecraftServer.getServer().getPlayerList().players;
        Set<Player> reference = new HashSet<>(players.size());
        for (EntityPlayer player : players) {
            reference.add(player.getBukkitEntity());
        }
        return reference;
    }

}
