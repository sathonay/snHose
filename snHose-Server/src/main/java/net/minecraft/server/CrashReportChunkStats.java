package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportChunkStats implements Callable
{
    final /* synthetic */ World a;
    
    CrashReportChunkStats(final World a) {
        this.a = a;
    }
    
    public String a() {
        return this.a.chunkProvider.getName();
    }
}
