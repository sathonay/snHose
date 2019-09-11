package net.minecraft.server;

import net.minecraft.util.org.apache.commons.lang3.exception.*;
import net.minecraft.util.com.google.gson.*;
import java.util.*;

public class CommandTellRaw extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "tellraw";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.tellraw.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 2) {
            throw new ExceptionUsage("commands.tellraw.usage", new Object[0]);
        }
        final EntityPlayer d = CommandAbstract.d(commandListener, array[0]);
        final String b = CommandAbstract.b(commandListener, array, 1);
        try {
            d.sendMessage(ChatSerializer.a(b));
        }
        catch (JsonParseException throwable) {
            final Throwable rootCause = ExceptionUtils.getRootCause(throwable);
            throw new ExceptionInvalidSyntax("commands.tellraw.jsonException", new Object[] { (rootCause == null) ? "" : rootCause.getMessage() });
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
