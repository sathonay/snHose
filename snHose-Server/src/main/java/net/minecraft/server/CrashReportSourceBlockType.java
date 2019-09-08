package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportSourceBlockType implements Callable
{
    final /* synthetic */ Block a;
    final /* synthetic */ World b;
    
    CrashReportSourceBlockType(final World b, final Block a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        try {
            return String.format("ID #%d (%s // %s)", Block.getId(this.a), this.a.a(), this.a.getClass().getCanonicalName());
        }
        catch (Throwable t) {
            return "ID #" + Block.getId(this.a);
        }
    }
}
