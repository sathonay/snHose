package net.minecraft.server.v1_7_R4;

public class EntityMinecartRideable extends EntityMinecartAbstract
{
    public EntityMinecartRideable(final World world) {
        super(world);
    }
    
    public EntityMinecartRideable(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
    }
    
    @Override
    public boolean c(final EntityHuman entityHuman) {
        if (this.passenger != null && this.passenger instanceof EntityHuman && this.passenger != entityHuman) {
            return true;
        }
        if (this.passenger != null && this.passenger != entityHuman) {
            return false;
        }
        if (!this.world.isStatic) {
            entityHuman.mount(this);
        }
        return true;
    }
    
    @Override
    public int m() {
        return 0;
    }
}
