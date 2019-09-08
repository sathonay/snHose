package net.minecraft.server.v1_7_R4;

public class ServerCommand
{
    public final String command;
    public final ICommandListener source;
    
    public ServerCommand(final String command, final ICommandListener source) {
        this.command = command;
        this.source = source;
    }
}
