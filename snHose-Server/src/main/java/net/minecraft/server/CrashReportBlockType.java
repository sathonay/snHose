package net.minecraft.server;

import java.util.concurrent.*;

final class CrashReportBlockType implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ Block b;
    
    CrashReportBlockType(final int a, final Block b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        try {
            return String.format("ID #%d (%s // %s)", this.a, this.b.a(), this.b.getClass().getCanonicalName());
        }
        catch (Throwable t) {
            return "ID #" + this.a;
        }
    }
}
