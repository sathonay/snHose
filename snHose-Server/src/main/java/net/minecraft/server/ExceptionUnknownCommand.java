package net.minecraft.server;

public class ExceptionUnknownCommand extends CommandException
{
    public ExceptionUnknownCommand() {
        this("commands.generic.notFound", new Object[0]);
    }
    
    public ExceptionUnknownCommand(final String s, final Object... array) {
        super(s, array);
    }
}
