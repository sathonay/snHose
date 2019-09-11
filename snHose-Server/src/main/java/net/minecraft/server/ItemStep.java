package net.minecraft.server;

public class ItemStep extends ItemBlock
{
    private final boolean b;
    private final BlockStepAbstract c;
    private final BlockStepAbstract d;
    
    public ItemStep(final Block block, final BlockStepAbstract c, final BlockStepAbstract d, final boolean b) {
        super(block);
        this.c = c;
        this.d = d;
        this.b = b;
        this.setMaxDurability(0);
        this.a(true);
    }
    
    @Override
    public int filterData(final int n) {
        return n;
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        return this.c.b(itemStack.getData());
    }
    
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, final int i, final int j, final int k, final int l, final float n, final float n2, final float n3) {
        if (this.b) {
            return super.interactWith(itemstack, entityHuman, world, i, j, k, l, n, n2, n3);
        }
        if (itemstack.count == 0) {
            return false;
        }
        if (!entityHuman.a(i, j, k, l, itemstack)) {
            return false;
        }
        final Block type = world.getType(i, j, k);
        final int data = world.getData(i, j, k);
        final int m = data & 0x7;
        final boolean b = (data & 0x8) != 0x0;
        if (((l == 1 && !b) || (l == 0 && b)) && type == this.c && m == itemstack.getData()) {
            if (world.b(this.d.a(world, i, j, k)) && world.setTypeAndData(i, j, k, this.d, m, 3)) {
                world.makeSound(i + 0.5f, j + 0.5f, k + 0.5f, this.d.stepSound.getPlaceSound(), (this.d.stepSound.getVolume1() + 1.0f) / 2.0f, this.d.stepSound.getVolume2() * 0.8f);
                --itemstack.count;
            }
            return true;
        }
        return this.a(itemstack, entityHuman, world, i, j, k, l) || super.interactWith(itemstack, entityHuman, world, i, j, k, l, n, n2, n3);
    }
    
    private boolean a(final ItemStack itemStack, final EntityHuman entityHuman, final World world, int n, int n2, int n3, final int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        final Block type = world.getType(n, n2, n3);
        final int l = world.getData(n, n2, n3) & 0x7;
        if (type == this.c && l == itemStack.getData()) {
            if (world.b(this.d.a(world, n, n2, n3)) && world.setTypeAndData(n, n2, n3, this.d, l, 3)) {
                world.makeSound(n + 0.5f, n2 + 0.5f, n3 + 0.5f, this.d.stepSound.getPlaceSound(), (this.d.stepSound.getVolume1() + 1.0f) / 2.0f, this.d.stepSound.getVolume2() * 0.8f);
                --itemStack.count;
            }
            return true;
        }
        return false;
    }
}
