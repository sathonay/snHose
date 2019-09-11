package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportConnectionPacketClass implements Callable
{
    final /* synthetic */ Packet a;
    final /* synthetic */ PlayerConnection b;
    
    CrashReportConnectionPacketClass(final PlayerConnection b, final Packet a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        return this.a.getClass().getCanonicalName();
    }
}
