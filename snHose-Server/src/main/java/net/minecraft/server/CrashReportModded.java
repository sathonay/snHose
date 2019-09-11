package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportModded implements Callable
{
    final /* synthetic */ DedicatedServer a;
    
    CrashReportModded(final DedicatedServer a) {
        this.a = a;
    }
    
    public String a() {
        final String serverModName = this.a.getServerModName();
        if (!serverModName.equals("vanilla")) {
            return "Definitely; Server brand changed to '" + serverModName + "'";
        }
        return "Unknown (can't tell)";
    }
}
