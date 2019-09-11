package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportType implements Callable
{
    final /* synthetic */ DedicatedServer a;
    
    CrashReportType(final DedicatedServer a) {
        this.a = a;
    }
    
    public String a() {
        return "Dedicated Server (map_server.txt)";
    }
}
