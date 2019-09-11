package net.minecraft.server;

public class TileEntityMobSpawner extends TileEntity
{
    private final MobSpawnerAbstract a;
    
    public TileEntityMobSpawner() {
        this.a = new MobSpawner(this);
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        this.a.a(nbtTagCompound);
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a.b(nbtTagCompound);
    }
    
    @Override
    public void h() {
        this.a.g();
        super.h();
    }
    
    @Override
    public Packet getUpdatePacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.b(nbttagcompound);
        nbttagcompound.remove("SpawnPotentials");
        return new PacketPlayOutTileEntityData(this.x, this.y, this.z, 1, nbttagcompound);
    }
    
    @Override
    public boolean c(final int n, final int j) {
        return this.a.b(n) || super.c(n, j);
    }
    
    public MobSpawnerAbstract getSpawner() {
        return this.a;
    }
}
