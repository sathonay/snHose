package net.minecraft.server;

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
