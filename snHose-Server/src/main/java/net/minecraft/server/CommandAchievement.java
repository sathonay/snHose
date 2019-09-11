package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class CommandAchievement extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "achievement";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.achievement.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 2) {
            final Statistic statistic = StatisticList.getStatistic(array[1]);
            if (statistic == null && !array[1].equals("*")) {
                throw new CommandException("commands.achievement.unknownAchievement", new Object[] { array[1] });
            }
            EntityPlayer entityPlayer;
            if (array.length >= 3) {
                entityPlayer = CommandAbstract.d(commandListener, array[2]);
            }
            else {
                entityPlayer = CommandAbstract.b(commandListener);
            }
            if (array[0].equalsIgnoreCase("give")) {
                if (statistic == null) {
                    final Iterator<Achievement> iterator = AchievementList.e.iterator();
                    while (iterator.hasNext()) {
                        entityPlayer.a(iterator.next());
                    }
                    CommandAbstract.a(commandListener, this, "commands.achievement.give.success.all", entityPlayer.getName());
                }
                else {
                    if (statistic instanceof Achievement) {
                        Achievement c = (Achievement)statistic;
                        final ArrayList<Object> arrayList = Lists.newArrayList();
                        while (c.c != null && !entityPlayer.getStatisticManager().hasAchievement(c.c)) {
                            arrayList.add(c.c);
                            c = c.c;
                        }
                        final Iterator<Achievement> iterator2 = Lists.reverse((List<Achievement>)arrayList).iterator();
                        while (iterator2.hasNext()) {
                            entityPlayer.a(iterator2.next());
                        }
                    }
                    entityPlayer.a(statistic);
                    CommandAbstract.a(commandListener, this, "commands.achievement.give.success.one", entityPlayer.getName(), statistic.j());
                }
                return;
            }
        }
        throw new ExceptionUsage("commands.achievement.usage", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "give");
        }
        if (array.length == 2) {
            final ArrayList<String> arrayList = Lists.newArrayList();
            final Iterator<Statistic> iterator = StatisticList.stats.iterator();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next().name);
            }
            return CommandAbstract.a(array, arrayList);
        }
        if (array.length == 3) {
            return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
        }
        return null;
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 2;
    }
}
