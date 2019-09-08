package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandSay extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "say";
    }
    
    @Override
    public int a() {
        return 1;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.say.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0 && array[0].length() > 0) {
            MinecraftServer.getServer().getPlayerList().sendMessage(new ChatMessage("chat.type.announcement", new Object[] { commandListener.getName(), CommandAbstract.a(commandListener, array, 0, true) }));
            return;
        }
        throw new ExceptionUsage("commands.say.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
}
