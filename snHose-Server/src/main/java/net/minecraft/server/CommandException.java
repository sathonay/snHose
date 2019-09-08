package net.minecraft.server.v1_7_R4;

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
