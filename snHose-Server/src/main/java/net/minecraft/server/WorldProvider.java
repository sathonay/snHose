package net.minecraft.server.v1_7_R4;

public abstract class WorldProvider
{
    public static final float[] a;
    public World b;
    public WorldType type;
    public String d;
    public WorldChunkManager e;
    public boolean f;
    public boolean g;
    public float[] h;
    public int dimension;
    private float[] j;
    
    public WorldProvider() {
        this.h = new float[16];
        this.j = new float[4];
    }
    
    public final void a(final World b) {
        this.b = b;
        this.type = b.getWorldData().getType();
        this.d = b.getWorldData().getGeneratorOptions();
        this.b();
        this.a();
    }
    
    protected void a() {
        final float n = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            final float n2 = 1.0f - i / 15.0f;
            this.h[i] = (1.0f - n2) / (n2 * 3.0f + 1.0f) * (1.0f - n) + n;
        }
    }
    
    protected void b() {
        if (this.b.getWorldData().getType() == WorldType.FLAT) {
            this.e = new WorldChunkManagerHell(BiomeBase.getBiome(WorldGenFlatInfo.a(this.b.getWorldData().getGeneratorOptions()).a()), 0.5f);
        }
        else {
            this.e = new WorldChunkManager(this.b);
        }
    }
    
    public IChunkProvider getChunkProvider() {
        if (this.type == WorldType.FLAT) {
            return new ChunkProviderFlat(this.b, this.b.getSeed(), this.b.getWorldData().shouldGenerateMapFeatures(), this.d);
        }
        return new ChunkProviderGenerate(this.b, this.b.getSeed(), this.b.getWorldData().shouldGenerateMapFeatures());
    }
    
    public boolean canSpawn(final int i, final int j) {
        return this.b.b(i, j) == Blocks.GRASS;
    }
    
    public float a(final long n, final float n2) {
        float n3 = ((int)(n % 24000L) + n2) / 24000.0f - 0.25f;
        if (n3 < 0.0f) {
            ++n3;
        }
        if (n3 > 1.0f) {
            --n3;
        }
        final float n4 = n3;
        return n4 + (1.0f - (float)((Math.cos(n3 * 3.141592653589793) + 1.0) / 2.0) - n4) / 3.0f;
    }
    
    public int a(final long n) {
        return (int)(n / 24000L % 8L + 8L) % 8;
    }
    
    public boolean d() {
        return true;
    }
    
    public boolean e() {
        return true;
    }
    
    public static WorldProvider byDimension(final int n) {
        if (n == -1) {
            return new WorldProviderHell();
        }
        if (n == 0) {
            return new WorldProviderNormal();
        }
        if (n == 1) {
            return new WorldProviderTheEnd();
        }
        return null;
    }
    
    public ChunkCoordinates h() {
        return null;
    }
    
    public int getSeaLevel() {
        if (this.type == WorldType.FLAT) {
            return 4;
        }
        return 64;
    }
    
    public abstract String getName();
    
    static {
        a = new float[] { 1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f };
    }
}
