package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportLevelGeneratorOptions implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelGeneratorOptions(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return WorldData.c(this.a);
    }
}
