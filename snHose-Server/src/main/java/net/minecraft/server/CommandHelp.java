package net.minecraft.server;

import java.util.*;

public class CommandHelp extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "help";
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.help.usage";
    }
    
    @Override
    public List b() {
        return Arrays.asList("?");
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final List d = this.d(commandListener);
        final int n = 7;
        final int n2 = (d.size() - 1) / n;
        int n3;
        try {
            n3 = ((array.length == 0) ? 0 : (CommandAbstract.a(commandListener, array[0], 1, n2 + 1) - 1));
        }
        catch (ExceptionInvalidNumber exceptionInvalidNumber) {
            final ICommand command = this.d().get(array[0]);
            if (command != null) {
                throw new ExceptionUsage(command.c(commandListener), new Object[0]);
            }
            if (MathHelper.a(array[0], -1) != -1) {
                throw exceptionInvalidNumber;
            }
            throw new ExceptionUnknownCommand();
        }
        final int min = Math.min((n3 + 1) * n, d.size());
        final ChatMessage chatMessage = new ChatMessage("commands.help.header", new Object[] { n3 + 1, n2 + 1 });
        chatMessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
        commandListener.sendMessage(chatMessage);
        for (int i = n3 * n; i < min; ++i) {
            final ICommand command2 = d.get(i);
            final ChatMessage chatMessage2 = new ChatMessage(command2.c(commandListener), new Object[0]);
            chatMessage2.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.SUGGEST_COMMAND, "/" + command2.getCommand() + " "));
            commandListener.sendMessage(chatMessage2);
        }
        if (n3 == 0 && commandListener instanceof EntityHuman) {
            final ChatMessage chatMessage3 = new ChatMessage("commands.help.footer", new Object[0]);
            chatMessage3.getChatModifier().setColor(EnumChatFormat.GREEN);
            commandListener.sendMessage(chatMessage3);
        }
    }
    
    protected List d(final ICommandListener commandListener) {
        final List a = MinecraftServer.getServer().getCommandHandler().a(commandListener);
        Collections.sort((List<Comparable>)a);
        return a;
    }
    
    protected Map d() {
        return MinecraftServer.getServer().getCommandHandler().a();
    }
}
