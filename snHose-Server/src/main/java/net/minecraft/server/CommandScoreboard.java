package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandScoreboard extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "scoreboard";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.scoreboard.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 1) {
            if (array[0].equalsIgnoreCase("objectives")) {
                if (array.length == 1) {
                    throw new ExceptionUsage("commands.scoreboard.objectives.usage", new Object[0]);
                }
                if (array[1].equalsIgnoreCase("list")) {
                    this.d(commandListener);
                }
                else if (array[1].equalsIgnoreCase("add")) {
                    if (array.length < 4) {
                        throw new ExceptionUsage("commands.scoreboard.objectives.add.usage", new Object[0]);
                    }
                    this.c(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("remove")) {
                    if (array.length != 3) {
                        throw new ExceptionUsage("commands.scoreboard.objectives.remove.usage", new Object[0]);
                    }
                    this.h(commandListener, array[2]);
                }
                else {
                    if (!array[1].equalsIgnoreCase("setdisplay")) {
                        throw new ExceptionUsage("commands.scoreboard.objectives.usage", new Object[0]);
                    }
                    if (array.length != 3 && array.length != 4) {
                        throw new ExceptionUsage("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                    }
                    this.k(commandListener, array, 2);
                }
                return;
            }
            else if (array[0].equalsIgnoreCase("players")) {
                if (array.length == 1) {
                    throw new ExceptionUsage("commands.scoreboard.players.usage", new Object[0]);
                }
                if (array[1].equalsIgnoreCase("list")) {
                    if (array.length > 3) {
                        throw new ExceptionUsage("commands.scoreboard.players.list.usage", new Object[0]);
                    }
                    this.l(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("add")) {
                    if (array.length != 5) {
                        throw new ExceptionUsage("commands.scoreboard.players.add.usage", new Object[0]);
                    }
                    this.m(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("remove")) {
                    if (array.length != 5) {
                        throw new ExceptionUsage("commands.scoreboard.players.remove.usage", new Object[0]);
                    }
                    this.m(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("set")) {
                    if (array.length != 5) {
                        throw new ExceptionUsage("commands.scoreboard.players.set.usage", new Object[0]);
                    }
                    this.m(commandListener, array, 2);
                }
                else {
                    if (!array[1].equalsIgnoreCase("reset")) {
                        throw new ExceptionUsage("commands.scoreboard.players.usage", new Object[0]);
                    }
                    if (array.length != 3) {
                        throw new ExceptionUsage("commands.scoreboard.players.reset.usage", new Object[0]);
                    }
                    this.n(commandListener, array, 2);
                }
                return;
            }
            else if (array[0].equalsIgnoreCase("teams")) {
                if (array.length == 1) {
                    throw new ExceptionUsage("commands.scoreboard.teams.usage", new Object[0]);
                }
                if (array[1].equalsIgnoreCase("list")) {
                    if (array.length > 3) {
                        throw new ExceptionUsage("commands.scoreboard.teams.list.usage", new Object[0]);
                    }
                    this.g(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("add")) {
                    if (array.length < 3) {
                        throw new ExceptionUsage("commands.scoreboard.teams.add.usage", new Object[0]);
                    }
                    this.d(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("remove")) {
                    if (array.length != 3) {
                        throw new ExceptionUsage("commands.scoreboard.teams.remove.usage", new Object[0]);
                    }
                    this.f(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("empty")) {
                    if (array.length != 3) {
                        throw new ExceptionUsage("commands.scoreboard.teams.empty.usage", new Object[0]);
                    }
                    this.j(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("join")) {
                    if (array.length < 4 && (array.length != 3 || !(commandListener instanceof EntityHuman))) {
                        throw new ExceptionUsage("commands.scoreboard.teams.join.usage", new Object[0]);
                    }
                    this.h(commandListener, array, 2);
                }
                else if (array[1].equalsIgnoreCase("leave")) {
                    if (array.length < 3 && !(commandListener instanceof EntityHuman)) {
                        throw new ExceptionUsage("commands.scoreboard.teams.leave.usage", new Object[0]);
                    }
                    this.i(commandListener, array, 2);
                }
                else {
                    if (!array[1].equalsIgnoreCase("option")) {
                        throw new ExceptionUsage("commands.scoreboard.teams.usage", new Object[0]);
                    }
                    if (array.length != 4 && array.length != 5) {
                        throw new ExceptionUsage("commands.scoreboard.teams.option.usage", new Object[0]);
                    }
                    this.e(commandListener, array, 2);
                }
                return;
            }
        }
        throw new ExceptionUsage("commands.scoreboard.usage", new Object[0]);
    }
    
    protected Scoreboard d() {
        return MinecraftServer.getServer().getWorldServer(0).getScoreboard();
    }
    
    protected ScoreboardObjective a(final String s, final boolean b) {
        final ScoreboardObjective objective = this.d().getObjective(s);
        if (objective == null) {
            throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] { s });
        }
        if (b && objective.getCriteria().isReadOnly()) {
            throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] { s });
        }
        return objective;
    }
    
    protected ScoreboardTeam a(final String s) {
        final ScoreboardTeam team = this.d().getTeam(s);
        if (team == null) {
            throw new CommandException("commands.scoreboard.teamNotFound", new Object[] { s });
        }
        return team;
    }
    
    protected void c(final ICommandListener commandListener, final String[] array, int n) {
        final String s = array[n++];
        final String s2 = array[n++];
        final Scoreboard d = this.d();
        final IScoreboardCriteria scoreboardCriteria = IScoreboardCriteria.criteria.get(s2);
        if (scoreboardCriteria == null) {
            throw new ExceptionUsage("commands.scoreboard.objectives.add.wrongType", new Object[] { s2 });
        }
        if (d.getObjective(s) != null) {
            throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] { s });
        }
        if (s.length() > 16) {
            throw new ExceptionInvalidSyntax("commands.scoreboard.objectives.add.tooLong", new Object[] { s, 16 });
        }
        if (s.length() == 0) {
            throw new ExceptionUsage("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (array.length > n) {
            final String c = CommandAbstract.a(commandListener, array, n).c();
            if (c.length() > 32) {
                throw new ExceptionInvalidSyntax("commands.scoreboard.objectives.add.displayTooLong", new Object[] { c, 32 });
            }
            if (c.length() > 0) {
                d.registerObjective(s, scoreboardCriteria).setDisplayName(c);
            }
            else {
                d.registerObjective(s, scoreboardCriteria);
            }
        }
        else {
            d.registerObjective(s, scoreboardCriteria);
        }
        CommandAbstract.a(commandListener, this, "commands.scoreboard.objectives.add.success", s);
    }
    
    protected void d(final ICommandListener commandListener, final String[] array, int n) {
        final String s = array[n++];
        final Scoreboard d = this.d();
        if (d.getTeam(s) != null) {
            throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] { s });
        }
        if (s.length() > 16) {
            throw new ExceptionInvalidSyntax("commands.scoreboard.teams.add.tooLong", new Object[] { s, 16 });
        }
        if (s.length() == 0) {
            throw new ExceptionUsage("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (array.length > n) {
            final String c = CommandAbstract.a(commandListener, array, n).c();
            if (c.length() > 32) {
                throw new ExceptionInvalidSyntax("commands.scoreboard.teams.add.displayTooLong", new Object[] { c, 32 });
            }
            if (c.length() > 0) {
                d.createTeam(s).setDisplayName(c);
            }
            else {
                d.createTeam(s);
            }
        }
        else {
            d.createTeam(s);
        }
        CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.add.success", s);
    }
    
    protected void e(final ICommandListener commandListener, final String[] array, int n) {
        final ScoreboardTeam a = this.a(array[n++]);
        if (a == null) {
            return;
        }
        final String lowerCase = array[n++].toLowerCase();
        if (!lowerCase.equalsIgnoreCase("color") && !lowerCase.equalsIgnoreCase("friendlyfire") && !lowerCase.equalsIgnoreCase("seeFriendlyInvisibles")) {
            throw new ExceptionUsage("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        if (array.length != 4) {
            final String s = array[n++];
            if (lowerCase.equalsIgnoreCase("color")) {
                final EnumChatFormat b = EnumChatFormat.b(s);
                if (b == null || b.isFormat()) {
                    throw new ExceptionUsage("commands.scoreboard.teams.option.noValue", new Object[] { lowerCase, CommandAbstract.a(EnumChatFormat.a(true, false)) });
                }
                a.setPrefix(b.toString());
                a.setSuffix(EnumChatFormat.RESET.toString());
            }
            else if (lowerCase.equalsIgnoreCase("friendlyfire")) {
                if (!s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false")) {
                    throw new ExceptionUsage("commands.scoreboard.teams.option.noValue", new Object[] { lowerCase, CommandAbstract.a(Arrays.asList("true", "false")) });
                }
                a.setAllowFriendlyFire(s.equalsIgnoreCase("true"));
            }
            else if (lowerCase.equalsIgnoreCase("seeFriendlyInvisibles")) {
                if (!s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false")) {
                    throw new ExceptionUsage("commands.scoreboard.teams.option.noValue", new Object[] { lowerCase, CommandAbstract.a(Arrays.asList("true", "false")) });
                }
                a.setCanSeeFriendlyInvisibles(s.equalsIgnoreCase("true"));
            }
            CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.option.success", lowerCase, a.getName(), s);
            return;
        }
        if (lowerCase.equalsIgnoreCase("color")) {
            throw new ExceptionUsage("commands.scoreboard.teams.option.noValue", new Object[] { lowerCase, CommandAbstract.a(EnumChatFormat.a(true, false)) });
        }
        if (lowerCase.equalsIgnoreCase("friendlyfire") || lowerCase.equalsIgnoreCase("seeFriendlyInvisibles")) {
            throw new ExceptionUsage("commands.scoreboard.teams.option.noValue", new Object[] { lowerCase, CommandAbstract.a(Arrays.asList("true", "false")) });
        }
        throw new ExceptionUsage("commands.scoreboard.teams.option.usage", new Object[0]);
    }
    
    protected void f(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        final ScoreboardTeam a = this.a(array[n++]);
        if (a == null) {
            return;
        }
        d.removeTeam(a);
        CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.remove.success", a.getName());
    }
    
    protected void g(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        if (array.length > n) {
            final ScoreboardTeam a = this.a(array[n++]);
            if (a == null) {
                return;
            }
            final Collection playerNameSet = a.getPlayerNameSet();
            if (playerNameSet.size() <= 0) {
                throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] { a.getName() });
            }
            final ChatMessage chatMessage = new ChatMessage("commands.scoreboard.teams.list.player.count", new Object[] { playerNameSet.size(), a.getName() });
            chatMessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
            commandListener.sendMessage(chatMessage);
            commandListener.sendMessage(new ChatComponentText(CommandAbstract.a(playerNameSet.toArray())));
        }
        else {
            final Collection teams = d.getTeams();
            if (teams.size() <= 0) {
                throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
            }
            final ChatMessage chatMessage2 = new ChatMessage("commands.scoreboard.teams.list.count", new Object[] { teams.size() });
            chatMessage2.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
            commandListener.sendMessage(chatMessage2);
            for (final ScoreboardTeam scoreboardTeam : teams) {
                commandListener.sendMessage(new ChatMessage("commands.scoreboard.teams.list.entry", new Object[] { scoreboardTeam.getName(), scoreboardTeam.getDisplayName(), scoreboardTeam.getPlayerNameSet().size() }));
            }
        }
    }
    
    protected void h(final ICommandListener commandListener, final String[] array, int i) {
        final Scoreboard d = this.d();
        final String s = array[i++];
        final HashSet<String> set = new HashSet<String>();
        final HashSet<String> set2 = new HashSet<String>();
        if (commandListener instanceof EntityHuman && i == array.length) {
            final String name = CommandAbstract.b(commandListener).getName();
            if (d.addPlayerToTeam(name, s)) {
                set.add(name);
            }
            else {
                set2.add(name);
            }
        }
        else {
            while (i < array.length) {
                final String e = CommandAbstract.e(commandListener, array[i++]);
                if (d.addPlayerToTeam(e, s)) {
                    set.add(e);
                }
                else {
                    set2.add(e);
                }
            }
        }
        if (!set.isEmpty()) {
            CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.join.success", set.size(), s, CommandAbstract.a((Object[])set.toArray(new String[0])));
        }
        if (!set2.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.join.failure", new Object[] { set2.size(), s, CommandAbstract.a((Object[])set2.toArray(new String[0])) });
        }
    }
    
    protected void i(final ICommandListener commandListener, final String[] array, int i) {
        final Scoreboard d = this.d();
        final HashSet<String> set = new HashSet<String>();
        final HashSet<String> set2 = new HashSet<String>();
        if (commandListener instanceof EntityHuman && i == array.length) {
            final String name = CommandAbstract.b(commandListener).getName();
            if (d.removePlayerFromTeam(name)) {
                set.add(name);
            }
            else {
                set2.add(name);
            }
        }
        else {
            while (i < array.length) {
                final String e = CommandAbstract.e(commandListener, array[i++]);
                if (d.removePlayerFromTeam(e)) {
                    set.add(e);
                }
                else {
                    set2.add(e);
                }
            }
        }
        if (!set.isEmpty()) {
            CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.leave.success", set.size(), CommandAbstract.a((Object[])set.toArray(new String[0])));
        }
        if (!set2.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] { set2.size(), CommandAbstract.a((Object[])set2.toArray(new String[0])) });
        }
    }
    
    protected void j(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        final ScoreboardTeam a = this.a(array[n++]);
        if (a == null) {
            return;
        }
        final ArrayList list = new ArrayList<String>(a.getPlayerNameSet());
        if (list.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { a.getName() });
        }
        final Iterator<String> iterator = (Iterator<String>)list.iterator();
        while (iterator.hasNext()) {
            d.removePlayerFromTeam(iterator.next(), a);
        }
        CommandAbstract.a(commandListener, this, "commands.scoreboard.teams.empty.success", list.size(), a.getName());
    }
    
    protected void h(final ICommandListener commandListener, final String s) {
        this.d().unregisterObjective(this.a(s, false));
        CommandAbstract.a(commandListener, this, "commands.scoreboard.objectives.remove.success", s);
    }
    
    protected void d(final ICommandListener commandListener) {
        final Collection objectives = this.d().getObjectives();
        if (objectives.size() > 0) {
            final ChatMessage chatMessage = new ChatMessage("commands.scoreboard.objectives.list.count", new Object[] { objectives.size() });
            chatMessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
            commandListener.sendMessage(chatMessage);
            for (final ScoreboardObjective scoreboardObjective : objectives) {
                commandListener.sendMessage(new ChatMessage("commands.scoreboard.objectives.list.entry", new Object[] { scoreboardObjective.getName(), scoreboardObjective.getDisplayName(), scoreboardObjective.getCriteria().getName() }));
            }
            return;
        }
        throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
    }
    
    protected void k(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        final String s = array[n++];
        final int slotForName = Scoreboard.getSlotForName(s);
        ScoreboardObjective a = null;
        if (array.length == 4) {
            a = this.a(array[n++], false);
        }
        if (slotForName < 0) {
            throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { s });
        }
        d.setDisplaySlot(slotForName, a);
        if (a != null) {
            CommandAbstract.a(commandListener, this, "commands.scoreboard.objectives.setdisplay.successSet", Scoreboard.getSlotName(slotForName), a.getName());
        }
        else {
            CommandAbstract.a(commandListener, this, "commands.scoreboard.objectives.setdisplay.successCleared", Scoreboard.getSlotName(slotForName));
        }
    }
    
    protected void l(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        if (array.length > n) {
            final String e = CommandAbstract.e(commandListener, array[n++]);
            final Map playerObjectives = d.getPlayerObjectives(e);
            if (playerObjectives.size() <= 0) {
                throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] { e });
            }
            final ChatMessage chatMessage = new ChatMessage("commands.scoreboard.players.list.player.count", new Object[] { playerObjectives.size(), e });
            chatMessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
            commandListener.sendMessage(chatMessage);
            for (final ScoreboardScore scoreboardScore : playerObjectives.values()) {
                commandListener.sendMessage(new ChatMessage("commands.scoreboard.players.list.player.entry", new Object[] { scoreboardScore.getScore(), scoreboardScore.getObjective().getDisplayName(), scoreboardScore.getObjective().getName() }));
            }
        }
        else {
            final Collection players = d.getPlayers();
            if (players.size() <= 0) {
                throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
            }
            final ChatMessage chatMessage2 = new ChatMessage("commands.scoreboard.players.list.count", new Object[] { players.size() });
            chatMessage2.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
            commandListener.sendMessage(chatMessage2);
            commandListener.sendMessage(new ChatComponentText(CommandAbstract.a(players.toArray())));
        }
    }
    
    protected void m(final ICommandListener commandListener, final String[] array, int n) {
        final String s = array[n - 1];
        final String e = CommandAbstract.e(commandListener, array[n++]);
        final ScoreboardObjective a = this.a(array[n++], true);
        final int score = s.equalsIgnoreCase("set") ? CommandAbstract.a(commandListener, array[n++]) : CommandAbstract.a(commandListener, array[n++], 1);
        final ScoreboardScore playerScoreForObjective = this.d().getPlayerScoreForObjective(e, a);
        if (s.equalsIgnoreCase("set")) {
            playerScoreForObjective.setScore(score);
        }
        else if (s.equalsIgnoreCase("add")) {
            playerScoreForObjective.addScore(score);
        }
        else {
            playerScoreForObjective.removeScore(score);
        }
        CommandAbstract.a(commandListener, this, "commands.scoreboard.players.set.success", a.getName(), e, playerScoreForObjective.getScore());
    }
    
    protected void n(final ICommandListener commandListener, final String[] array, int n) {
        final Scoreboard d = this.d();
        final String e = CommandAbstract.e(commandListener, array[n++]);
        d.resetPlayerScores(e);
        CommandAbstract.a(commandListener, this, "commands.scoreboard.players.reset.success", e);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "objectives", "players", "teams");
        }
        if (array[0].equalsIgnoreCase("objectives")) {
            if (array.length == 2) {
                return CommandAbstract.a(array, "list", "add", "remove", "setdisplay");
            }
            if (array[1].equalsIgnoreCase("add")) {
                if (array.length == 4) {
                    return CommandAbstract.a(array, IScoreboardCriteria.criteria.keySet());
                }
            }
            else if (array[1].equalsIgnoreCase("remove")) {
                if (array.length == 3) {
                    return CommandAbstract.a(array, this.a(false));
                }
            }
            else if (array[1].equalsIgnoreCase("setdisplay")) {
                if (array.length == 3) {
                    return CommandAbstract.a(array, "list", "sidebar", "belowName");
                }
                if (array.length == 4) {
                    return CommandAbstract.a(array, this.a(false));
                }
            }
        }
        else if (array[0].equalsIgnoreCase("players")) {
            if (array.length == 2) {
                return CommandAbstract.a(array, "set", "add", "remove", "reset", "list");
            }
            if (array[1].equalsIgnoreCase("set") || array[1].equalsIgnoreCase("add") || array[1].equalsIgnoreCase("remove")) {
                if (array.length == 3) {
                    return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
                }
                if (array.length == 4) {
                    return CommandAbstract.a(array, this.a(true));
                }
            }
            else if ((array[1].equalsIgnoreCase("reset") || array[1].equalsIgnoreCase("list")) && array.length == 3) {
                return CommandAbstract.a(array, this.d().getPlayers());
            }
        }
        else if (array[0].equalsIgnoreCase("teams")) {
            if (array.length == 2) {
                return CommandAbstract.a(array, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if (array[1].equalsIgnoreCase("join")) {
                if (array.length == 3) {
                    return CommandAbstract.a(array, this.d().getTeamNames());
                }
                if (array.length >= 4) {
                    return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
                }
            }
            else {
                if (array[1].equalsIgnoreCase("leave")) {
                    return CommandAbstract.a(array, MinecraftServer.getServer().getPlayers());
                }
                if (array[1].equalsIgnoreCase("empty") || array[1].equalsIgnoreCase("list") || array[1].equalsIgnoreCase("remove")) {
                    if (array.length == 3) {
                        return CommandAbstract.a(array, this.d().getTeamNames());
                    }
                }
                else if (array[1].equalsIgnoreCase("option")) {
                    if (array.length == 3) {
                        return CommandAbstract.a(array, this.d().getTeamNames());
                    }
                    if (array.length == 4) {
                        return CommandAbstract.a(array, "color", "friendlyfire", "seeFriendlyInvisibles");
                    }
                    if (array.length == 5) {
                        if (array[3].equalsIgnoreCase("color")) {
                            return CommandAbstract.a(array, EnumChatFormat.a(true, false));
                        }
                        if (array[3].equalsIgnoreCase("friendlyfire") || array[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
                            return CommandAbstract.a(array, "true", "false");
                        }
                    }
                }
            }
        }
        return null;
    }
    
    protected List a(final boolean b) {
        final Collection objectives = this.d().getObjectives();
        final ArrayList<String> list = new ArrayList<String>();
        for (final ScoreboardObjective scoreboardObjective : objectives) {
            if (!b || !scoreboardObjective.getCriteria().isReadOnly()) {
                list.add(scoreboardObjective.getName());
            }
        }
        return list;
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        if (array[0].equalsIgnoreCase("players")) {
            return n == 2;
        }
        return array[0].equalsIgnoreCase("teams") && (n == 2 || n == 3);
    }
}
