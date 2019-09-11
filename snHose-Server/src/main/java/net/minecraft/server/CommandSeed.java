package net.minecraft.server;

public class CommandSeed extends CommandAbstract
{
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return MinecraftServer.getServer().N() || super.canUse(commandListener);
    }
    
    @Override
    public String getCommand() {
        return "seed";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.seed.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        commandListener.sendMessage(new ChatMessage("commands.seed.success", new Object[] { ((commandListener instanceof EntityHuman) ? ((EntityHuman)commandListener).world : MinecraftServer.getServer().getWorldServer(0)).getSeed() }));
    }
}
