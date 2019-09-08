package net.minecraft.server.v1_7_R4;

class MobSpawner extends MobSpawnerAbstract
{
    final /* synthetic */ TileEntityMobSpawner a;
    
    MobSpawner(final TileEntityMobSpawner a) {
        this.a = a;
    }
    
    @Override
    public void a(final int l) {
        this.a.world.playBlockAction(this.a.x, this.a.y, this.a.z, Blocks.MOB_SPAWNER, l, 0);
    }
    
    @Override
    public World a() {
        return this.a.world;
    }
    
    @Override
    public int b() {
        return this.a.x;
    }
    
    @Override
    public int c() {
        return this.a.y;
    }
    
    @Override
    public int d() {
        return this.a.z;
    }
    
    @Override
    public void a(final TileEntityMobSpawnerData tileentitymobspawnerdata) {
        super.a(tileentitymobspawnerdata);
        if (this.a() != null) {
            this.a().notify(this.a.x, this.a.y, this.a.z);
        }
    }
}
