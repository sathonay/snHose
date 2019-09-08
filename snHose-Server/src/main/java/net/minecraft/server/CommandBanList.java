package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandBanList extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "banlist";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return (MinecraftServer.getServer().getPlayerList().getIPBans().isEnabled() || MinecraftServer.getServer().getPlayerList().getProfileBans().isEnabled()) && super.canUse(commandListener);
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.banlist.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1 && array[0].equalsIgnoreCase("ips")) {
            commandListener.sendMessage(new ChatMessage("commands.banlist.ips", new Object[] { MinecraftServer.getServer().getPlayerList().getIPBans().getEntries().length }));
            commandListener.sendMessage(new ChatComponentText(CommandAbstract.a((Object[])MinecraftServer.getServer().getPlayerList().getIPBans().getEntries())));
        }
        else {
            commandListener.sendMessage(new ChatMessage("commands.banlist.players", new Object[] { MinecraftServer.getServer().getPlayerList().getProfileBans().getEntries().length }));
            commandListener.sendMessage(new ChatComponentText(CommandAbstract.a((Object[])MinecraftServer.getServer().getPlayerList().getProfileBans().getEntries())));
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "players", "ips");
        }
        return null;
    }
}
