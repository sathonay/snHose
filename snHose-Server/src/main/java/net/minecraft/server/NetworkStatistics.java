package net.minecraft.server.v1_7_R4;

import org.apache.logging.log4j.*;

public class NetworkStatistics
{
    private static final Logger a;
    private static final Marker b;
    private PacketStatisticsTracker c;
    private PacketStatisticsTracker d;
    
    public NetworkStatistics() {
        this.c = new PacketStatisticsTracker();
        this.d = new PacketStatisticsTracker();
    }
    
    public void a(final int n, final long n2) {
        this.c.a(n, n2);
    }
    
    public void b(final int n, final long n2) {
        this.d.a(n, n2);
    }
    
    public long a() {
        return this.c.a();
    }
    
    public long b() {
        return this.d.a();
    }
    
    public long c() {
        return this.c.b();
    }
    
    public long d() {
        return this.d.b();
    }
    
    public PacketStatistics e() {
        return this.c.c();
    }
    
    public PacketStatistics f() {
        return this.c.d();
    }
    
    public PacketStatistics g() {
        return this.d.c();
    }
    
    public PacketStatistics h() {
        return this.d.d();
    }
    
    public PacketStatistics a(final int n) {
        return this.c.a(n);
    }
    
    public PacketStatistics b(final int n) {
        return this.d.a(n);
    }
    
    static {
        a = LogManager.getLogger();
        b = MarkerManager.getMarker("NETSTAT_MARKER", NetworkManager.c);
    }
}
