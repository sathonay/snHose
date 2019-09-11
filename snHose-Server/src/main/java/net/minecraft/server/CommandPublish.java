package net.minecraft.server;

public class CommandPublish extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "publish";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.publish.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final String a = MinecraftServer.getServer().a(EnumGamemode.SURVIVAL, false);
        if (a != null) {
            CommandAbstract.a(commandListener, this, "commands.publish.started", a);
        }
        else {
            CommandAbstract.a(commandListener, this, "commands.publish.failed", new Object[0]);
        }
    }
}
