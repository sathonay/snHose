package net.minecraft.server.v1_7_R4;

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
