package net.minecraft.server.v1_7_R4;

public class WorldProviderHell extends WorldProvider
{
    public void b() {
        this.e = new WorldChunkManagerHell(BiomeBase.HELL, 0.0f);
        this.f = true;
        this.g = true;
        this.dimension = -1;
    }
    
    @Override
    protected void a() {
        final float n = 0.1f;
        for (int i = 0; i <= 15; ++i) {
            final float n2 = 1.0f - i / 15.0f;
            this.h[i] = (1.0f - n2) / (n2 * 3.0f + 1.0f) * (1.0f - n) + n;
        }
    }
    
    @Override
    public IChunkProvider getChunkProvider() {
        return new ChunkProviderHell(this.b, this.b.getSeed());
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public boolean canSpawn(final int n, final int n2) {
        return false;
    }
    
    @Override
    public float a(final long n, final float n2) {
        return 0.5f;
    }
    
    @Override
    public boolean e() {
        return false;
    }
    
    @Override
    public String getName() {
        return "Nether";
    }
}
