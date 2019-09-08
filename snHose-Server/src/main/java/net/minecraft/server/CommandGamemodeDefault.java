package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandGamemodeDefault extends CommandGamemode
{
    @Override
    public String getCommand() {
        return "defaultgamemode";
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.defaultgamemode.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length > 0) {
            final EnumGamemode h = this.h(commandListener, array[0]);
            this.a(h);
            CommandAbstract.a(commandListener, this, "commands.defaultgamemode.success", new ChatMessage("gameMode." + h.b(), new Object[0]));
            return;
        }
        throw new ExceptionUsage("commands.defaultgamemode.usage", new Object[0]);
    }
    
    protected void a(final EnumGamemode enumGamemode) {
        final MinecraftServer server = MinecraftServer.getServer();
        server.a(enumGamemode);
        if (server.getForceGamemode()) {
            for (final EntityPlayer entityPlayer : MinecraftServer.getServer().getPlayerList().players) {
                entityPlayer.a(enumGamemode);
                entityPlayer.fallDistance = 0.0f;
            }
        }
    }
}
