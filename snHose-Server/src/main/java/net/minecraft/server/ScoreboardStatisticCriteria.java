package net.minecraft.server;

public class ScoreboardStatisticCriteria extends ScoreboardBaseCriteria
{
    private final Statistic g;
    
    public ScoreboardStatisticCriteria(final Statistic g) {
        super(g.name);
        this.g = g;
    }
}
