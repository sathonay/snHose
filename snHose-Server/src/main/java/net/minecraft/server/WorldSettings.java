package net.minecraft.server;

public final class WorldSettings
{
    private final long a;
    private final EnumGamemode b;
    private final boolean c;
    private final boolean d;
    private final WorldType e;
    private boolean f;
    private boolean g;
    private String h;
    
    public WorldSettings(final long a, final EnumGamemode b, final boolean c, final boolean d, final WorldType e) {
        this.h = "";
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public WorldSettings(final WorldData worldData) {
        this(worldData.getSeed(), worldData.getGameType(), worldData.shouldGenerateMapFeatures(), worldData.isHardcore(), worldData.getType());
    }
    
    public WorldSettings a() {
        this.g = true;
        return this;
    }
    
    public WorldSettings a(final String h) {
        this.h = h;
        return this;
    }
    
    public boolean c() {
        return this.g;
    }
    
    public long d() {
        return this.a;
    }
    
    public EnumGamemode e() {
        return this.b;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public boolean g() {
        return this.c;
    }
    
    public WorldType h() {
        return this.e;
    }
    
    public boolean i() {
        return this.f;
    }
    
    public static EnumGamemode a(final int n) {
        return EnumGamemode.getById(n);
    }
    
    public String j() {
        return this.h;
    }
}
