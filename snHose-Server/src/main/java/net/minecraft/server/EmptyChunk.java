package net.minecraft.server;

import java.util.*;

public class EmptyChunk extends Chunk
{
    public EmptyChunk(final World world, final int i, final int j) {
        super(world, i, j);
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return n == this.locX && n2 == this.locZ;
    }
    
    @Override
    public int b(final int n, final int n2) {
        return 0;
    }
    
    @Override
    public void initLighting() {
    }
    
    @Override
    public Block getType(final int n, final int n2, final int n3) {
        return Blocks.AIR;
    }
    
    @Override
    public int b(final int n, final int n2, final int n3) {
        return 255;
    }
    
    @Override
    public boolean a(final int n, final int n2, final int n3, final Block block, final int n4) {
        return true;
    }
    
    @Override
    public int getData(final int n, final int n2, final int n3) {
        return 0;
    }
    
    @Override
    public boolean a(final int n, final int n2, final int n3, final int n4) {
        return false;
    }
    
    @Override
    public int getBrightness(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3) {
        return 0;
    }
    
    @Override
    public void a(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3, final int n4) {
    }
    
    @Override
    public int b(final int n, final int n2, final int n3, final int n4) {
        return 0;
    }
    
    @Override
    public void a(final Entity entity) {
    }
    
    @Override
    public void b(final Entity entity) {
    }
    
    @Override
    public void a(final Entity entity, final int n) {
    }
    
    @Override
    public boolean d(final int n, final int n2, final int n3) {
        return false;
    }
    
    @Override
    public TileEntity e(final int n, final int n2, final int n3) {
        return null;
    }
    
    @Override
    public void a(final TileEntity tileEntity) {
    }
    
    @Override
    public void a(final int n, final int n2, final int n3, final TileEntity tileEntity) {
    }
    
    @Override
    public void f(final int n, final int n2, final int n3) {
    }
    
    @Override
    public void addEntities() {
    }
    
    @Override
    public void removeEntities() {
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void a(final Entity entity, final AxisAlignedBB axisAlignedBB, final List list, final IEntitySelector entitySelector) {
    }
    
    @Override
    public void a(final Class clazz, final AxisAlignedBB axisAlignedBB, final List list, final IEntitySelector entitySelector) {
    }
    
    @Override
    public boolean a(final boolean b) {
        return false;
    }
    
    @Override
    public Random a(final long n) {
        return new Random(this.world.getSeed() + this.locX * this.locX * 4987142 + this.locX * 5947611 + this.locZ * this.locZ * 4392871L + this.locZ * 389711 ^ n);
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public boolean c(final int n, final int n2) {
        return true;
    }
}
