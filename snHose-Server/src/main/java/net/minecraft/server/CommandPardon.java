package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class CommandPardon extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "pardon";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.unban.usage";
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return MinecraftServer.getServer().getPlayerList().getProfileBans().isEnabled() && super.canUse(commandListener);
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length != 1 || array[0].length() <= 0) {
            throw new ExceptionUsage("commands.unban.usage", new Object[0]);
        }
        final MinecraftServer server = MinecraftServer.getServer();
        final GameProfile a = server.getPlayerList().getProfileBans().a(array[0]);
        if (a == null) {
            throw new CommandException("commands.unban.failed", new Object[] { array[0] });
        }
        server.getPlayerList().getProfileBans().remove(a);
        CommandAbstract.a(commandListener, this, "commands.unban.success", array[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayerList().getProfileBans().getEntries());
        }
        return null;
    }
}
