package net.minecraft.server.v1_7_R4;

public class PathfinderGoalOwnerHurtTarget extends PathfinderGoalTarget
{
    EntityTameableAnimal a;
    EntityLiving b;
    private int e;
    
    public PathfinderGoalOwnerHurtTarget(final EntityTameableAnimal entityTameableAnimal) {
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
        this.b = owner.aL();
        return owner.aM() != this.e && this.a(this.b, false) && this.a.a(this.b, owner);
    }
    
    @Override
    public void c() {
        this.c.setGoalTarget(this.b);
        final EntityLiving owner = this.a.getOwner();
        if (owner != null) {
            this.e = owner.aM();
        }
        super.c();
    }
}
