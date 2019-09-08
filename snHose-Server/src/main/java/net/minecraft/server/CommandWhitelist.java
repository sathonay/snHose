package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class CommandWhitelist extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "whitelist";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.whitelist.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            final MinecraftServer server = MinecraftServer.getServer();
            if (array[0].equals("on")) {
                server.getPlayerList().setHasWhitelist(true);
                CommandAbstract.a(commandListener, this, "commands.whitelist.enabled", new Object[0]);
                return;
            }
            if (array[0].equals("off")) {
                server.getPlayerList().setHasWhitelist(false);
                CommandAbstract.a(commandListener, this, "commands.whitelist.disabled", new Object[0]);
                return;
            }
            if (array[0].equals("list")) {
                commandListener.sendMessage(new ChatMessage("commands.whitelist.list", new Object[] { server.getPlayerList().getWhitelisted().length, server.getPlayerList().getSeenPlayers().length }));
                commandListener.sendMessage(new ChatComponentText(CommandAbstract.a((Object[])server.getPlayerList().getWhitelisted())));
                return;
            }
            if (array[0].equals("add")) {
                if (array.length < 2) {
                    throw new ExceptionUsage("commands.whitelist.add.usage", new Object[0]);
                }
                final GameProfile profile = server.getUserCache().getProfile(array[1]);
                if (profile == null) {
                    throw new CommandException("commands.whitelist.add.failed", new Object[] { array[1] });
                }
                server.getPlayerList().addWhitelist(profile);
                CommandAbstract.a(commandListener, this, "commands.whitelist.add.success", array[1]);
                return;
            }
            else if (array[0].equals("remove")) {
                if (array.length < 2) {
                    throw new ExceptionUsage("commands.whitelist.remove.usage", new Object[0]);
                }
                final GameProfile a = server.getPlayerList().getWhitelist().a(array[1]);
                if (a == null) {
                    throw new CommandException("commands.whitelist.remove.failed", new Object[] { array[1] });
                }
                server.getPlayerList().removeWhitelist(a);
                CommandAbstract.a(commandListener, this, "commands.whitelist.remove.success", array[1]);
                return;
            }
            else if (array[0].equals("reload")) {
                server.getPlayerList().reloadWhitelist();
                CommandAbstract.a(commandListener, this, "commands.whitelist.reloaded", new Object[0]);
                return;
            }
        }
        throw new ExceptionUsage("commands.whitelist.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "on", "off", "list", "add", "remove", "reload");
        }
        if (array.length == 2) {
            if (array[0].equals("remove")) {
                return CommandAbstract.a(array, MinecraftServer.getServer().getPlayerList().getWhitelisted());
            }
            if (array[0].equals("add")) {
                return CommandAbstract.a(array, MinecraftServer.getServer().getUserCache().a());
            }
        }
        return null;
    }
}
