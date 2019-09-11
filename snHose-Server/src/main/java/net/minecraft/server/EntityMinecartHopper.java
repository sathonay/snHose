package net.minecraft.server;

import java.util.*;

public class EntityMinecartHopper extends EntityMinecartContainer implements IHopper
{
    private boolean a;
    private int b;
    
    public EntityMinecartHopper(final World world) {
        super(world);
        this.a = true;
        this.b = -1;
    }
    
    public EntityMinecartHopper(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
        this.a = true;
        this.b = -1;
    }
    
    @Override
    public int m() {
        return 5;
    }
    
    @Override
    public Block o() {
        return Blocks.HOPPER;
    }
    
    @Override
    public int s() {
        return 1;
    }
    
    @Override
    public int getSize() {
        return 5;
    }
    
    @Override
    public boolean c(final EntityHuman entityHuman) {
        if (!this.world.isStatic) {
            entityHuman.openMinecartHopper(this);
        }
        return true;
    }
    
    @Override
    public void a(final int n, final int n2, final int n3, final boolean b) {
        final boolean b2 = !b;
        if (b2 != this.v()) {
            this.f(b2);
        }
    }
    
    public boolean v() {
        return this.a;
    }
    
    public void f(final boolean a) {
        this.a = a;
    }
    
    @Override
    public World getWorld() {
        return this.world;
    }
    
    @Override
    public double x() {
        return this.locX;
    }
    
    @Override
    public double aD() {
        return this.locY;
    }
    
    @Override
    public double aE() {
        return this.locZ;
    }
    
    @Override
    public void h() {
        super.h();
        if (!this.world.isStatic && this.isAlive() && this.v()) {
            --this.b;
            if (!this.aG()) {
                this.n(0);
                if (this.aF()) {
                    this.n(4);
                    this.update();
                }
            }
        }
    }
    
    public boolean aF() {
        if (TileEntityHopper.suckInItems(this)) {
            return true;
        }
        final List a = this.world.a(EntityItem.class, this.boundingBox.grow(0.25, 0.0, 0.25), IEntitySelector.a);
        if (a.size() > 0) {
            TileEntityHopper.addEntityItem(this, a.get(0));
        }
        return false;
    }
    
    @Override
    public void a(final DamageSource damagesource) {
        super.a(damagesource);
        this.a(Item.getItemOf(Blocks.HOPPER), 1, 0.0f);
    }
    
    @Override
    protected void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("TransferCooldown", this.b);
    }
    
    @Override
    protected void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.b = nbttagcompound.getInt("TransferCooldown");
    }
    
    public void n(final int b) {
        this.b = b;
    }
    
    public boolean aG() {
        return this.b > 0;
    }
}
