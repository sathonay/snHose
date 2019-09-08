package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class CommandDeop extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "deop";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.deop.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length != 1 || array[0].length() <= 0) {
            throw new ExceptionUsage("commands.deop.usage", new Object[0]);
        }
        final MinecraftServer server = MinecraftServer.getServer();
        final GameProfile a = server.getPlayerList().getOPs().a(array[0]);
        if (a == null) {
            throw new CommandException("commands.deop.failed", new Object[] { array[0] });
        }
        server.getPlayerList().removeOp(a);
        CommandAbstract.a(commandListener, this, "commands.deop.success", array[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayerList().n());
        }
        return null;
    }
}
