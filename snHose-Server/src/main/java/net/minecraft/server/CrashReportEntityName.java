package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportEntityName implements Callable
{
    final /* synthetic */ Entity a;
    
    CrashReportEntityName(final Entity a) {
        this.a = a;
    }
    
    public String a() {
        return this.a.getName();
    }
}
