package net.minecraft.server;

public class EntityComplexPart extends Entity
{
    public final IComplex owner;
    public final String b;
    
    public EntityComplexPart(final IComplex owner, final String b, final float f, final float f2) {
        super(owner.a());
        this.a(f, f2);
        this.owner = owner;
        this.b = b;
    }
    
    @Override
    protected void c() {
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
    }
    
    @Override
    public boolean R() {
        return true;
    }
    
    @Override
    public boolean damageEntity(final DamageSource damageSource, final float n) {
        return !this.isInvulnerable() && this.owner.a(this, damageSource, n);
    }
    
    @Override
    public boolean i(final Entity entity) {
        return this == entity || this.owner == entity;
    }
}
