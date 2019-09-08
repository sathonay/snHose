package net.minecraft.server.v1_7_R4;

public class CommandSaveOff extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "save-off";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.save-off.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final MinecraftServer server = MinecraftServer.getServer();
        boolean b = false;
        for (int i = 0; i < server.worldServer.length; ++i) {
            if (server.worldServer[i] != null) {
                final WorldServer worldServer = server.worldServer[i];
                if (!worldServer.savingDisabled) {
                    worldServer.savingDisabled = true;
                    b = true;
                }
            }
        }
        if (b) {
            CommandAbstract.a(commandListener, this, "commands.save.disabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-off.alreadyOff", new Object[0]);
    }
}
