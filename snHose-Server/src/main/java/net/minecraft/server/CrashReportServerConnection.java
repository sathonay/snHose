package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportServerConnection implements Callable
{
    final /* synthetic */ NetworkManager a;
    final /* synthetic */ ServerConnection b;
    
    CrashReportServerConnection(final ServerConnection b, final NetworkManager a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        return this.a.toString();
    }
}
