package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelGameMode implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelGameMode(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", WorldData.o(this.a).b(), WorldData.o(this.a).getId(), WorldData.p(this.a), WorldData.q(this.a));
    }
}
