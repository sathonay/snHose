package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandGamerule extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "gamerule";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.gamerule.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length == 2) {
            final String s = array[0];
            final String s2 = array[1];
            final GameRules d = this.d();
            if (d.contains(s)) {
                d.set(s, s2);
                CommandAbstract.a(commandListener, this, "commands.gamerule.success", new Object[0]);
            }
            else {
                CommandAbstract.a(commandListener, this, "commands.gamerule.norule", s);
            }
            return;
        }
        if (array.length == 1) {
            final String s3 = array[0];
            final GameRules d2 = this.d();
            if (d2.contains(s3)) {
                commandListener.sendMessage(new ChatComponentText(s3).a(" = ").a(d2.get(s3)));
            }
            else {
                CommandAbstract.a(commandListener, this, "commands.gamerule.norule", s3);
            }
            return;
        }
        if (array.length == 0) {
            commandListener.sendMessage(new ChatComponentText(CommandAbstract.a((Object[])this.d().getGameRules())));
            return;
        }
        throw new ExceptionUsage("commands.gamerule.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, this.d().getGameRules());
        }
        if (array.length == 2) {
            return CommandAbstract.a(array, "true", "false");
        }
        return null;
    }
    
    private GameRules d() {
        return MinecraftServer.getServer().getWorldServer(0).getGameRules();
    }
}
