package net.minecraft.server.v1_7_R4;

import java.text.*;
import java.util.*;

public class Statistic
{
    public final String name;
    private final IChatBaseComponent a;
    public boolean f;
    private final Counter b;
    private final IScoreboardCriteria c;
    private Class d;
    private static NumberFormat k;
    public static Counter g;
    private static DecimalFormat l;
    public static Counter h;
    public static Counter i;
    public static Counter j;
    
    public Statistic(final String name, final IChatBaseComponent a, final Counter b) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = new ScoreboardStatisticCriteria(this);
        IScoreboardCriteria.criteria.put(this.c.getName(), this.c);
    }
    
    public Statistic(final String s, final IChatBaseComponent chatBaseComponent) {
        this(s, chatBaseComponent, Statistic.g);
    }
    
    public Statistic i() {
        this.f = true;
        return this;
    }
    
    public Statistic h() {
        if (StatisticList.a.containsKey(this.name)) {
            throw new RuntimeException("Duplicate stat id: \"" + StatisticList.a.get(this.name).a + "\" and \"" + this.a + "\" at id " + this.name);
        }
        StatisticList.stats.add(this);
        StatisticList.a.put(this.name, this);
        return this;
    }
    
    public boolean d() {
        return false;
    }
    
    public IChatBaseComponent e() {
        final IChatBaseComponent f = this.a.f();
        f.getChatModifier().setColor(EnumChatFormat.GRAY);
        f.getChatModifier().a(new ChatHoverable(EnumHoverAction.SHOW_ACHIEVEMENT, new ChatComponentText(this.name)));
        return f;
    }
    
    public IChatBaseComponent j() {
        final IChatBaseComponent e = this.e();
        final IChatBaseComponent a = new ChatComponentText("[").addSibling(e).a("]");
        a.setChatModifier(e.getChatModifier());
        return a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.name.equals(((Statistic)o).name));
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public String toString() {
        return "Stat{id=" + this.name + ", nameId=" + this.a + ", awardLocallyOnly=" + this.f + ", formatter=" + this.b + ", objectiveCriteria=" + this.c + '}';
    }
    
    public IScoreboardCriteria k() {
        return this.c;
    }
    
    public Class l() {
        return this.d;
    }
    
    public Statistic b(final Class d) {
        this.d = d;
        return this;
    }
    
    static {
        Statistic.k = NumberFormat.getIntegerInstance(Locale.US);
        Statistic.g = new UnknownCounter();
        Statistic.l = new DecimalFormat("########0.00");
        Statistic.h = new TimeCounter();
        Statistic.i = new DistancesCounter();
        Statistic.j = new DamageCounter();
    }
}
