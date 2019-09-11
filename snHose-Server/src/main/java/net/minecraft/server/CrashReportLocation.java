package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLocation implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Chunk d;
    
    CrashReportLocation(final Chunk d, final int a, final int b, final int c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String a() {
        return CrashReportSystemDetails.a(this.a, this.b, this.c);
    }
}
