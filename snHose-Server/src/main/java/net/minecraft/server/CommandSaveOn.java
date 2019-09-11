package net.minecraft.server;

public class CommandSaveOn extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "save-on";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.save-on.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final MinecraftServer server = MinecraftServer.getServer();
        boolean b = false;
        for (int i = 0; i < server.worldServer.length; ++i) {
            if (server.worldServer[i] != null) {
                final WorldServer worldServer = server.worldServer[i];
                if (worldServer.savingDisabled) {
                    worldServer.savingDisabled = false;
                    b = true;
                }
            }
        }
        if (b) {
            CommandAbstract.a(commandListener, this, "commands.save.enabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
    }
}
