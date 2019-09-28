package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.*;

import java.io.IOException;
import java.util.*;

public class PacketPlayOutStatistic extends Packet
{
    private Map<Statistic, Integer> a;
    
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
            final Statistic statistic;
            try {
                statistic = StatisticList.getStatistic(packetDataSerializer.c(32767));
                final int a2 = packetDataSerializer.a();
                if (statistic != null) {
                    this.a.put(statistic, a2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.b(this.a.size());
        for (final Map.Entry<Statistic, Integer> entry : this.a.entrySet()) {
            try {
                packetDataSerializer.a(entry.getKey().name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            packetDataSerializer.b(entry.getValue());
        }
    }

    @Override
    public void handle(PacketListener packetlistener) {
        this.a((PacketPlayOutListener) packetlistener);
    }

    @Override
    public String b() {
        return String.format("count=%d", this.a.size());
    }
}
