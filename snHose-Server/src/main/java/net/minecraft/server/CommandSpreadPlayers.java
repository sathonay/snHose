package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class CommandSpreadPlayers extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "spreadplayers";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.spreadplayers.usage";
    }
    
    @Override
    public void execute(final ICommandListener icommandlistener, final String[] array) {
        if (array.length < 6) {
            throw new ExceptionUsage("commands.spreadplayers.usage", new Object[0]);
        }
        int i = 0;
        final double a = CommandAbstract.a(icommandlistener, Double.NaN, array[i++]);
        final double a2 = CommandAbstract.a(icommandlistener, Double.NaN, array[i++]);
        final double a3 = CommandAbstract.a(icommandlistener, array[i++], 0.0);
        final double a4 = CommandAbstract.a(icommandlistener, array[i++], a3 + 1.0);
        final boolean c = CommandAbstract.c(icommandlistener, array[i++]);
        final ArrayList<Object> arrayList = (ArrayList<Object>)Lists.newArrayList();
        while (i < array.length) {
            final String s = array[i++];
            if (PlayerSelector.isPattern(s)) {
                final EntityPlayer[] players = PlayerSelector.getPlayers(icommandlistener, s);
                if (players == null || players.length == 0) {
                    throw new ExceptionPlayerNotFound();
                }
                Collections.addAll(arrayList, players);
            }
            else {
                final EntityPlayer player = MinecraftServer.getServer().getPlayerList().getPlayer(s);
                if (player == null) {
                    throw new ExceptionPlayerNotFound();
                }
                arrayList.add(player);
            }
        }
        if (arrayList.isEmpty()) {
            throw new ExceptionPlayerNotFound();
        }
        icommandlistener.sendMessage(new ChatMessage("commands.spreadplayers.spreading." + (c ? "teams" : "players"), new Object[] { arrayList.size(), a4, a, a2, a3 }));
        this.a(icommandlistener, arrayList, new Location2D(a, a2), a3, a4, ((EntityPlayer)arrayList.get(0)).world, c);
    }
    
    private void a(final ICommandListener commandListener, final List list, final Location2D location2D, final double n, final double n2, final World world, final boolean b) {
        final Random random = new Random();
        final double n3 = location2D.a - n2;
        final double n4 = location2D.b - n2;
        final double n5 = location2D.a + n2;
        final double n6 = location2D.b + n2;
        final Location2D[] a = this.a(random, b ? this.a(list) : list.size(), n3, n4, n5, n6);
        final int a2 = this.a(location2D, n, world, random, n3, n4, n5, n6, a, b);
        final double a3 = this.a(list, world, a, b);
        CommandAbstract.a(commandListener, this, "commands.spreadplayers.success." + (b ? "teams" : "players"), a.length, location2D.a, location2D.b);
        if (a.length > 1) {
            commandListener.sendMessage(new ChatMessage("commands.spreadplayers.info." + (b ? "teams" : "players"), new Object[] { String.format("%.2f", a3), a2 }));
        }
    }
    
    private int a(final List list) {
        final HashSet<ScoreboardTeamBase> hashSet = (HashSet<ScoreboardTeamBase>)Sets.newHashSet();
        for (final EntityLiving entityLiving : list) {
            if (entityLiving instanceof EntityHuman) {
                hashSet.add(entityLiving.getScoreboardTeam());
            }
            else {
                hashSet.add(null);
            }
        }
        return hashSet.size();
    }
    
    private int a(final Location2D location2D, final double n, final World world, final Random random, final double n2, final double n3, final double n4, final double n5, final Location2D[] array, final boolean b) {
        int n6 = 1;
        double min = 3.4028234663852886E38;
        int n7;
        for (n7 = 0; n7 < 10000 && n6 != 0; ++n7) {
            n6 = 0;
            min = 3.4028234663852886E38;
            for (int i = 0; i < array.length; ++i) {
                final Location2D location2D2 = array[i];
                int n8 = 0;
                final Location2D location2D3 = new Location2D();
                for (int j = 0; j < array.length; ++j) {
                    if (i != j) {
                        final Location2D location2D4 = array[j];
                        final double a = location2D2.a(location2D4);
                        min = Math.min(a, min);
                        if (a < n) {
                            ++n8;
                            final Location2D location2D5 = location2D3;
                            location2D5.a += location2D4.a - location2D2.a;
                            final Location2D location2D6 = location2D3;
                            location2D6.b += location2D4.b - location2D2.b;
                        }
                    }
                }
                if (n8 > 0) {
                    final Location2D location2D7 = location2D3;
                    location2D7.a /= n8;
                    final Location2D location2D8 = location2D3;
                    location2D8.b /= n8;
                    if (location2D3.b() > 0.0) {
                        location2D3.a();
                        location2D2.b(location2D3);
                    }
                    else {
                        location2D2.a(random, n2, n3, n4, n5);
                    }
                    n6 = 1;
                }
                if (location2D2.a(n2, n3, n4, n5)) {
                    n6 = 1;
                }
            }
            if (n6 == 0) {
                for (final Location2D location2D9 : array) {
                    if (!location2D9.b(world)) {
                        location2D9.a(random, n2, n3, n4, n5);
                        n6 = 1;
                    }
                }
            }
        }
        if (n7 >= 10000) {
            throw new CommandException("commands.spreadplayers.failure." + (b ? "teams" : "players"), new Object[] { array.length, location2D.a, location2D.b, String.format("%.2f", min) });
        }
        return n7;
    }
    
    private double a(final List list, final World world, final Location2D[] array, final boolean b) {
        double n = 0.0;
        int n2 = 0;
        final HashMap<Object, Object> hashMap = Maps.newHashMap();
        for (int i = 0; i < list.size(); ++i) {
            final EntityLiving entityLiving = list.get(i);
            Location2D location2D;
            if (b) {
                final ScoreboardTeamBase scoreboardTeamBase = (entityLiving instanceof EntityHuman) ? entityLiving.getScoreboardTeam() : null;
                if (!hashMap.containsKey(scoreboardTeamBase)) {
                    hashMap.put(scoreboardTeamBase, array[n2++]);
                }
                location2D = hashMap.get(scoreboardTeamBase);
            }
            else {
                location2D = array[n2++];
            }
            entityLiving.enderTeleportTo(MathHelper.floor(location2D.a) + 0.5f, location2D.a(world), MathHelper.floor(location2D.b) + 0.5);
            double min = Double.MAX_VALUE;
            for (int j = 0; j < array.length; ++j) {
                if (location2D != array[j]) {
                    min = Math.min(location2D.a(array[j]), min);
                }
            }
            n += min;
        }
        return n / list.size();
    }
    
    private Location2D[] a(final Random random, final int n, final double n2, final double n3, final double n4, final double n5) {
        final Location2D[] array = new Location2D[n];
        for (int i = 0; i < array.length; ++i) {
            final Location2D location2D = new Location2D();
            location2D.a(random, n2, n3, n4, n5);
            array[i] = location2D;
        }
        return array;
    }
}
