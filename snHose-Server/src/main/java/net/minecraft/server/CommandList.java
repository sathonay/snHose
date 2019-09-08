package net.minecraft.server.v1_7_R4;

public class CommandList extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "list";
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.players.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        commandListener.sendMessage(new ChatMessage("commands.players.list", new Object[] { MinecraftServer.getServer().C(), MinecraftServer.getServer().D() }));
        commandListener.sendMessage(new ChatComponentText(MinecraftServer.getServer().getPlayerList().b(array.length > 0 && "uuids".equalsIgnoreCase(array[0]))));
    }
}
