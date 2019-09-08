package net.minecraft.server.v1_7_R4;

import java.util.*;

public class Scoreboard
{
    private final Map objectivesByName;
    private final Map objectivesByCriteria;
    private final Map playerScores;
    private final ScoreboardObjective[] displaySlots;
    private final Map teamsByName;
    private final Map teamsByPlayer;
    
    public Scoreboard() {
        this.objectivesByName = new HashMap();
        this.objectivesByCriteria = new HashMap();
        this.playerScores = new HashMap();
        this.displaySlots = new ScoreboardObjective[3];
        this.teamsByName = new HashMap();
        this.teamsByPlayer = new HashMap();
    }
    
    public ScoreboardObjective getObjective(final String s) {
        return this.objectivesByName.get(s);
    }
    
    public ScoreboardObjective registerObjective(final String s, final IScoreboardCriteria scoreboardCriteria) {
        if (this.getObjective(s) != null) {
            throw new IllegalArgumentException("An objective with the name '" + s + "' already exists!");
        }
        final ScoreboardObjective scoreboardObjective = new ScoreboardObjective(this, s, scoreboardCriteria);
        List<ScoreboardObjective> list = this.objectivesByCriteria.get(scoreboardCriteria);
        if (list == null) {
            list = new ArrayList<ScoreboardObjective>();
            this.objectivesByCriteria.put(scoreboardCriteria, list);
        }
        list.add(scoreboardObjective);
        this.objectivesByName.put(s, scoreboardObjective);
        this.handleObjectiveAdded(scoreboardObjective);
        return scoreboardObjective;
    }
    
    public Collection getObjectivesForCriteria(final IScoreboardCriteria scoreboardCriteria) {
        final Collection collection = this.objectivesByCriteria.get(scoreboardCriteria);
        return (collection == null) ? new ArrayList() : new ArrayList(collection);
    }
    
    public ScoreboardScore getPlayerScoreForObjective(final String s, final ScoreboardObjective scoreboardObjective) {
        Object o = this.playerScores.get(s);
        if (o == null) {
            o = new HashMap<String, ScoreboardScore>();
            this.playerScores.put(s, o);
        }
        ScoreboardScore scoreboardScore = ((Map<String, ScoreboardScore>)o).get(scoreboardObjective);
        if (scoreboardScore == null) {
            scoreboardScore = new ScoreboardScore(this, scoreboardObjective, s);
            ((Map<String, ScoreboardScore>)o).put((String)scoreboardObjective, scoreboardScore);
        }
        return scoreboardScore;
    }
    
    public Collection getScoresForObjective(final ScoreboardObjective scoreboardObjective) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<Map<Object, ScoreboardScore>> iterator = this.playerScores.values().iterator();
        while (iterator.hasNext()) {
            final ScoreboardScore scoreboardScore = iterator.next().get(scoreboardObjective);
            if (scoreboardScore != null) {
                list.add(scoreboardScore);
            }
        }
        Collections.sort(list, ScoreboardScore.a);
        return list;
    }
    
    public Collection getObjectives() {
        return this.objectivesByName.values();
    }
    
    public Collection getPlayers() {
        return this.playerScores.keySet();
    }
    
    public void resetPlayerScores(final String s) {
        if (this.playerScores.remove(s) != null) {
            this.handlePlayerRemoved(s);
        }
    }
    
    public Collection getScores() {
        final Collection<Map<Object, ? extends E>> values = this.playerScores.values();
        final ArrayList list = new ArrayList();
        final Iterator<Map<Object, ? extends E>> iterator = values.iterator();
        while (iterator.hasNext()) {
            list.addAll(iterator.next().values());
        }
        return list;
    }
    
    public Map getPlayerObjectives(final String s) {
        Map map = this.playerScores.get(s);
        if (map == null) {
            map = new HashMap();
        }
        return map;
    }
    
    public void unregisterObjective(final ScoreboardObjective scoreboardObjective) {
        this.objectivesByName.remove(scoreboardObjective.getName());
        for (int i = 0; i < 3; ++i) {
            if (this.getObjectiveForSlot(i) == scoreboardObjective) {
                this.setDisplaySlot(i, null);
            }
        }
        final List list = this.objectivesByCriteria.get(scoreboardObjective.getCriteria());
        if (list != null) {
            list.remove(scoreboardObjective);
        }
        final Iterator<Map> iterator = this.playerScores.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().remove(scoreboardObjective);
        }
        this.handleObjectiveRemoved(scoreboardObjective);
    }
    
    public void setDisplaySlot(final int n, final ScoreboardObjective scoreboardObjective) {
        this.displaySlots[n] = scoreboardObjective;
    }
    
    public ScoreboardObjective getObjectiveForSlot(final int n) {
        return this.displaySlots[n];
    }
    
    public ScoreboardTeam getTeam(final String s) {
        return this.teamsByName.get(s);
    }
    
    public ScoreboardTeam createTeam(final String s) {
        if (this.getTeam(s) != null) {
            throw new IllegalArgumentException("A team with the name '" + s + "' already exists!");
        }
        final ScoreboardTeam scoreboardTeam = new ScoreboardTeam(this, s);
        this.teamsByName.put(s, scoreboardTeam);
        this.handleTeamAdded(scoreboardTeam);
        return scoreboardTeam;
    }
    
    public void removeTeam(final ScoreboardTeam scoreboardTeam) {
        this.teamsByName.remove(scoreboardTeam.getName());
        final Iterator<String> iterator = scoreboardTeam.getPlayerNameSet().iterator();
        while (iterator.hasNext()) {
            this.teamsByPlayer.remove(iterator.next());
        }
        this.handleTeamRemoved(scoreboardTeam);
    }
    
    public boolean addPlayerToTeam(final String s, final String s2) {
        if (!this.teamsByName.containsKey(s2)) {
            return false;
        }
        final ScoreboardTeam team = this.getTeam(s2);
        if (this.getPlayerTeam(s) != null) {
            this.removePlayerFromTeam(s);
        }
        this.teamsByPlayer.put(s, team);
        team.getPlayerNameSet().add(s);
        return true;
    }
    
    public boolean removePlayerFromTeam(final String s) {
        final ScoreboardTeam playerTeam = this.getPlayerTeam(s);
        if (playerTeam != null) {
            this.removePlayerFromTeam(s, playerTeam);
            return true;
        }
        return false;
    }
    
    public void removePlayerFromTeam(final String s, final ScoreboardTeam scoreboardTeam) {
        if (this.getPlayerTeam(s) != scoreboardTeam) {
            throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + scoreboardTeam.getName() + "'.");
        }
        this.teamsByPlayer.remove(s);
        scoreboardTeam.getPlayerNameSet().remove(s);
    }
    
    public Collection getTeamNames() {
        return this.teamsByName.keySet();
    }
    
    public Collection getTeams() {
        return this.teamsByName.values();
    }
    
    public ScoreboardTeam getPlayerTeam(final String s) {
        return this.teamsByPlayer.get(s);
    }
    
    public void handleObjectiveAdded(final ScoreboardObjective scoreboardObjective) {
    }
    
    public void handleObjectiveChanged(final ScoreboardObjective scoreboardObjective) {
    }
    
    public void handleObjectiveRemoved(final ScoreboardObjective scoreboardObjective) {
    }
    
    public void handleScoreChanged(final ScoreboardScore scoreboardScore) {
    }
    
    public void handlePlayerRemoved(final String s) {
    }
    
    public void handleTeamAdded(final ScoreboardTeam scoreboardTeam) {
    }
    
    public void handleTeamChanged(final ScoreboardTeam scoreboardTeam) {
    }
    
    public void handleTeamRemoved(final ScoreboardTeam scoreboardTeam) {
    }
    
    public static String getSlotName(final int n) {
        switch (n) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
            default: {
                return null;
            }
        }
    }
    
    public static int getSlotForName(final String s) {
        if (s.equalsIgnoreCase("list")) {
            return 0;
        }
        if (s.equalsIgnoreCase("sidebar")) {
            return 1;
        }
        if (s.equalsIgnoreCase("belowName")) {
            return 2;
        }
        return -1;
    }
}
