package net.minecraft.server.v1_7_R4;

public class CommandIdleTimeout extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "setidletimeout";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.setidletimeout.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            final int a = CommandAbstract.a(commandListener, array[0], 0);
            MinecraftServer.getServer().setIdleTimeout(a);
            CommandAbstract.a(commandListener, this, "commands.setidletimeout.success", a);
            return;
        }
        throw new ExceptionUsage("commands.setidletimeout.usage", new Object[0]);
    }
}
