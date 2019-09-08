package net.minecraft.server.v1_7_R4;

public class EntityMinecartChest extends EntityMinecartContainer
{
    public EntityMinecartChest(final World world) {
        super(world);
    }
    
    public EntityMinecartChest(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
    }
    
    @Override
    public void a(final DamageSource damagesource) {
        super.a(damagesource);
        this.a(Item.getItemOf(Blocks.CHEST), 1, 0.0f);
    }
    
    @Override
    public int getSize() {
        return 27;
    }
    
    @Override
    public int m() {
        return 1;
    }
    
    @Override
    public Block o() {
        return Blocks.CHEST;
    }
    
    @Override
    public int s() {
        return 8;
    }
}
