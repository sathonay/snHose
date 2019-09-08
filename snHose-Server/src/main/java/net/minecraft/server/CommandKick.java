package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandKick extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "kick";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.kick.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length <= 0 || array[0].length() <= 1) {
            throw new ExceptionUsage("commands.kick.usage", new Object[0]);
        }
        final EntityPlayer player = MinecraftServer.getServer().getPlayerList().getPlayer(array[0]);
        String c = "Kicked by an operator.";
        boolean b = false;
        if (player == null) {
            throw new ExceptionPlayerNotFound();
        }
        if (array.length >= 2) {
            c = CommandAbstract.a(commandListener, array, 1).c();
            b = true;
        }
        player.playerConnection.disconnect(c);
        if (b) {
            CommandAbstract.a(commandListener, this, "commands.kick.success.reason", player.getName(), c);
        }
        else {
            CommandAbstract.a(commandListener, this, "commands.kick.success", player.getName());
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
}
