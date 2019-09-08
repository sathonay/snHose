package net.minecraft.server.v1_7_R4;

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
