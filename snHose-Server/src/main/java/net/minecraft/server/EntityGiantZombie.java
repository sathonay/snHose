package net.minecraft.server.v1_7_R4;

public class EntityGiantZombie extends EntityMonster
{
    public EntityGiantZombie(final World world) {
        super(world);
        this.height *= 6.0f;
        this.a(this.width * 6.0f, this.length * 6.0f);
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(100.0);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.5);
        this.getAttributeInstance(GenericAttributes.e).setValue(50.0);
    }
    
    @Override
    public float a(final int i, final int j, final int k) {
        return this.world.n(i, j, k) - 0.5f;
    }
}
