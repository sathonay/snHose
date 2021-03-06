package net.minecraft.server;

public class PathfinderGoalOwnerHurtByTarget extends PathfinderGoalTarget
{
    EntityTameableAnimal a;
    EntityLiving b;
    private int e;
    
    public PathfinderGoalOwnerHurtByTarget(final EntityTameableAnimal entityTameableAnimal) {
        super(entityTameableAnimal, false);
        this.a = entityTameableAnimal;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        if (!this.a.isTamed()) {
            return false;
        }
        final EntityLiving owner = this.a.getOwner();
        if (owner == null) {
            return false;
        }
        this.b = owner.getLastDamager();
        return owner.aK() != this.e && this.a(this.b, false) && this.a.a(this.b, owner);
    }
    
    @Override
    public void c() {
        this.c.setGoalTarget(this.b);
        final EntityLiving owner = this.a.getOwner();
        if (owner != null) {
            this.e = owner.aK();
        }
        super.c();
    }
}
