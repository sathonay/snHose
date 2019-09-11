package net.minecraft.server;

import java.util.concurrent.*;

public class CrashReportProfilerPosition implements Callable
{
    final /* synthetic */ MinecraftServer a;
    
    public CrashReportProfilerPosition(final MinecraftServer a) {
        this.a = a;
    }
    
    public String a() {
        return this.a.methodProfiler.a ? this.a.methodProfiler.c() : "N/A (disabled)";
    }
}
