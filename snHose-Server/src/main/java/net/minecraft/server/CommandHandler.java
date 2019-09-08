package net.minecraft.server.v1_7_R4;

import java.util.*;
import org.apache.logging.log4j.*;

public class CommandHandler implements ICommandHandler
{
    private static final Logger a;
    private final Map b;
    private final Set c;
    
    public CommandHandler() {
        this.b = new HashMap();
        this.c = new HashSet();
    }
    
    @Override
    public int a(final ICommandListener icommandlistener, String s) {
        s = s.trim();
        if (s.startsWith("/")) {
            s = s.substring(1);
        }
        final String[] split = s.split(" ");
        final String s2 = split[0];
        final String[] a = a(split);
        final ICommand command = this.b.get(s2);
        final int a2 = this.a(command, a);
        int n = 0;
        try {
            if (command == null) {
                throw new ExceptionUnknownCommand();
            }
            if (command.canUse(icommandlistener)) {
                if (a2 > -1) {
                    final EntityPlayer[] players = PlayerSelector.getPlayers(icommandlistener, a[a2]);
                    final String s3 = a[a2];
                    final EntityPlayer[] array = players;
                    for (int length = array.length, i = 0; i < length; ++i) {
                        a[a2] = array[i].getName();
                        try {
                            command.execute(icommandlistener, a);
                            ++n;
                        }
                        catch (CommandException ex) {
                            final ChatMessage chatMessage = new ChatMessage(ex.getMessage(), ex.getArgs());
                            chatMessage.getChatModifier().setColor(EnumChatFormat.RED);
                            icommandlistener.sendMessage(chatMessage);
                        }
                    }
                    a[a2] = s3;
                }
                else {
                    try {
                        command.execute(icommandlistener, a);
                        ++n;
                    }
                    catch (CommandException ex2) {
                        final ChatMessage chatMessage2 = new ChatMessage(ex2.getMessage(), ex2.getArgs());
                        chatMessage2.getChatModifier().setColor(EnumChatFormat.RED);
                        icommandlistener.sendMessage(chatMessage2);
                    }
                }
            }
            else {
                final ChatMessage chatMessage3 = new ChatMessage("commands.generic.permission", new Object[0]);
                chatMessage3.getChatModifier().setColor(EnumChatFormat.RED);
                icommandlistener.sendMessage(chatMessage3);
            }
        }
        catch (ExceptionUsage exceptionUsage) {
            final ChatMessage chatMessage4 = new ChatMessage("commands.generic.usage", new Object[] { new ChatMessage(exceptionUsage.getMessage(), exceptionUsage.getArgs()) });
            chatMessage4.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatMessage4);
        }
        catch (CommandException ex3) {
            final ChatMessage chatMessage5 = new ChatMessage(ex3.getMessage(), ex3.getArgs());
            chatMessage5.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatMessage5);
        }
        catch (Throwable t) {
            final ChatMessage chatMessage6 = new ChatMessage("commands.generic.exception", new Object[0]);
            chatMessage6.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatMessage6);
            CommandHandler.a.error("Couldn't process command: '" + s + "'", t);
        }
        return n;
    }
    
    public ICommand a(final ICommand command) {
        final List b = command.b();
        this.b.put(command.getCommand(), command);
        this.c.add(command);
        if (b != null) {
            for (final String s : b) {
                final ICommand command2 = this.b.get(s);
                if (command2 == null || !command2.getCommand().equals(s)) {
                    this.b.put(s, command);
                }
            }
        }
        return command;
    }
    
    private static String[] a(final String[] array) {
        final String[] array2 = new String[array.length - 1];
        for (int i = 1; i < array.length; ++i) {
            array2[i - 1] = array[i];
        }
        return array2;
    }
    
    @Override
    public List b(final ICommandListener commandListener, final String s) {
        final String[] split = s.split(" ", -1);
        final String s2 = split[0];
        if (split.length == 1) {
            final ArrayList<String> list = new ArrayList<String>();
            for (final Map.Entry<String, V> entry : this.b.entrySet()) {
                if (CommandAbstract.a(s2, entry.getKey()) && ((ICommand)entry.getValue()).canUse(commandListener)) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }
        if (split.length > 1) {
            final ICommand command = this.b.get(s2);
            if (command != null) {
                return command.tabComplete(commandListener, a(split));
            }
        }
        return null;
    }
    
    @Override
    public List a(final ICommandListener commandListener) {
        final ArrayList<ICommand> list = new ArrayList<ICommand>();
        for (final ICommand command : this.c) {
            if (command.canUse(commandListener)) {
                list.add(command);
            }
        }
        return list;
    }
    
    @Override
    public Map a() {
        return this.b;
    }
    
    private int a(final ICommand command, final String[] array) {
        if (command == null) {
            return -1;
        }
        for (int i = 0; i < array.length; ++i) {
            if (command.isListStart(array, i) && PlayerSelector.isList(array[i])) {
                return i;
            }
        }
        return -1;
    }
    
    static {
        a = LogManager.getLogger();
    }
}
