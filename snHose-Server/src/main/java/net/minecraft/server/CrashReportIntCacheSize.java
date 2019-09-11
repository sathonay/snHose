package net.minecraft.server;

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
