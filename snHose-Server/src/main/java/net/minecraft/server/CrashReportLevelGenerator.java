package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelGenerator implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelGenerator(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.format("ID %02d - %s, ver %d. Features enabled: %b", WorldData.a(this.a).g(), WorldData.a(this.a).name(), WorldData.a(this.a).getVersion(), WorldData.b(this.a));
    }
}
