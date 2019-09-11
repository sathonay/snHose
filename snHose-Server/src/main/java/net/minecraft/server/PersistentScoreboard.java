package net.minecraft.server;

import java.util.*;
import org.apache.logging.log4j.*;

public class PersistentScoreboard extends PersistentBase
{
    private static final Logger a;
    private Scoreboard b;
    private NBTTagCompound c;
    
    public PersistentScoreboard() {
        this("scoreboard");
    }
    
    public PersistentScoreboard(final String s) {
        super(s);
    }
    
    public void a(final Scoreboard b) {
        this.b = b;
        if (this.c != null) {
            this.a(this.c);
        }
    }
    
    @Override
    public void a(final NBTTagCompound c) {
        if (this.b == null) {
            this.c = c;
            return;
        }
        this.b(c.getList("Objectives", 10));
        this.c(c.getList("PlayerScores", 10));
        if (c.hasKeyOfType("DisplaySlots", 10)) {
            this.c(c.getCompound("DisplaySlots"));
        }
        if (c.hasKeyOfType("Teams", 9)) {
            this.a(c.getList("Teams", 10));
        }
    }
    
    protected void a(final NBTTagList list) {
        for (int i = 0; i < list.size(); ++i) {
            final NBTTagCompound value = list.get(i);
            final ScoreboardTeam team = this.b.createTeam(value.getString("Name"));
            team.setDisplayName(value.getString("DisplayName"));
            team.setPrefix(value.getString("Prefix"));
            team.setSuffix(value.getString("Suffix"));
            if (value.hasKeyOfType("AllowFriendlyFire", 99)) {
                team.setAllowFriendlyFire(value.getBoolean("AllowFriendlyFire"));
            }
            if (value.hasKeyOfType("SeeFriendlyInvisibles", 99)) {
                team.setCanSeeFriendlyInvisibles(value.getBoolean("SeeFriendlyInvisibles"));
            }
            this.a(team, value.getList("Players", 8));
        }
    }
    
    protected void a(final ScoreboardTeam scoreboardTeam, final NBTTagList list) {
        for (int i = 0; i < list.size(); ++i) {
            this.b.addPlayerToTeam(list.getString(i), scoreboardTeam.getName());
        }
    }
    
    protected void c(final NBTTagCompound nbtTagCompound) {
        for (int i = 0; i < 3; ++i) {
            if (nbtTagCompound.hasKeyOfType("slot_" + i, 8)) {
                this.b.setDisplaySlot(i, this.b.getObjective(nbtTagCompound.getString("slot_" + i)));
            }
        }
    }
    
    protected void b(final NBTTagList list) {
        for (int i = 0; i < list.size(); ++i) {
            final NBTTagCompound value = list.get(i);
            this.b.registerObjective(value.getString("Name"), (IScoreboardCriteria)IScoreboardCriteria.criteria.get(value.getString("CriteriaName"))).setDisplayName(value.getString("DisplayName"));
        }
    }
    
    protected void c(final NBTTagList list) {
        for (int i = 0; i < list.size(); ++i) {
            final NBTTagCompound value = list.get(i);
            this.b.getPlayerScoreForObjective(value.getString("Name"), this.b.getObjective(value.getString("Objective"))).setScore(value.getInt("Score"));
        }
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        if (this.b == null) {
            PersistentScoreboard.a.warn("Tried to save scoreboard without having a scoreboard...");
            return;
        }
        nbtTagCompound.set("Objectives", this.b());
        nbtTagCompound.set("PlayerScores", this.e());
        nbtTagCompound.set("Teams", this.a());
        this.d(nbtTagCompound);
    }
    
    protected NBTTagList a() {
        final NBTTagList list = new NBTTagList();
        for (final ScoreboardTeam scoreboardTeam : this.b.getTeams()) {
            final NBTTagCompound nbtbase = new NBTTagCompound();
            nbtbase.setString("Name", scoreboardTeam.getName());
            nbtbase.setString("DisplayName", scoreboardTeam.getDisplayName());
            nbtbase.setString("Prefix", scoreboardTeam.getPrefix());
            nbtbase.setString("Suffix", scoreboardTeam.getSuffix());
            nbtbase.setBoolean("AllowFriendlyFire", scoreboardTeam.allowFriendlyFire());
            nbtbase.setBoolean("SeeFriendlyInvisibles", scoreboardTeam.canSeeFriendlyInvisibles());
            final NBTTagList list2 = new NBTTagList();
            final Iterator iterator2 = scoreboardTeam.getPlayerNameSet().iterator();
            while (iterator2.hasNext()) {
                list2.add(new NBTTagString(iterator2.next()));
            }
            nbtbase.set("Players", list2);
            list.add(nbtbase);
        }
        return list;
    }
    
    protected void d(final NBTTagCompound nbtTagCompound) {
        final NBTTagCompound nbtTagCompound2 = new NBTTagCompound();
        boolean b = false;
        for (int i = 0; i < 3; ++i) {
            final ScoreboardObjective objectiveForSlot = this.b.getObjectiveForSlot(i);
            if (objectiveForSlot != null) {
                nbtTagCompound2.setString("slot_" + i, objectiveForSlot.getName());
                b = true;
            }
        }
        if (b) {
            nbtTagCompound.set("DisplaySlots", nbtTagCompound2);
        }
    }
    
    protected NBTTagList b() {
        final NBTTagList list = new NBTTagList();
        for (final ScoreboardObjective scoreboardObjective : this.b.getObjectives()) {
            final NBTTagCompound nbtbase = new NBTTagCompound();
            nbtbase.setString("Name", scoreboardObjective.getName());
            nbtbase.setString("CriteriaName", scoreboardObjective.getCriteria().getName());
            nbtbase.setString("DisplayName", scoreboardObjective.getDisplayName());
            list.add(nbtbase);
        }
        return list;
    }
    
    protected NBTTagList e() {
        final NBTTagList list = new NBTTagList();
        for (final ScoreboardScore scoreboardScore : this.b.getScores()) {
            final NBTTagCompound nbtbase = new NBTTagCompound();
            nbtbase.setString("Name", scoreboardScore.getPlayerName());
            nbtbase.setString("Objective", scoreboardScore.getObjective().getName());
            nbtbase.setInt("Score", scoreboardScore.getScore());
            list.add(nbtbase);
        }
        return list;
    }
    
    static {
        a = LogManager.getLogger();
    }
}
