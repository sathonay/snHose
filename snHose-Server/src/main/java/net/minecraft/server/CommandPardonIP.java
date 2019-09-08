package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandPardonIP extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "pardon-ip";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return MinecraftServer.getServer().getPlayerList().getIPBans().isEnabled() && super.canUse(commandListener);
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.unbanip.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length != 1 || array[0].length() <= 1) {
            throw new ExceptionUsage("commands.unbanip.usage", new Object[0]);
        }
        if (CommandBanIp.a.matcher(array[0]).matches()) {
            MinecraftServer.getServer().getPlayerList().getIPBans().remove(array[0]);
            CommandAbstract.a(commandListener, this, "commands.unbanip.success", array[0]);
            return;
        }
        throw new ExceptionInvalidSyntax("commands.unbanip.invalid", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayerList().getIPBans().getEntries());
        }
        return null;
    }
}
