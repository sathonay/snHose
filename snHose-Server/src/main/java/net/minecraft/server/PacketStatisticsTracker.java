package net.minecraft.server.v1_7_R4;

import java.util.concurrent.atomic.*;
import org.apache.logging.log4j.*;

class PacketStatisticsTracker
{
    private AtomicReference[] a;
    
    public PacketStatisticsTracker() {
        this.a = new AtomicReference[100];
        for (int i = 0; i < 100; ++i) {
            this.a[i] = new AtomicReference((V)new PackStatisticData(0L, 0, 0.0, null));
        }
    }
    
    public void a(final int n, final long n2) {
        try {
            if (n < 0 || n >= 100) {
                return;
            }
            PackStatisticData packStatisticData;
            do {
                packStatisticData = this.a[n].get();
            } while (!this.a[n].compareAndSet(packStatisticData, packStatisticData.a(n2)));
        }
        catch (Exception ex) {
            if (NetworkStatistics.a.isDebugEnabled()) {
                NetworkStatistics.a.debug(NetworkStatistics.b, "NetStat failed with packetId: " + n, ex);
            }
        }
    }
    
    public long a() {
        long n = 0L;
        for (int i = 0; i < 100; ++i) {
            n += ((PackStatisticData)this.a[i].get()).a();
        }
        return n;
    }
    
    public long b() {
        long n = 0L;
        for (int i = 0; i < 100; ++i) {
            n += ((PackStatisticData)this.a[i].get()).b();
        }
        return n;
    }
    
    public PacketStatistics c() {
        int n = -1;
        PackStatisticData packStatisticData = new PackStatisticData(-1L, -1, 0.0, null);
        for (int i = 0; i < 100; ++i) {
            final PackStatisticData packStatisticData2 = this.a[i].get();
            if (packStatisticData2.a > packStatisticData.a) {
                n = i;
                packStatisticData = packStatisticData2;
            }
        }
        return new PacketStatistics(n, packStatisticData);
    }
    
    public PacketStatistics d() {
        int n = -1;
        PackStatisticData packStatisticData = new PackStatisticData(-1L, -1, 0.0, null);
        for (int i = 0; i < 100; ++i) {
            final PackStatisticData packStatisticData2 = this.a[i].get();
            if (packStatisticData2.b > packStatisticData.b) {
                n = i;
                packStatisticData = packStatisticData2;
            }
        }
        return new PacketStatistics(n, packStatisticData);
    }
    
    public PacketStatistics a(final int n) {
        if (n < 0 || n >= 100) {
            return null;
        }
        return new PacketStatistics(n, this.a[n].get());
    }
}
