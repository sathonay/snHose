package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportIntCacheSize implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportIntCacheSize(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        return IntCache.b();
    }
}
