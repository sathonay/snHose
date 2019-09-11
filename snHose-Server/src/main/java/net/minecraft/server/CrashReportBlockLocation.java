package net.minecraft.server;

import java.util.concurrent.*;

final class CrashReportBlockLocation implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    
    CrashReportBlockLocation(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String a() {
        return CrashReportSystemDetails.a(this.a, this.b, this.c);
    }
}
