package net.minecraft.server.v1_7_R4;

public class ItemHoe extends Item
{
    protected EnumToolMaterial a;
    
    public ItemHoe(final EnumToolMaterial a) {
        this.a = a;
        this.maxStackSize = 1;
        this.setMaxDurability(a.a());
        this.a(CreativeModeTab.i);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityliving, final World world, final int n, final int j, final int n2, final int l, final float n3, final float n4, final float n5) {
        if (!entityliving.a(n, j, n2, l, itemstack)) {
            return false;
        }
        final Block type = world.getType(n, j, n2);
        if (l == 0 || world.getType(n, j + 1, n2).getMaterial() != Material.AIR || (type != Blocks.GRASS && type != Blocks.DIRT)) {
            return false;
        }
        final Block soil = Blocks.SOIL;
        world.makeSound(n + 0.5f, j + 0.5f, n2 + 0.5f, soil.stepSound.getStepSound(), (soil.stepSound.getVolume1() + 1.0f) / 2.0f, soil.stepSound.getVolume2() * 0.8f);
        if (world.isStatic) {
            return true;
        }
        world.setTypeUpdate(n, j, n2, soil);
        itemstack.damage(1, entityliving);
        return true;
    }
    
    public String i() {
        return this.a.toString();
    }
}
