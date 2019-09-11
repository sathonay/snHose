package net.minecraft.server;

public class EntityMagmaCube extends EntitySlime
{
    public EntityMagmaCube(final World world) {
        super(world);
        this.fireProof = true;
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.d).setValue(0.20000000298023224);
    }
    
    @Override
    public boolean canSpawn() {
        return this.world.difficulty != EnumDifficulty.PEACEFUL && this.world.b(this.boundingBox) && this.world.getCubes(this, this.boundingBox).isEmpty() && !this.world.containsLiquid(this.boundingBox);
    }
    
    @Override
    public int aV() {
        return this.getSize() * 3;
    }
    
    @Override
    public float d(final float n) {
        return 1.0f;
    }
    
    @Override
    protected String bP() {
        return "flame";
    }
    
    @Override
    protected EntitySlime bQ() {
        return new EntityMagmaCube(this.world);
    }
    
    @Override
    protected Item getLoot() {
        return Items.MAGMA_CREAM;
    }
    
    @Override
    protected void dropDeathLoot(final boolean b, final int n) {
        final Item loot = this.getLoot();
        if (loot != null && this.getSize() > 1) {
            int n2 = this.random.nextInt(4) - 2;
            if (n > 0) {
                n2 += this.random.nextInt(n + 1);
            }
            for (int i = 0; i < n2; ++i) {
                this.a(loot, 1);
            }
        }
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
    
    @Override
    protected int bR() {
        return super.bR() * 4;
    }
    
    @Override
    protected void bS() {
        this.h *= 0.9f;
    }
    
    @Override
    protected void bj() {
        this.motY = 0.42f + this.getSize() * 0.1f;
        this.al = true;
    }
    
    @Override
    protected void b(final float n) {
    }
    
    @Override
    protected boolean bT() {
        return true;
    }
    
    @Override
    protected int bU() {
        return super.bU() + 2;
    }
    
    @Override
    protected String bV() {
        if (this.getSize() > 1) {
            return "mob.magmacube.big";
        }
        return "mob.magmacube.small";
    }
    
    @Override
    public boolean P() {
        return false;
    }
    
    @Override
    protected boolean bW() {
        return true;
    }
}
