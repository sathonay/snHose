package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class PacketPlayOutStatistic extends Packet
{
    private Map a;
    
    public PacketPlayOutStatistic() {
    }
    
    public PacketPlayOutStatistic(final Map a) {
        this.a = a;
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        final int a = packetDataSerializer.a();
        this.a = Maps.newHashMap();
        for (int i = 0; i < a; ++i) {
            final Statistic statistic = StatisticList.getStatistic(packetDataSerializer.c(32767));
            final int a2 = packetDataSerializer.a();
            if (statistic != null) {
                this.a.put(statistic, a2);
            }
        }
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a.size());
        for (final Map.Entry<Statistic, V> entry : this.a.entrySet()) {
            packetDataSerializer.a(entry.getKey().name);
            packetDataSerializer.b((int)entry.getValue());
        }
    }
    
    @Override
    public String b() {
        return String.format("count=%d", this.a.size());
    }
}
