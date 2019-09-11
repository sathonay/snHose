package net.minecraft.server;

public class ScoreboardObjective
{
    private final Scoreboard a;
    private final String b;
    private final IScoreboardCriteria c;
    private String d;
    
    public ScoreboardObjective(final Scoreboard a, final String s, final IScoreboardCriteria c) {
        this.a = a;
        this.b = s;
        this.c = c;
        this.d = s;
    }
    
    public String getName() {
        return this.b;
    }
    
    public IScoreboardCriteria getCriteria() {
        return this.c;
    }
    
    public String getDisplayName() {
        return this.d;
    }
    
    public void setDisplayName(final String d) {
        this.d = d;
        this.a.handleObjectiveChanged(this);
    }
}
