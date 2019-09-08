package net.minecraft.server.v1_7_R4;

public class WorldType
{
    public static final WorldType[] types;
    public static final WorldType NORMAL;
    public static final WorldType FLAT;
    public static final WorldType LARGE_BIOMES;
    public static final WorldType AMPLIFIED;
    public static final WorldType NORMAL_1_1;
    private final int g;
    private final String name;
    private final int version;
    private boolean j;
    private boolean k;
    private boolean l;
    
    private WorldType(final int n, final String s) {
        this(n, s, 0);
    }
    
    private WorldType(final int g, final String name, final int version) {
        this.name = name;
        this.version = version;
        this.j = true;
        this.g = g;
        WorldType.types[g] = this;
    }
    
    public String name() {
        return this.name;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public WorldType a(final int n) {
        if (this == WorldType.NORMAL && n == 0) {
            return WorldType.NORMAL_1_1;
        }
        return this;
    }
    
    private WorldType a(final boolean j) {
        this.j = j;
        return this;
    }
    
    private WorldType i() {
        this.k = true;
        return this;
    }
    
    public boolean f() {
        return this.k;
    }
    
    public static WorldType getType(final String s) {
        for (int i = 0; i < WorldType.types.length; ++i) {
            if (WorldType.types[i] != null && WorldType.types[i].name.equalsIgnoreCase(s)) {
                return WorldType.types[i];
            }
        }
        return null;
    }
    
    public int g() {
        return this.g;
    }
    
    private WorldType j() {
        this.l = true;
        return this;
    }
    
    static {
        types = new WorldType[16];
        NORMAL = new WorldType(0, "default", 1).i();
        FLAT = new WorldType(1, "flat");
        LARGE_BIOMES = new WorldType(2, "largeBiomes");
        AMPLIFIED = new WorldType(3, "amplified").j();
        NORMAL_1_1 = new WorldType(8, "default_1_1", 0).a(false);
    }
}
