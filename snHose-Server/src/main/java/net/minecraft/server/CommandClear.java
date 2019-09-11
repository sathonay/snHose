package net.minecraft.server;

import java.util.*;

public class CommandClear extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "clear";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.clear.usage";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final EntityPlayer entityPlayer = (array.length == 0) ? CommandAbstract.b(commandListener) : CommandAbstract.d(commandListener, array[0]);
        final Item item = (array.length >= 2) ? CommandAbstract.f(commandListener, array[1]) : null;
        final int i = (array.length >= 3) ? CommandAbstract.a(commandListener, array[2], 0) : -1;
        if (array.length >= 2 && item == null) {
            throw new CommandException("commands.clear.failure", new Object[] { entityPlayer.getName() });
        }
        final int a = entityPlayer.inventory.a(item, i);
        entityPlayer.defaultContainer.b();
        if (!entityPlayer.abilities.canInstantlyBuild) {
            entityPlayer.broadcastCarriedItem();
        }
        if (a == 0) {
            throw new CommandException("commands.clear.failure", new Object[] { entityPlayer.getName() });
        }
        CommandAbstract.a(commandListener, this, "commands.clear.success", entityPlayer.getName(), a);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, this.d());
        }
        if (array.length == 2) {
            return CommandAbstract.a(array, Item.REGISTRY.keySet());
        }
        return null;
    }
    
    protected String[] d() {
        return MinecraftServer.getServer().getPlayers();
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
