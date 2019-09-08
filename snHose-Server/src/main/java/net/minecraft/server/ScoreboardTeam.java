package net.minecraft.server.v1_7_R4;

import java.util.*;

public class ScoreboardTeam extends ScoreboardTeamBase
{
    private final Scoreboard a;
    private final String b;
    private final Set c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    
    public ScoreboardTeam(final Scoreboard a, final String s) {
        this.c = new HashSet();
        this.e = "";
        this.f = "";
        this.g = true;
        this.h = true;
        this.a = a;
        this.b = s;
        this.d = s;
    }
    
    @Override
    public String getName() {
        return this.b;
    }
    
    public String getDisplayName() {
        return this.d;
    }
    
    public void setDisplayName(final String d) {
        if (d == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.d = d;
        this.a.handleTeamChanged(this);
    }
    
    public Collection getPlayerNameSet() {
        return this.c;
    }
    
    public String getPrefix() {
        return this.e;
    }
    
    public void setPrefix(final String e) {
        if (e == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        this.e = e;
        this.a.handleTeamChanged(this);
    }
    
    public String getSuffix() {
        return this.f;
    }
    
    public void setSuffix(final String f) {
        if (f == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }
        this.f = f;
        this.a.handleTeamChanged(this);
    }
    
    @Override
    public String getFormattedName(final String s) {
        return this.getPrefix() + s + this.getSuffix();
    }
    
    public static String getPlayerDisplayName(final ScoreboardTeamBase scoreboardTeamBase, final String s) {
        if (scoreboardTeamBase == null) {
            return s;
        }
        return scoreboardTeamBase.getFormattedName(s);
    }
    
    @Override
    public boolean allowFriendlyFire() {
        return this.g;
    }
    
    public void setAllowFriendlyFire(final boolean g) {
        this.g = g;
        this.a.handleTeamChanged(this);
    }
    
    public boolean canSeeFriendlyInvisibles() {
        return this.h;
    }
    
    public void setCanSeeFriendlyInvisibles(final boolean h) {
        this.h = h;
        this.a.handleTeamChanged(this);
    }
    
    public int packOptionData() {
        int n = 0;
        if (this.allowFriendlyFire()) {
            n |= 0x1;
        }
        if (this.canSeeFriendlyInvisibles()) {
            n |= 0x2;
        }
        return n;
    }
}
