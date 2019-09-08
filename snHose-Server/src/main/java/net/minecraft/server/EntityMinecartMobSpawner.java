package net.minecraft.server.v1_7_R4;

public class EntityMinecartMobSpawner extends EntityMinecartAbstract
{
    private final MobSpawnerAbstract a;
    
    public EntityMinecartMobSpawner(final World world) {
        super(world);
        this.a = new MobSpawnerMinecart(this);
    }
    
    public EntityMinecartMobSpawner(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
        this.a = new MobSpawnerMinecart(this);
    }
    
    @Override
    public int m() {
        return 4;
    }
    
    @Override
    public Block o() {
        return Blocks.MOB_SPAWNER;
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        this.a.a(nbtTagCompound);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a.b(nbtTagCompound);
    }
    
    @Override
    public void h() {
        super.h();
        this.a.g();
    }
}
