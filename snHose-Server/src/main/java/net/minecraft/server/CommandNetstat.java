package net.minecraft.server;

public class CommandNetstat extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "netstat";
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
        if (commandListener instanceof EntityHuman) {
            commandListener.sendMessage(new ChatComponentText("Command is not available for players"));
            return;
        }
        if (array.length > 0 && array[0].length() > 1) {
            if ("hottest-read".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText(NetworkManager.h.e().toString()));
            }
            else if ("hottest-write".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText(NetworkManager.h.g().toString()));
            }
            else if ("most-read".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText(NetworkManager.h.f().toString()));
            }
            else if ("most-write".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText(NetworkManager.h.h().toString()));
            }
            else if ("packet-read".equals(array[0])) {
                if (array.length > 1 && array[1].length() > 0) {
                    try {
                        final int int1 = Integer.parseInt(array[1].trim());
                        this.a(commandListener, int1, NetworkManager.h.a(int1));
                    }
                    catch (Exception ex) {
                        commandListener.sendMessage(new ChatComponentText("Packet " + array[1] + " not found!"));
                    }
                }
                else {
                    commandListener.sendMessage(new ChatComponentText("Packet id is missing"));
                }
            }
            else if ("packet-write".equals(array[0])) {
                if (array.length > 1 && array[1].length() > 0) {
                    try {
                        final int int2 = Integer.parseInt(array[1].trim());
                        this.a(commandListener, int2, NetworkManager.h.b(int2));
                    }
                    catch (Exception ex2) {
                        commandListener.sendMessage(new ChatComponentText("Packet " + array[1] + " not found!"));
                    }
                }
                else {
                    commandListener.sendMessage(new ChatComponentText("Packet id is missing"));
                }
            }
            else if ("read-count".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText("total-read-count" + String.valueOf(NetworkManager.h.c())));
            }
            else if ("write-count".equals(array[0])) {
                commandListener.sendMessage(new ChatComponentText("total-write-count" + String.valueOf(NetworkManager.h.d())));
            }
            else {
                commandListener.sendMessage(new ChatComponentText("Unrecognized: " + array[0]));
            }
        }
        else {
            commandListener.sendMessage(new ChatComponentText("reads: " + NetworkManager.h.a() + ", writes: " + NetworkManager.h.b()));
        }
    }
    
    private void a(final ICommandListener commandListener, final int n, final PacketStatistics packetStatistics) {
        if (packetStatistics != null) {
            commandListener.sendMessage(new ChatComponentText(packetStatistics.toString()));
        }
        else {
            commandListener.sendMessage(new ChatComponentText("Packet " + n + " not found!"));
        }
    }
}
