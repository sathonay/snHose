package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class CommandOp extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "op";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.op.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length != 1 || array[0].length() <= 0) {
            throw new ExceptionUsage("commands.op.usage", new Object[0]);
        }
        final MinecraftServer server = MinecraftServer.getServer();
        final GameProfile profile = server.getUserCache().getProfile(array[0]);
        if (profile == null) {
            throw new CommandException("commands.op.failed", new Object[] { array[0] });
        }
        server.getPlayerList().addOp(profile);
        CommandAbstract.a(commandListener, this, "commands.op.success", array[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            final String s = array[array.length - 1];
            final ArrayList<String> list = new ArrayList<String>();
            for (final GameProfile gameprofile : MinecraftServer.getServer().F()) {
                if (!MinecraftServer.getServer().getPlayerList().isOp(gameprofile) && CommandAbstract.a(s, gameprofile.getName())) {
                    list.add(gameprofile.getName());
                }
            }
            return list;
        }
        return null;
    }
}
