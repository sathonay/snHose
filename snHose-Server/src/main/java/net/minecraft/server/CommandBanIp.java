package net.minecraft.server.v1_7_R4;

import java.util.regex.*;
import java.util.*;

public class CommandBanIp extends CommandAbstract
{
    public static final Pattern a;
    
    @Override
    public String getCommand() {
        return "ban-ip";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public boolean canUse(final ICommandListener commandListener) {
        return MinecraftServer.getServer().getPlayerList().getIPBans().isEnabled() && super.canUse(commandListener);
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.banip.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1 && array[0].length() > 1) {
            final Matcher matcher = CommandBanIp.a.matcher(array[0]);
            IChatBaseComponent a = null;
            if (array.length >= 2) {
                a = CommandAbstract.a(commandListener, array, 1);
            }
            if (matcher.matches()) {
                this.a(commandListener, array[0], (a == null) ? null : a.c());
            }
            else {
                final EntityPlayer player = MinecraftServer.getServer().getPlayerList().getPlayer(array[0]);
                if (player == null) {
                    throw new ExceptionPlayerNotFound("commands.banip.invalid", new Object[0]);
                }
                this.a(commandListener, player.s(), (a == null) ? null : a.c());
            }
            return;
        }
        throw new ExceptionUsage("commands.banip.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
    
    protected void a(final ICommandListener commandListener, final String s, final String s2) {
        MinecraftServer.getServer().getPlayerList().getIPBans().add(new IpBanEntry(s, null, commandListener.getName(), null, s2));
        final List b = MinecraftServer.getServer().getPlayerList().b(s);
        final String[] array = new String[b.size()];
        int n = 0;
        for (final EntityPlayer entityPlayer : b) {
            entityPlayer.playerConnection.disconnect("You have been IP banned.");
            array[n++] = entityPlayer.getName();
        }
        if (b.isEmpty()) {
            CommandAbstract.a(commandListener, this, "commands.banip.success", s);
        }
        else {
            CommandAbstract.a(commandListener, this, "commands.banip.success.players", s, CommandAbstract.a((Object[])array));
        }
    }
    
    static {
        a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
}
