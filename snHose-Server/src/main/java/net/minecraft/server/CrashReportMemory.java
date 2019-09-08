package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportMemory implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportMemory(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        final Runtime runtime = Runtime.getRuntime();
        final long maxMemory = runtime.maxMemory();
        final long totalMemory = runtime.totalMemory();
        final long freeMemory = runtime.freeMemory();
        return freeMemory + " bytes (" + freeMemory / 1024L / 1024L + " MB) / " + totalMemory + " bytes (" + totalMemory / 1024L / 1024L + " MB) up to " + maxMemory + " bytes (" + maxMemory / 1024L / 1024L + " MB)";
    }
}
