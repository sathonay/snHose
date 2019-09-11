package net.minecraft.server;

public class WorldProviderTheEnd extends WorldProvider
{
    public void b() {
        this.e = new WorldChunkManagerHell(BiomeBase.SKY, 0.0f);
        this.dimension = 1;
        this.g = true;
    }
    
    @Override
    public IChunkProvider getChunkProvider() {
        return new ChunkProviderTheEnd(this.b, this.b.getSeed());
    }
    
    @Override
    public float a(final long n, final float n2) {
        return 0.0f;
    }
    
    @Override
    public boolean e() {
        return false;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public boolean canSpawn(final int i, final int j) {
        return this.b.b(i, j).getMaterial().isSolid();
    }
    
    @Override
    public ChunkCoordinates h() {
        return new ChunkCoordinates(100, 50, 0);
    }
    
    @Override
    public int getSeaLevel() {
        return 50;
    }
    
    @Override
    public String getName() {
        return "The End";
    }
}
