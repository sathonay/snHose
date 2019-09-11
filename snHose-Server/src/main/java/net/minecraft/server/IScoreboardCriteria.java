package net.minecraft.server;

import java.util.*;

public interface IScoreboardCriteria
{
    public static final Map criteria = new HashMap();
    public static final IScoreboardCriteria b = new ScoreboardBaseCriteria("dummy");
    public static final IScoreboardCriteria c = new ScoreboardBaseCriteria("deathCount");
    public static final IScoreboardCriteria d = new ScoreboardBaseCriteria("playerKillCount");
    public static final IScoreboardCriteria e = new ScoreboardBaseCriteria("totalKillCount");
    public static final IScoreboardCriteria f = new ScoreboardHealthCriteria("health");
    
    String getName();
    
    int getScoreModifier(final List p0);
    
    boolean isReadOnly();
}
