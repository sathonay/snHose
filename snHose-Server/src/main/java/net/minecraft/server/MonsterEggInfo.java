package net.minecraft.server.v1_7_R4;

public class MonsterEggInfo
{
    public final int a;
    public final int b;
    public final int c;
    public final Statistic killEntityStatistic;
    public final Statistic e;
    
    public MonsterEggInfo(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.killEntityStatistic = StatisticList.a(this);
        this.e = StatisticList.b(this);
    }
}
