package net.minecraft.server.v1_7_R4;

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
