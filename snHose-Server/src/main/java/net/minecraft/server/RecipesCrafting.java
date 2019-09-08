package net.minecraft.server.v1_7_R4;

public class RecipesCrafting
{
    public void a(final CraftingManager craftingManager) {
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.CHEST), "###", "# #", "###", '#', Blocks.WOOD);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.TRAPPED_CHEST), "#-", '#', Blocks.CHEST, '-', Blocks.TRIPWIRE_SOURCE);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.ENDER_CHEST), "###", "#E#", "###", '#', Blocks.OBSIDIAN, 'E', Items.EYE_OF_ENDER);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.FURNACE), "###", "# #", "###", '#', Blocks.COBBLESTONE);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.WORKBENCH), "##", "##", '#', Blocks.WOOD);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE), "##", "##", '#', new ItemStack(Blocks.SAND, 1, 0));
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 4, 2), "##", "##", '#', Blocks.SANDSTONE);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 1, 1), "#", "#", '#', new ItemStack(Blocks.STEP, 1, 1));
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1), "#", "#", '#', new ItemStack(Blocks.STEP, 1, 7));
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 2, 2), "#", "#", '#', new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0));
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.SMOOTH_BRICK, 4), "##", "##", '#', Blocks.STONE);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.IRON_FENCE, 16), "###", "###", '#', Items.IRON_INGOT);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.THIN_GLASS, 16), "###", "###", '#', Blocks.GLASS);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.REDSTONE_LAMP_OFF, 1), " R ", "RGR", " R ", 'R', Items.REDSTONE, 'G', Blocks.GLOWSTONE);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.BEACON, 1), "GGG", "GSG", "OOO", 'G', Blocks.GLASS, 'S', Items.NETHER_STAR, 'O', Blocks.OBSIDIAN);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK, 1), "NN", "NN", 'N', Items.NETHER_BRICK);
    }
}
