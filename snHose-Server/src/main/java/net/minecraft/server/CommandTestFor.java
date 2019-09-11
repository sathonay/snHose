package net.minecraft.server;

public class CommandTestFor extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "testfor";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.testfor.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length != 1) {
            throw new ExceptionUsage("commands.testfor.usage", new Object[0]);
        }
        if (!(commandListener instanceof CommandBlockListenerAbstract)) {
            throw new CommandException("commands.testfor.failed", new Object[0]);
        }
        CommandAbstract.d(commandListener, array[0]);
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
