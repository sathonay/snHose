package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelTime implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelTime(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.format("%d game time, %d day time", WorldData.g(this.a), WorldData.h(this.a));
    }
}
