package net.minecraft.server;

public class CommandStop extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "stop";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.stop.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (MinecraftServer.getServer().worldServer != null) {
            CommandAbstract.a(commandListener, this, "commands.stop.start", new Object[0]);
        }
        MinecraftServer.getServer().safeShutdown();
    }
}
