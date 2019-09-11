package net.minecraft.server;

public class CraftingStatistic extends Statistic
{
    private final Item a;
    
    public CraftingStatistic(final String s, final IChatBaseComponent chatBaseComponent, final Item a) {
        super(s, chatBaseComponent);
        this.a = a;
    }
}
