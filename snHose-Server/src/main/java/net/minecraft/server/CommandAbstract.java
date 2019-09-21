package net.minecraft.server;

import net.minecraft.util.com.google.common.primitives.*;
import java.util.*;

public abstract class CommandAbstract implements ICommand
{
    private static ICommandDispatcher a;
    
    public int a() {
        return 4;
    }
    
    @Override
    public List b() {
        return null;
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return commandListener.a(this.a(), this.getCommand());
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        return null;
    }
    
    public static int a(final ICommandListener commandListener, final String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            throw new ExceptionInvalidNumber("commands.generic.num.invalid", new Object[] { s });
        }
    }
    
    public static int a(final ICommandListener commandListener, final String s, final int n) {
        return a(commandListener, s, n, Integer.MAX_VALUE);
    }
    
    public static int a(final ICommandListener commandListener, final String s, final int n, final int n2) {
        final int a = a(commandListener, s);
        if (a < n) {
            throw new ExceptionInvalidNumber("commands.generic.num.tooSmall", new Object[] { a, n });
        }
        if (a > n2) {
            throw new ExceptionInvalidNumber("commands.generic.num.tooBig", new Object[] { a, n2 });
        }
        return a;
    }
    
    public static double b(final ICommandListener commandListener, final String s) {
        try {
            final double double1 = Double.parseDouble(s);
            if (!Doubles.isFinite(double1)) {
                throw new ExceptionInvalidNumber("commands.generic.num.invalid", new Object[] { s });
            }
            return double1;
        }
        catch (NumberFormatException ex) {
            throw new ExceptionInvalidNumber("commands.generic.num.invalid", new Object[] { s });
        }
    }
    
    public static double a(final ICommandListener commandListener, final String s, final double n) {
        return a(commandListener, s, n, Double.MAX_VALUE);
    }
    
    public static double a(final ICommandListener commandListener, final String s, final double n, final double n2) {
        final double b = b(commandListener, s);
        if (b < n) {
            throw new ExceptionInvalidNumber("commands.generic.double.tooSmall", new Object[] { b, n });
        }
        if (b > n2) {
            throw new ExceptionInvalidNumber("commands.generic.double.tooBig", new Object[] { b, n2 });
        }
        return b;
    }
    
    public static boolean c(final ICommandListener commandListener, final String s) {
        if (s.equals("true") || s.equals("1")) {
            return true;
        }
        if (s.equals("false") || s.equals("0")) {
            return false;
        }
        throw new CommandException("commands.generic.boolean.invalid", new Object[] { s });
    }
    
    public static EntityPlayer b(final ICommandListener commandListener) {
        if (commandListener instanceof EntityPlayer) {
            return (EntityPlayer)commandListener;
        }
        throw new ExceptionPlayerNotFound("You must specify which player you wish to perform this action on.", new Object[0]);
    }
    
    public static EntityPlayer d(final ICommandListener icommandlistener, final String s) {
        final EntityPlayer player = PlayerSelector.getPlayer(icommandlistener, s);
        if (player != null) {
            return player;
        }
        final EntityPlayer player2 = MinecraftServer.getServer().getPlayerList().getPlayer(s);
        if (player2 == null) {
            throw new ExceptionPlayerNotFound();
        }
        return player2;
    }
    
    public static String e(final ICommandListener icommandlistener, final String s) {
        final EntityPlayer player = PlayerSelector.getPlayer(icommandlistener, s);
        if (player != null) {
            return player.getName();
        }
        if (PlayerSelector.isPattern(s)) {
            throw new ExceptionPlayerNotFound();
        }
        return s;
    }
    
    public static IChatBaseComponent a(final ICommandListener commandListener, final String[] array, final int n) {
        return a(commandListener, array, n, false);
    }
    
    public static IChatBaseComponent a(final ICommandListener icommandlistener, final String[] array, final int n, final boolean b) {
        final ChatComponentText chatComponentText = new ChatComponentText("");
        for (int i = n; i < array.length; ++i) {
            if (i > n) {
                chatComponentText.a(" ");
            }
            IChatBaseComponent chatBaseComponent = new ChatComponentText(array[i]);
            if (b) {
                final IChatBaseComponent playerNames = PlayerSelector.getPlayerNames(icommandlistener, array[i]);
                if (playerNames != null) {
                    chatBaseComponent = playerNames;
                }
                else if (PlayerSelector.isPattern(array[i])) {
                    throw new ExceptionPlayerNotFound();
                }
            }
            chatComponentText.addSibling(chatBaseComponent);
        }
        return chatComponentText;
    }
    
    public static String b(final ICommandListener commandListener, final String[] array, final int n) {
        final StringJoiner sb = new StringJoiner(" ");
        for (int i = n; i < array.length; ++i) {
            sb.add(array[i]);
        }
        return sb.toString();
    }
    
    public static double a(final ICommandListener commandListener, final double n, final String s) {
        return a(commandListener, n, s, -30000000, 30000000);
    }
    
    public static double a(final ICommandListener commandListener, final double n, String substring, final int n2, final int n3) {
        final boolean startsWith = substring.startsWith("~");
        if (startsWith && Double.isNaN(n)) {
            throw new ExceptionInvalidNumber("commands.generic.num.invalid", new Object[] { n });
        }
        double n4 = startsWith ? n : 0.0;
        if (!startsWith || substring.length() > 1) {
            final boolean contains = substring.contains(".");
            if (startsWith) {
                substring = substring.substring(1);
            }
            n4 += b(commandListener, substring);
            if (!contains && !startsWith) {
                n4 += 0.5;
            }
        }
        if (n2 != 0 || n3 != 0) {
            if (n4 < n2) {
                throw new ExceptionInvalidNumber("commands.generic.double.tooSmall", new Object[] { n4, n2 });
            }
            if (n4 > n3) {
                throw new ExceptionInvalidNumber("commands.generic.double.tooBig", new Object[] { n4, n3 });
            }
        }
        return n4;
    }
    
    public static Item f(final ICommandListener commandListener, final String s) {
        Item item = (Item)Item.REGISTRY.get(s);
        if (item == null) {
            try {
                final Item byId = Item.getById(Integer.parseInt(s));
                if (byId != null) {
                    final ChatMessage chatMessage = new ChatMessage("commands.generic.deprecatedId", new Object[] { Item.REGISTRY.c(byId) });
                    chatMessage.getChatModifier().setColor(EnumChatFormat.GRAY);
                    commandListener.sendMessage(chatMessage);
                }
                item = byId;
            }
            catch (NumberFormatException ex) {}
        }
        if (item == null) {
            throw new ExceptionInvalidNumber("commands.give.notFound", new Object[] { s });
        }
        return item;
    }
    
    public static Block g(final ICommandListener commandListener, final String s) {
        if (Block.REGISTRY.b(s)) {
            return (Block)Block.REGISTRY.get(s);
        }
        try {
            final int int1 = Integer.parseInt(s);
            if (Block.REGISTRY.b(int1)) {
                final Block byId = Block.getById(int1);
                final ChatMessage chatMessage = new ChatMessage("commands.generic.deprecatedId", new Object[] { Block.REGISTRY.c(byId) });
                chatMessage.getChatModifier().setColor(EnumChatFormat.GRAY);
                commandListener.sendMessage(chatMessage);
                return byId;
            }
        }
        catch (NumberFormatException ex) {}
        throw new ExceptionInvalidNumber("commands.give.notFound", new Object[] { s });
    }
    
    public static String a(final Object[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            final String string = array[i].toString();
            if (i > 0) {
                if (i == array.length - 1) {
                    sb.append(" and ");
                }
                else {
                    sb.append(", ");
                }
            }
            sb.append(string);
        }
        return sb.toString();
    }
    
    public static IChatBaseComponent a(final IChatBaseComponent[] array) {
        final ChatComponentText chatComponentText = new ChatComponentText("");
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                if (i == array.length - 1) {
                    chatComponentText.a(" and ");
                }
                else if (i > 0) {
                    chatComponentText.a(", ");
                }
            }
            chatComponentText.addSibling(array[i]);
        }
        return chatComponentText;
    }
    
    public static String a(final Collection collection) {
        return a((Object[])collection.toArray(new String[collection.size()]));
    }
    
    public static boolean a(final String s, final String s2) {
        return s2.regionMatches(true, 0, s, 0, s.length());
    }
    
    public static List a(final String[] array, final String... array2) {
        final String s = array[array.length - 1];
        final List<String> list = new ArrayList<String>();
        for (final String s2 : array2) {
            if (a(s, s2)) {
                list.add(s2);
            }
        }
        return list;
    }
    
    public static List a(final String[] array, final Iterable iterable) {
        final String s = array[array.length - 1];
        final List<String> list = new ArrayList<String>();
        for (final String s2 : (Iterable<String>) iterable) {
            if (a(s, s2)) {
                list.add(s2);
            }
        }
        return list;
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return false;
    }
    
    public static void a(final ICommandListener commandListener, final ICommand command, final String s, final Object... array) {
        a(commandListener, command, 0, s, array);
    }
    
    public static void a(final ICommandListener commandListener, final ICommand command, final int n, final String s, final Object... array) {
        if (CommandAbstract.a != null) {
            CommandAbstract.a.a(commandListener, command, n, s, array);
        }
    }
    
    public static void a(final ICommandDispatcher a) {
        CommandAbstract.a = a;
    }
    
    public int a(final ICommand command) {
        return this.getCommand().compareTo(command.getCommand());
    }
}
