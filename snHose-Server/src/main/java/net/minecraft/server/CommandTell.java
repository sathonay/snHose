package net.minecraft.server;

import java.util.*;

public class CommandTell extends CommandAbstract
{
    @Override
    public List b() {
        return Arrays.asList("w", "msg");
    }
    
    @Override
    public String getCommand() {
        return "tell";
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.message.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 2) {
            throw new ExceptionUsage("commands.message.usage", new Object[0]);
        }
        final EntityPlayer d = CommandAbstract.d(commandListener, array[0]);
        if (d == null) {
            throw new ExceptionPlayerNotFound();
        }
        if (d == commandListener) {
            throw new ExceptionPlayerNotFound("commands.message.sameTarget", new Object[0]);
        }
        final IChatBaseComponent a = CommandAbstract.a(commandListener, array, 1, !(commandListener instanceof EntityHuman));
        final ChatMessage chatMessage = new ChatMessage("commands.message.display.incoming", new Object[] { commandListener.getScoreboardDisplayName(), a.f() });
        final ChatMessage chatMessage2 = new ChatMessage("commands.message.display.outgoing", new Object[] { d.getScoreboardDisplayName(), a.f() });
        chatMessage.getChatModifier().setColor(EnumChatFormat.GRAY).setItalic(true);
        chatMessage2.getChatModifier().setColor(EnumChatFormat.GRAY).setItalic(true);
        d.sendMessage(chatMessage);
        commandListener.sendMessage(chatMessage2);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
