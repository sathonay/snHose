package net.minecraft.server;

public class Achievement extends Statistic
{
    public final int a;
    public final int b;
    public final Achievement c;
    private final String k;
    public final ItemStack d;
    private boolean m;
    
    public Achievement(final String s, final String s2, final int n, final int n2, final Item item, final Achievement achievement) {
        this(s, s2, n, n2, new ItemStack(item), achievement);
    }
    
    public Achievement(final String s, final String s2, final int n, final int n2, final Block block, final Achievement achievement) {
        this(s, s2, n, n2, new ItemStack(block), achievement);
    }
    
    public Achievement(final String s, final String s2, final int c, final int d, final ItemStack d2, final Achievement c2) {
        super(s, new ChatMessage("achievement." + s2, new Object[0]));
        this.d = d2;
        this.k = "achievement." + s2 + ".desc";
        this.a = c;
        this.b = d;
        if (c < AchievementList.a) {
            AchievementList.a = c;
        }
        if (d < AchievementList.b) {
            AchievementList.b = d;
        }
        if (c > AchievementList.c) {
            AchievementList.c = c;
        }
        if (d > AchievementList.d) {
            AchievementList.d = d;
        }
        this.c = c2;
    }
    
    public Achievement a() {
        this.f = true;
        return this;
    }
    
    public Achievement b() {
        this.m = true;
        return this;
    }
    
    public Achievement c() {
        super.h();
        AchievementList.e.add(this);
        return this;
    }
    
    @Override
    public boolean d() {
        return true;
    }
    
    @Override
    public IChatBaseComponent e() {
        final IChatBaseComponent e = super.e();
        e.getChatModifier().setColor(this.g() ? EnumChatFormat.DARK_PURPLE : EnumChatFormat.GREEN);
        return e;
    }
    
    public Achievement a(final Class clazz) {
        return (Achievement)super.b(clazz);
    }
    
    public boolean g() {
        return this.m;
    }
}
