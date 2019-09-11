package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportTileEntityType implements Callable
{
    final /* synthetic */ TileEntity a;
    
    CrashReportTileEntityType(final TileEntity a) {
        this.a = a;
    }
    
    public String a() {
        final int id = Block.getId(this.a.world.getType(this.a.x, this.a.y, this.a.z));
        try {
            return String.format("ID #%d (%s // %s)", id, Block.getById(id).a(), Block.getById(id).getClass().getCanonicalName());
        }
        catch (Throwable t) {
            return "ID #" + id;
        }
    }
}
