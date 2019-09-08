package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandSpawnpoint extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "spawnpoint";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.spawnpoint.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        final EntityPlayer entityPlayer = (array.length == 0) ? CommandAbstract.b(commandListener) : CommandAbstract.d(commandListener, array[0]);
        if (array.length == 4) {
            if (entityPlayer.world != null) {
                int n = 1;
                final int n2 = 30000000;
                final int a = CommandAbstract.a(commandListener, array[n++], -n2, n2);
                final int a2 = CommandAbstract.a(commandListener, array[n++], 0, 256);
                final int a3 = CommandAbstract.a(commandListener, array[n++], -n2, n2);
                entityPlayer.setRespawnPosition(new ChunkCoordinates(a, a2, a3), true);
                CommandAbstract.a(commandListener, this, "commands.spawnpoint.success", entityPlayer.getName(), a, a2, a3);
            }
        }
        else {
            if (array.length > 1) {
                throw new ExceptionUsage("commands.spawnpoint.usage", new Object[0]);
            }
            final ChunkCoordinates chunkCoordinates = entityPlayer.getChunkCoordinates();
            entityPlayer.setRespawnPosition(chunkCoordinates, true);
            CommandAbstract.a(commandListener, this, "commands.spawnpoint.success", entityPlayer.getName(), chunkCoordinates.x, chunkCoordinates.y, chunkCoordinates.z);
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1 || array.length == 2) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
