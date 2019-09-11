package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportVersion implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportVersion(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        return "1.7.10";
    }
}
