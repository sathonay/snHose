package net.minecraft.server;

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
