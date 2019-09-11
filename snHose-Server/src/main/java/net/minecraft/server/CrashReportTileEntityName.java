package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportTileEntityName implements Callable
{
    final /* synthetic */ TileEntity a;
    
    CrashReportTileEntityName(final TileEntity a) {
        this.a = a;
    }
    
    public String a() {
        return TileEntity.v().get(this.a.getClass()) + " // " + this.a.getClass().getCanonicalName();
    }
}
