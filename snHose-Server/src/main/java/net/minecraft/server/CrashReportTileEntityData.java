package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportTileEntityData implements Callable
{
    final /* synthetic */ TileEntity a;
    
    CrashReportTileEntityData(final TileEntity a) {
        this.a = a;
    }
    
    public String a() {
        final int data = this.a.world.getData(this.a.x, this.a.y, this.a.z);
        if (data < 0) {
            return "Unknown? (Got " + data + ")";
        }
        return String.format("%1$d / 0x%1$X / 0b%2$s", data, String.format("%4s", Integer.toBinaryString(data)).replace(" ", "0"));
    }
}
