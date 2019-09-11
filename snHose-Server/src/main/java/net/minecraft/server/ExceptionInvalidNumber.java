package net.minecraft.server;

public class ExceptionInvalidNumber extends CommandException
{
    public ExceptionInvalidNumber() {
        this("commands.generic.num.invalid", new Object[0]);
    }
    
    public ExceptionInvalidNumber(final String s, final Object... array) {
        super(s, array);
    }
}
