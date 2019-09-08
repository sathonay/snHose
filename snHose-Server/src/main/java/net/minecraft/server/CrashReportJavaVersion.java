package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportJavaVersion implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportJavaVersion(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
    }
}
