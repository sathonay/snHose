package net.minecraft.server;

public abstract class EntityAmbient extends EntityInsentient implements IAnimal
{
    public EntityAmbient(final World world) {
        super(world);
    }
    
    @Override
    public boolean bM() {
        return false;
    }
    
    @Override
    protected boolean a(final EntityHuman entityHuman) {
        return false;
    }
}
