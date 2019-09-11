package net.minecraft.server;

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
