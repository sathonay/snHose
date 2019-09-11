package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class CommandBan extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "ban";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.ban.usage";
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return MinecraftServer.getServer().getPlayerList().getProfileBans().isEnabled() && super.canUse(commandListener);
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 1 || array[0].length() <= 0) {
            throw new ExceptionUsage("commands.ban.usage", new Object[0]);
        }
        final MinecraftServer server = MinecraftServer.getServer();
        final GameProfile profile = server.getUserCache().getProfile(array[0]);
        if (profile == null) {
            throw new CommandException("commands.ban.failed", new Object[] { array[0] });
        }
        String c = null;
        if (array.length >= 2) {
            c = CommandAbstract.a(commandListener, array, 1).c();
        }
        server.getPlayerList().getProfileBans().add(new GameProfileBanEntry(profile, null, commandListener.getName(), null, c));
        final EntityPlayer player = server.getPlayerList().getPlayer(array[0]);
        if (player != null) {
            player.playerConnection.disconnect("You are banned from this server.");
        }
        CommandAbstract.a(commandListener, this, "commands.ban.success", array[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
}
