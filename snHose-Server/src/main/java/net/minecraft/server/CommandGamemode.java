package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandGamemode extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "gamemode";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.gamemode.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0) {
            final EnumGamemode h = this.h(commandListener, array[0]);
            final EntityPlayer entityPlayer = (array.length >= 2) ? CommandAbstract.d(commandListener, array[1]) : CommandAbstract.b(commandListener);
            entityPlayer.a(h);
            entityPlayer.fallDistance = 0.0f;
            final ChatMessage chatMessage = new ChatMessage("gameMode." + h.b(), new Object[0]);
            if (entityPlayer != commandListener) {
                CommandAbstract.a(commandListener, this, 1, "commands.gamemode.success.other", entityPlayer.getName(), chatMessage);
            }
            else {
                CommandAbstract.a(commandListener, this, 1, "commands.gamemode.success.self", chatMessage);
            }
            return;
        }
        throw new ExceptionUsage("commands.gamemode.usage", new Object[0]);
    }
    
    protected EnumGamemode h(final ICommandListener commandListener, final String s) {
        if (s.equalsIgnoreCase(EnumGamemode.SURVIVAL.b()) || s.equalsIgnoreCase("s")) {
            return EnumGamemode.SURVIVAL;
        }
        if (s.equalsIgnoreCase(EnumGamemode.CREATIVE.b()) || s.equalsIgnoreCase("c")) {
            return EnumGamemode.CREATIVE;
        }
        if (s.equalsIgnoreCase(EnumGamemode.ADVENTURE.b()) || s.equalsIgnoreCase("a")) {
            return EnumGamemode.ADVENTURE;
        }
        return WorldSettings.a(CommandAbstract.a(commandListener, s, 0, EnumGamemode.values().length - 2));
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "survival", "creative", "adventure");
        }
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
