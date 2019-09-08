package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandTime extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "time";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.time.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 1) {
            if (array[0].equals("set")) {
                int a;
                if (array[1].equals("day")) {
                    a = 1000;
                }
                else if (array[1].equals("night")) {
                    a = 13000;
                }
                else {
                    a = CommandAbstract.a(commandListener, array[1], 0);
                }
                this.a(commandListener, a);
                CommandAbstract.a(commandListener, this, "commands.time.set", a);
                return;
            }
            if (array[0].equals("add")) {
                final int a2 = CommandAbstract.a(commandListener, array[1], 0);
                this.b(commandListener, a2);
                CommandAbstract.a(commandListener, this, "commands.time.added", a2);
                return;
            }
        }
        throw new ExceptionUsage("commands.time.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "set", "add");
        }
        if (array.length == 2 && array[0].equals("set")) {
            return CommandAbstract.a(array, "day", "night");
        }
        return null;
    }
    
    protected void a(final ICommandListener commandListener, final int n) {
        for (int i = 0; i < MinecraftServer.getServer().worldServer.length; ++i) {
            MinecraftServer.getServer().worldServer[i].setDayTime(n);
        }
    }
    
    protected void b(final ICommandListener commandListener, final int n) {
        for (int i = 0; i < MinecraftServer.getServer().worldServer.length; ++i) {
            final WorldServer worldServer = MinecraftServer.getServer().worldServer[i];
            worldServer.setDayTime(worldServer.getDayTime() + n);
        }
    }
}
