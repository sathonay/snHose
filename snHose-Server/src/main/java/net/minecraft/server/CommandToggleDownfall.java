package net.minecraft.server;

public class CommandToggleDownfall extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "toggledownfall";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.downfall.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        this.d();
        CommandAbstract.a(commandListener, this, "commands.downfall.success", new Object[0]);
    }
    
    protected void d() {
        final WorldData worldData = MinecraftServer.getServer().worldServer[0].getWorldData();
        worldData.setStorm(!worldData.hasStorm());
    }
}
