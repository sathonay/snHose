package net.minecraft.server.v1_7_R4;

public class RecipesDyes
{
    public void a(final CraftingManager craftingManager) {
        for (int i = 0; i < 16; ++i) {
            craftingManager.registerShapelessRecipe(new ItemStack(Blocks.WOOL, 1, BlockCloth.c(i)), new ItemStack(Items.INK_SACK, 1, i), new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 0));
            craftingManager.registerShapedRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 8, BlockCloth.c(i)), "###", "#X#", "###", '#', new ItemStack(Blocks.HARDENED_CLAY), 'X', new ItemStack(Items.INK_SACK, 1, i));
            craftingManager.registerShapedRecipe(new ItemStack(Blocks.STAINED_GLASS, 8, BlockCloth.c(i)), "###", "#X#", "###", '#', new ItemStack(Blocks.GLASS), 'X', new ItemStack(Items.INK_SACK, 1, i));
            craftingManager.registerShapedRecipe(new ItemStack(Blocks.STAINED_GLASS_PANE, 16, i), "###", "###", '#', new ItemStack(Blocks.STAINED_GLASS, 1, i));
        }
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 11), new ItemStack(Blocks.YELLOW_FLOWER, 1, 0));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Blocks.RED_ROSE, 1, 0));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 3, 15), Items.BONE);
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 9), new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 14), new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Items.INK_SACK, 1, 11));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 10), new ItemStack(Items.INK_SACK, 1, 2), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 8), new ItemStack(Items.INK_SACK, 1, 0), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 7), new ItemStack(Items.INK_SACK, 1, 8), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 3, 7), new ItemStack(Items.INK_SACK, 1, 0), new ItemStack(Items.INK_SACK, 1, 15), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 12), new ItemStack(Items.INK_SACK, 1, 4), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 6), new ItemStack(Items.INK_SACK, 1, 4), new ItemStack(Items.INK_SACK, 1, 2));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 5), new ItemStack(Items.INK_SACK, 1, 4), new ItemStack(Items.INK_SACK, 1, 1));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 13), new ItemStack(Items.INK_SACK, 1, 5), new ItemStack(Items.INK_SACK, 1, 9));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 3, 13), new ItemStack(Items.INK_SACK, 1, 4), new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Items.INK_SACK, 1, 9));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 4, 13), new ItemStack(Items.INK_SACK, 1, 4), new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Items.INK_SACK, 1, 15));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 12), new ItemStack(Blocks.RED_ROSE, 1, 1));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 13), new ItemStack(Blocks.RED_ROSE, 1, 2));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 7), new ItemStack(Blocks.RED_ROSE, 1, 3));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 1), new ItemStack(Blocks.RED_ROSE, 1, 4));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 14), new ItemStack(Blocks.RED_ROSE, 1, 5));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 7), new ItemStack(Blocks.RED_ROSE, 1, 6));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 9), new ItemStack(Blocks.RED_ROSE, 1, 7));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 1, 7), new ItemStack(Blocks.RED_ROSE, 1, 8));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 11), new ItemStack(Blocks.DOUBLE_PLANT, 1, 0));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 13), new ItemStack(Blocks.DOUBLE_PLANT, 1, 1));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 1), new ItemStack(Blocks.DOUBLE_PLANT, 1, 4));
        craftingManager.registerShapelessRecipe(new ItemStack(Items.INK_SACK, 2, 9), new ItemStack(Blocks.DOUBLE_PLANT, 1, 5));
        for (int j = 0; j < 16; ++j) {
            craftingManager.registerShapedRecipe(new ItemStack(Blocks.WOOL_CARPET, 3, j), "##", '#', new ItemStack(Blocks.WOOL, 1, j));
        }
    }
}
