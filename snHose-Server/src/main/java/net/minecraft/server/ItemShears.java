package net.minecraft.server.v1_7_R4;

public class ItemShears extends Item
{
    public ItemShears() {
        this.e(1);
        this.setMaxDurability(238);
        this.a(CreativeModeTab.i);
    }
    
    @Override
    public boolean a(final ItemStack itemstack, final World world, final Block block, final int i, final int j, final int k, final EntityLiving entityLiving) {
        if (block.getMaterial() == Material.LEAVES || block == Blocks.WEB || block == Blocks.LONG_GRASS || block == Blocks.VINE || block == Blocks.TRIPWIRE) {
            itemstack.damage(1, entityLiving);
            return true;
        }
        return super.a(itemstack, world, block, i, j, k, entityLiving);
    }
    
    @Override
    public boolean canDestroySpecialBlock(final Block block) {
        return block == Blocks.WEB || block == Blocks.REDSTONE_WIRE || block == Blocks.TRIPWIRE;
    }
    
    @Override
    public float getDestroySpeed(final ItemStack itemstack, final Block block) {
        if (block == Blocks.WEB || block.getMaterial() == Material.LEAVES) {
            return 15.0f;
        }
        if (block == Blocks.WOOL) {
            return 5.0f;
        }
        return super.getDestroySpeed(itemstack, block);
    }
}
