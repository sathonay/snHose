package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelSpawnLocation implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelSpawnLocation(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return CrashReportSystemDetails.a(WorldData.d(this.a), WorldData.e(this.a), WorldData.f(this.a));
    }
}
