package net.minecraft.server;

public class PacketStatistics
{
    private final int a;
    private final PackStatisticData b;
    
    public PacketStatistics(final int a, final PackStatisticData b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        return "PacketStat(" + this.a + ")" + this.b;
    }
}
