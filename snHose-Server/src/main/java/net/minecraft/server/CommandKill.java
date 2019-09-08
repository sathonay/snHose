package net.minecraft.server.v1_7_R4;

public class CommandKill extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "kill";
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.kill.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        CommandAbstract.b(commandListener).damageEntity(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
        commandListener.sendMessage(new ChatMessage("commands.kill.success", new Object[0]));
    }
}
