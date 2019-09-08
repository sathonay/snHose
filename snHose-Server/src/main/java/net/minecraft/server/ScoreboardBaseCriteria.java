package net.minecraft.server.v1_7_R4;

import java.util.*;

public class ScoreboardBaseCriteria implements IScoreboardCriteria
{
    private final String g;
    
    public ScoreboardBaseCriteria(final String g) {
        this.g = g;
        IScoreboardCriteria.criteria.put(g, this);
    }
    
    @Override
    public String getName() {
        return this.g;
    }
    
    @Override
    public int getScoreModifier(final List list) {
        return 0;
    }
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
}
