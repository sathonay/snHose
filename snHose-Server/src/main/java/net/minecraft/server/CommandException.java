package net.minecraft.server;

public class CommandException extends RuntimeException
{
    private Object[] a;
    
    public CommandException(final String s, final Object... a) {
        super(s);
        this.a = a;
    }
    
    public Object[] getArgs() {
        return this.a;
    }
}
