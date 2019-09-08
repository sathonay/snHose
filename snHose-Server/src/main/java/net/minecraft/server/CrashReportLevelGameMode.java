package net.minecraft.server.v1_7_R4;

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
