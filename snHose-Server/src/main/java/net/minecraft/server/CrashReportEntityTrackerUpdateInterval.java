package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportEntityTrackerUpdateInterval implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ EntityTracker b;
    
    CrashReportEntityTrackerUpdateInterval(final EntityTracker b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        String s = "Once per " + this.a + " ticks";
        if (this.a == Integer.MAX_VALUE) {
            s = "Maximum (" + s + ")";
        }
        return s;
    }
}
