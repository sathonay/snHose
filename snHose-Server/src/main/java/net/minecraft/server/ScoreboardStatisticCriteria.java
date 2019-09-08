package net.minecraft.server.v1_7_R4;

public class ScoreboardStatisticCriteria extends ScoreboardBaseCriteria
{
    private final Statistic g;
    
    public ScoreboardStatisticCriteria(final Statistic g) {
        super(g.name);
        this.g = g;
    }
}
