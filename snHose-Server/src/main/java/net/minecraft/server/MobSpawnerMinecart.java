package net.minecraft.server.v1_7_R4;

class MobSpawnerMinecart extends MobSpawnerAbstract
{
    final /* synthetic */ EntityMinecartMobSpawner a;
    
    MobSpawnerMinecart(final EntityMinecartMobSpawner a) {
        this.a = a;
    }
    
    @Override
    public void a(final int n) {
        this.a.world.broadcastEntityEffect(this.a, (byte)n);
    }
    
    @Override
    public World a() {
        return this.a.world;
    }
    
    @Override
    public int b() {
        return MathHelper.floor(this.a.locX);
    }
    
    @Override
    public int c() {
        return MathHelper.floor(this.a.locY);
    }
    
    @Override
    public int d() {
        return MathHelper.floor(this.a.locZ);
    }
}
