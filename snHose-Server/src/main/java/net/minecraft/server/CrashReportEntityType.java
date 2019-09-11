package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportEntityType implements Callable
{
    final /* synthetic */ Entity a;
    
    CrashReportEntityType(final Entity a) {
        this.a = a;
    }
    
    public String a() {
        return EntityTypes.b(this.a) + " (" + this.a.getClass().getCanonicalName() + ")";
    }
}
