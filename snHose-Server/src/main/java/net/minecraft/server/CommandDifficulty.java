package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandDifficulty extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "difficulty";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.difficulty.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0) {
            final EnumDifficulty h = this.h(commandListener, array[0]);
            MinecraftServer.getServer().a(h);
            CommandAbstract.a(commandListener, this, "commands.difficulty.success", new ChatMessage(h.b(), new Object[0]));
            return;
        }
        throw new ExceptionUsage("commands.difficulty.usage", new Object[0]);
    }
    
    protected EnumDifficulty h(final ICommandListener commandListener, final String s) {
        if (s.equalsIgnoreCase("peaceful") || s.equalsIgnoreCase("p")) {
            return EnumDifficulty.PEACEFUL;
        }
        if (s.equalsIgnoreCase("easy") || s.equalsIgnoreCase("e")) {
            return EnumDifficulty.EASY;
        }
        if (s.equalsIgnoreCase("normal") || s.equalsIgnoreCase("n")) {
            return EnumDifficulty.NORMAL;
        }
        if (s.equalsIgnoreCase("hard") || s.equalsIgnoreCase("h")) {
            return EnumDifficulty.HARD;
        }
        return EnumDifficulty.getById(CommandAbstract.a(commandListener, s, 0, 3));
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "peaceful", "easy", "normal", "hard");
        }
        return null;
    }
}
