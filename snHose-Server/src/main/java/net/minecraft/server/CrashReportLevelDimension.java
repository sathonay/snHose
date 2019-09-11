package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelDimension implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelDimension(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.valueOf(WorldData.i(this.a));
    }
}
