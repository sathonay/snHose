package net.minecraft.server.v1_7_R4;

public abstract class EntityGolem extends EntityCreature implements IAnimal
{
    public EntityGolem(final World world) {
        super(world);
    }
    
    @Override
    protected void b(final float n) {
    }
    
    @Override
    protected String t() {
        return "none";
    }
    
    @Override
    protected String aT() {
        return "none";
    }
    
    @Override
    protected String aU() {
        return "none";
    }
    
    @Override
    public int q() {
        return 120;
    }
    
    @Override
    protected boolean isTypeNotPersistent() {
        return false;
    }
}
