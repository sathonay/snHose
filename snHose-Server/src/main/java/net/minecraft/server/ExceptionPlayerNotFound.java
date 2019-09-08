package net.minecraft.server.v1_7_R4;

public class ExceptionPlayerNotFound extends CommandException
{
    public ExceptionPlayerNotFound() {
        this("commands.generic.player.notFound", new Object[0]);
    }
    
    public ExceptionPlayerNotFound(final String s, final Object... array) {
        super(s, array);
    }
}
