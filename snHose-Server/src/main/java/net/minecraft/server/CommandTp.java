package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandTp extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "tp";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.tp.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            EntityPlayer entityPlayer;
            if (array.length == 2 || array.length == 4) {
                entityPlayer = CommandAbstract.d(commandListener, array[0]);
                if (entityPlayer == null) {
                    throw new ExceptionPlayerNotFound();
                }
            }
            else {
                entityPlayer = CommandAbstract.b(commandListener);
            }
            if (array.length == 3 || array.length == 4) {
                if (entityPlayer.world != null) {
                    int n = array.length - 3;
                    final double a = CommandAbstract.a(commandListener, entityPlayer.locX, array[n++]);
                    final double a2 = CommandAbstract.a(commandListener, entityPlayer.locY, array[n++], 0, 0);
                    final double a3 = CommandAbstract.a(commandListener, entityPlayer.locZ, array[n++]);
                    entityPlayer.mount(null);
                    entityPlayer.enderTeleportTo(a, a2, a3);
                    CommandAbstract.a(commandListener, this, "commands.tp.success.coordinates", entityPlayer.getName(), a, a2, a3);
                }
            }
            else if (array.length == 1 || array.length == 2) {
                final EntityPlayer d = CommandAbstract.d(commandListener, array[array.length - 1]);
                if (d == null) {
                    throw new ExceptionPlayerNotFound();
                }
                if (d.world != entityPlayer.world) {
                    CommandAbstract.a(commandListener, this, "commands.tp.notSameDimension", new Object[0]);
                    return;
                }
                entityPlayer.mount(null);
                entityPlayer.playerConnection.a(d.locX, d.locY, d.locZ, d.yaw, d.pitch);
                CommandAbstract.a(commandListener, this, "commands.tp.success", entityPlayer.getName(), d.getName());
            }
            return;
        }
        throw new ExceptionUsage("commands.tp.usage", new Object[0]);
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
