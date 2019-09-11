package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportOperatingSystem implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportOperatingSystem(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
    }
}
