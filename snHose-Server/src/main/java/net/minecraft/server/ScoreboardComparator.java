package net.minecraft.server.v1_7_R4;

import java.util.*;

final class ScoreboardComparator implements Comparator
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
}
