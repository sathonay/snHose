package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportPlayers implements Callable
{
    final /* synthetic */ World a;
    
    CrashReportPlayers(final World a) {
        this.a = a;
    }
    
    public String a() {
        return this.a.players.size() + " total; " + this.a.players.toString();
    }
}
