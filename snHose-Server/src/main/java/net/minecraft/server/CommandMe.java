package net.minecraft.server;

import java.util.*;

public class CommandMe extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "me";
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.me.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0) {
            MinecraftServer.getServer().getPlayerList().sendMessage(new ChatMessage("chat.type.emote", new Object[] { commandListener.getScoreboardDisplayName(), CommandAbstract.a(commandListener, array, 0, commandListener.a(1, "me")) }));
            return;
        }
        throw new ExceptionUsage("commands.me.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
    }
}
