package net.minecraft.server.v1_7_R4;

public class ExceptionInvalidSyntax extends CommandException
{
    public ExceptionInvalidSyntax() {
        this("commands.generic.snytax", new Object[0]);
    }
    
    public ExceptionInvalidSyntax(final String s, final Object... array) {
        super(s, array);
    }
}
