package net.minecraft.server;

import java.util.*;

final class ScoreboardComparator implements Comparator<ScoreboardScore>
{
    public int a(final ScoreboardScore scoreboardScore, final ScoreboardScore scoreboardScore2) {
        if (scoreboardScore.getScore() > scoreboardScore2.getScore()) {
            return 1;
        }
        if (scoreboardScore.getScore() < scoreboardScore2.getScore()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int compare(ScoreboardScore o1, ScoreboardScore o2) {
        return this.a(o1, o2);
    }
}
