package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportWorldLocation implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ World c;
    
    CrashReportWorldLocation(final World c, final int a, final int b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return CrashReportSystemDetails.a(this.a, 0, this.b);
    }
}
