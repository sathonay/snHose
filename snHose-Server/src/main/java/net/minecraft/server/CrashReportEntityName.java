package net.minecraft.server;

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
