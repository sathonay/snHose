package net.minecraft.server;

public class ExceptionPlayerNotFound extends CommandException
{
    public ExceptionPlayerNotFound() {
        this("commands.generic.player.notFound", new Object[0]);
    }
    
    public ExceptionPlayerNotFound(final String s, final Object... array) {
        super(s, array);
    }
}
