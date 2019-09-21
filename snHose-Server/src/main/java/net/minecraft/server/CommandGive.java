package net.minecraft.server;

import java.util.*;

public class CommandGive extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "give";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.give.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 2) {
            throw new ExceptionUsage("commands.give.usage", new Object[0]);
        }
        final EntityPlayer d = CommandAbstract.d(commandListener, array[0]);
        final Item f = CommandAbstract.f(commandListener, array[1]);
        int a = 1;
        int a2 = 0;
        if (array.length >= 3) {
            a = CommandAbstract.a(commandListener, array[2], 1, 64);
        }
        if (array.length >= 4) {
            a2 = CommandAbstract.a(commandListener, array[3]);
        }
        final ItemStack itemstack = new ItemStack(f, a, a2);
        if (array.length >= 5) {
            final String c = CommandAbstract.a(commandListener, array, 4).c();
            final NBTBase parse = MojangsonParser.parse(c);
            if (!(parse instanceof NBTTagCompound)) {
                CommandAbstract.a(commandListener, this, "commands.give.tagError", "Not a valid tag");
                return;
            }
            itemstack.setTag((NBTTagCompound)parse);
        }
        final EntityItem drop = d.drop(itemstack, false);
        drop.pickupDelay = 0;
        drop.a(d.getName());
        CommandAbstract.a(commandListener, this, "commands.give.success", itemstack.E(), a, d.getName());
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
