package net.minecraft.server.v1_7_R4;

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
