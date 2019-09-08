package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportStructureType implements Callable
{
    final /* synthetic */ StructureGenerator a;
    
    CrashReportStructureType(final StructureGenerator a) {
        this.a = a;
    }
    
    public String a() {
        return this.a.getClass().getCanonicalName();
    }
}
