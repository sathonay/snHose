package net.minecraft.server;

public class CounterStatistic extends Statistic
{
    public CounterStatistic(final String s, final IChatBaseComponent chatBaseComponent, final Counter counter) {
        super(s, chatBaseComponent, counter);
    }
    
    public CounterStatistic(final String s, final IChatBaseComponent chatBaseComponent) {
        super(s, chatBaseComponent);
    }
    
    @Override
    public Statistic h() {
        super.h();
        StatisticList.c.add(this);
        return this;
    }
}
