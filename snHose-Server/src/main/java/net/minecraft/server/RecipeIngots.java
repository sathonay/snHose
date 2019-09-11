package net.minecraft.server;

public class RecipeIngots
{
    private Object[][] a;
    
    public RecipeIngots() {
        this.a = new Object[][] { { Blocks.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9) }, { Blocks.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9) }, { Blocks.DIAMOND_BLOCK, new ItemStack(Items.DIAMOND, 9) }, { Blocks.EMERALD_BLOCK, new ItemStack(Items.EMERALD, 9) }, { Blocks.LAPIS_BLOCK, new ItemStack(Items.INK_SACK, 9, 4) }, { Blocks.REDSTONE_BLOCK, new ItemStack(Items.REDSTONE, 9) }, { Blocks.COAL_BLOCK, new ItemStack(Items.COAL, 9, 0) }, { Blocks.HAY_BLOCK, new ItemStack(Items.WHEAT, 9) } };
    }
    
    public void a(final CraftingManager craftingManager) {
        for (int i = 0; i < this.a.length; ++i) {
            final Block block = (Block)this.a[i][0];
            final ItemStack itemstack = (ItemStack)this.a[i][1];
            craftingManager.registerShapedRecipe(new ItemStack(block), "###", "###", "###", '#', itemstack);
            craftingManager.registerShapedRecipe(itemstack, "#", '#', block);
        }
        craftingManager.registerShapedRecipe(new ItemStack(Items.GOLD_INGOT), "###", "###", "###", '#', Items.GOLD_NUGGET);
        craftingManager.registerShapedRecipe(new ItemStack(Items.GOLD_NUGGET, 9), "#", '#', Items.GOLD_INGOT);
    }
}
