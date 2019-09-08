package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportChunkPosHash implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ StructureGenerator c;
    
    CrashReportChunkPosHash(final StructureGenerator c, final int a, final int b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return String.valueOf(ChunkCoordIntPair.a(this.a, this.b));
    }
}
