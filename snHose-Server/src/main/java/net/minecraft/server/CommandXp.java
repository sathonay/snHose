package net.minecraft.server;

import java.util.*;

public class CommandXp extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "xp";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.xp.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0) {
            String substring = array[0];
            final boolean b = substring.endsWith("l") || substring.endsWith("L");
            if (b && substring.length() > 1) {
                substring = substring.substring(0, substring.length() - 1);
            }
            int a = CommandAbstract.a(commandListener, substring);
            final boolean b2 = a < 0;
            if (b2) {
                a *= -1;
            }
            EntityPlayer entityPlayer;
            if (array.length > 1) {
                entityPlayer = CommandAbstract.d(commandListener, array[1]);
            }
            else {
                entityPlayer = CommandAbstract.b(commandListener);
            }
            if (b) {
                if (b2) {
                    entityPlayer.levelDown(-a);
                    CommandAbstract.a(commandListener, this, "commands.xp.success.negative.levels", a, entityPlayer.getName());
                }
                else {
                    entityPlayer.levelDown(a);
                    CommandAbstract.a(commandListener, this, "commands.xp.success.levels", a, entityPlayer.getName());
                }
            }
            else {
                if (b2) {
                    throw new ExceptionUsage("commands.xp.failure.widthdrawXp", new Object[0]);
                }
                entityPlayer.giveExp(a);
                CommandAbstract.a(commandListener, this, "commands.xp.success", a, entityPlayer.getName());
            }
            return;
        }
        throw new ExceptionUsage("commands.xp.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 2) {
            return CommandAbstract.a(array, this.d());
        }
        return null;
    }
    
    protected String[] d() {
        return MinecraftServer.getServer().getPlayers();
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 1;
    }
}
