package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportAABBPoolSize implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportAABBPoolSize(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        final int n = 0;
        final int n2 = 56 * n;
        final int n3 = n2 / 1024 / 1024;
        final int n4 = 0;
        final int n5 = 56 * n4;
        return n + " (" + n2 + " bytes; " + n3 + " MB) allocated, " + n4 + " (" + n5 + " bytes; " + n5 / 1024 / 1024 + " MB) used";
    }
}
