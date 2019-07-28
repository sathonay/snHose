package org.spigotmc;

import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TicksPerSecondCommand extends Command {

    long startTime = System.currentTimeMillis();

    public TicksPerSecondCommand(String name) {
        super( name );
        this.description = "Gets the current ticks per second for the server";
        this.usageMessage = "/tps";
        this.setPermission( "bukkit.command.tps" );
    }

    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if (!testPermission(sender)) return true;

        Runtime runtime = Runtime.getRuntime();
        double usedMemory = runtime.totalMemory() - runtime.freeMemory();
        double freeMemory = runtime.maxMemory() - usedMemory;

        sender.sendMessage(ChatColor.GOLD + "Memory: " + formatMemmory(usedMemory) + ChatColor.GRAY + "/" + formatMemmory(runtime.maxMemory()) + ChatColor.GRAY + " (" + formatMemmory(freeMemory) + " free" + ChatColor.GRAY + ")");


        // PaperSpigot start - Further improve tick handling
        double[] tps = Bukkit.spigot().getTPS();
        String[] tpsAvg = new String[tps.length];

        for ( int i = 0; i < tps.length; i++) {
            tpsAvg[i] = format( tps[i] );
        }

        sender.sendMessage(ChatColor.GOLD + "TPS from last 1m, 5m, 15m: " + StringUtils.join(tpsAvg, ", "));
        sender.sendMessage(ChatColor.GOLD + "Last Tick Time: " + ChatColor.YELLOW + (System.currentTimeMillis() - MinecraftServer.LAST_TICK_TIME) + "ms");
        // PaperSpigot end

        return true;
    }

    private static String format(double tps) {  // PaperSpigot - made static
        return ((tps > 18.0) ? ChatColor.GREEN : (tps > 16.0) ? ChatColor.YELLOW : ChatColor.RED).toString() + (( tps > 20.0) ? "*" : "") + Math.min(Math.round(tps * 100.0) / 100.0, 20.0);
    }

    private static String formatMemmory(double mem) {
        return ChatColor.YELLOW.toString() + Math.round(mem / 1024.0D / 1024.0D) + "MB";
    }
}
