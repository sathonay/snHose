package net.minecraft.server;

public class CommandSetWorldSpawn extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "setworldspawn";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.setworldspawn.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length == 3) {
            if (commandListener.getWorld() == null) {
                throw new ExceptionUsage("commands.setworldspawn.usage", new Object[0]);
            }
            int n = 0;
            final int a = CommandAbstract.a(commandListener, array[n++], -30000000, 30000000);
            final int a2 = CommandAbstract.a(commandListener, array[n++], 0, 256);
            final int a3 = CommandAbstract.a(commandListener, array[n++], -30000000, 30000000);
            commandListener.getWorld().x(a, a2, a3);
            CommandAbstract.a(commandListener, this, "commands.setworldspawn.success", a, a2, a3);
        }
        else {
            if (array.length != 0) {
                throw new ExceptionUsage("commands.setworldspawn.usage", new Object[0]);
            }
            final ChunkCoordinates chunkCoordinates = CommandAbstract.b(commandListener).getChunkCoordinates();
            commandListener.getWorld().x(chunkCoordinates.x, chunkCoordinates.y, chunkCoordinates.z);
            CommandAbstract.a(commandListener, this, "commands.setworldspawn.success", chunkCoordinates.x, chunkCoordinates.y, chunkCoordinates.z);
        }
    }
}
