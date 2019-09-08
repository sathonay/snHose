package net.minecraft.server.v1_7_R4;

import java.util.*;

public class ScoreboardHealthCriteria extends ScoreboardBaseCriteria
{
    public ScoreboardHealthCriteria(final String s) {
        super(s);
    }
    
    @Override
    public int getScoreModifier(final List list) {
        float var0 = 0.0f;
        for (final EntityHuman entityHuman : list) {
            var0 += entityHuman.getHealth() + entityHuman.getAbsorptionHearts();
        }
        if (list.size() > 0) {
            var0 /= list.size();
        }
        return MathHelper.f(var0);
    }
    
    @Override
    public boolean isReadOnly() {
        return true;
    }
}
