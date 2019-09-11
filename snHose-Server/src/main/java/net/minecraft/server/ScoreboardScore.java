package net.minecraft.server;

import java.util.*;

public class ScoreboardScore
{
    public static final Comparator a;
    private final Scoreboard b;
    private final ScoreboardObjective c;
    private final String playerName;
    private int score;
    
    public ScoreboardScore(final Scoreboard b, final ScoreboardObjective c, final String playerName) {
        this.b = b;
        this.c = c;
        this.playerName = playerName;
    }
    
    public void addScore(final int n) {
        if (this.c.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScore(this.getScore() + n);
    }
    
    public void removeScore(final int n) {
        if (this.c.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScore(this.getScore() - n);
    }
    
    public void incrementScore() {
        if (this.c.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.addScore(1);
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(final int score) {
        final int score2 = this.score;
        this.score = score;
        if (score2 != score) {
            this.f().handleScoreChanged(this);
        }
    }
    
    public ScoreboardObjective getObjective() {
        return this.c;
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public Scoreboard f() {
        return this.b;
    }
    
    public void updateForList(final List list) {
        this.setScore(this.c.getCriteria().getScoreModifier(list));
    }
    
    static {
        a = new ScoreboardComparator();
    }
}
