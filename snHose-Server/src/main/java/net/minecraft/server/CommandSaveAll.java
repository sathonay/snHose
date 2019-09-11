package net.minecraft.server;

public class CommandSaveAll extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "save-all";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.save.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final MinecraftServer server = MinecraftServer.getServer();
        commandListener.sendMessage(new ChatMessage("commands.save.start", new Object[0]));
        if (server.getPlayerList() != null) {
            server.getPlayerList().savePlayers();
        }
        try {
            for (int i = 0; i < server.worldServer.length; ++i) {
                if (server.worldServer[i] != null) {
                    final WorldServer worldServer = server.worldServer[i];
                    final boolean savingDisabled = worldServer.savingDisabled;
                    worldServer.savingDisabled = false;
                    worldServer.save(true, null);
                    worldServer.savingDisabled = savingDisabled;
                }
            }
            if (array.length > 0 && "flush".equals(array[0])) {
                commandListener.sendMessage(new ChatMessage("commands.save.flushStart", new Object[0]));
                for (int j = 0; j < server.worldServer.length; ++j) {
                    if (server.worldServer[j] != null) {
                        final WorldServer worldServer2 = server.worldServer[j];
                        final boolean savingDisabled2 = worldServer2.savingDisabled;
                        worldServer2.savingDisabled = false;
                        worldServer2.flushSave();
                        worldServer2.savingDisabled = savingDisabled2;
                    }
                }
                commandListener.sendMessage(new ChatMessage("commands.save.flushEnd", new Object[0]));
            }
        }
        catch (ExceptionWorldConflict exceptionWorldConflict) {
            CommandAbstract.a(commandListener, this, "commands.save.failed", exceptionWorldConflict.getMessage());
            return;
        }
        CommandAbstract.a(commandListener, this, "commands.save.success", new Object[0]);
    }
}
