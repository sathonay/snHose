package net.minecraft.server.v1_7_R4;

public abstract class ScoreboardTeamBase
{
    public boolean isAlly(final ScoreboardTeamBase scoreboardTeamBase) {
        return scoreboardTeamBase != null && this == scoreboardTeamBase;
    }
    
    public abstract String getName();
    
    public abstract String getFormattedName(final String p0);
    
    public abstract boolean allowFriendlyFire();
}
