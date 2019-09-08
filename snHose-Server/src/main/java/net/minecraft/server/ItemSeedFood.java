package net.minecraft.server.v1_7_R4;

public class ItemSeedFood extends ItemFood
{
    private Block b;
    private Block c;
    
    public ItemSeedFood(final int n, final float n2, final Block b, final Block c) {
        super(n, n2, false);
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean interactWith(final ItemStack itemStack, final EntityHuman entityHuman, final World world, final int i, final int n, final int k, final int n2, final float n3, final float n4, final float n5) {
        if (n2 != 1) {
            return false;
        }
        if (!entityHuman.a(i, n, k, n2, itemStack) || !entityHuman.a(i, n + 1, k, n2, itemStack)) {
            return false;
        }
        if (world.getType(i, n, k) == this.c && world.isEmpty(i, n + 1, k)) {
            world.setTypeUpdate(i, n + 1, k, this.b);
            --itemStack.count;
            return true;
        }
        return false;
    }
}
