package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportLevelSeed implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelSeed(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.valueOf(this.a.getSeed());
    }
}
