package net.minecraft.server;

import java.util.concurrent.*;

public class CrashReportPlayerCount implements Callable
{
    final /* synthetic */ MinecraftServer a;
    
    public CrashReportPlayerCount(final MinecraftServer a) {
        this.a = a;
    }
    
    public String a() {
        return MinecraftServer.a(this.a).getPlayerCount() + " / " + MinecraftServer.a(this.a).getMaxPlayers() + "; " + MinecraftServer.a(this.a).players;
    }
}
