package net.minecraft.server.v1_7_R4;

public class CraftingStatistic extends Statistic
{
    private final Item a;
    
    public CraftingStatistic(final String s, final IChatBaseComponent chatBaseComponent, final Item a) {
        super(s, chatBaseComponent);
        this.a = a;
    }
}
