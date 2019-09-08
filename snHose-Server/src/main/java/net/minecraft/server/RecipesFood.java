package net.minecraft.server.v1_7_R4;

public class RecipesFood
{
    public void a(final CraftingManager craftingManager) {
        craftingManager.registerShapelessRecipe(new ItemStack(Items.MUSHROOM_SOUP), Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Items.BOWL);
        craftingManager.registerShapedRecipe(new ItemStack(Items.COOKIE, 8), "#X#", 'X', new ItemStack(Items.INK_SACK, 1, 3), '#', Items.WHEAT);
        craftingManager.registerShapedRecipe(new ItemStack(Blocks.MELON), "MMM", "MMM", "MMM", 'M', Items.MELON);
        craftingManager.registerShapedRecipe(new ItemStack(Items.MELON_SEEDS), "M", 'M', Items.MELON);
        craftingManager.registerShapedRecipe(new ItemStack(Items.PUMPKIN_SEEDS, 4), "M", 'M', Blocks.PUMPKIN);
        craftingManager.registerShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), Blocks.PUMPKIN, Items.SUGAR, Items.EGG);
        craftingManager.registerShapelessRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE), Items.SPIDER_EYE, Blocks.BROWN_MUSHROOM, Items.SUGAR);
        craftingManager.registerShapelessRecipe(new ItemStack(Items.BLAZE_POWDER, 2), Items.BLAZE_ROD);
        craftingManager.registerShapelessRecipe(new ItemStack(Items.MAGMA_CREAM), Items.BLAZE_POWDER, Items.SLIME_BALL);
    }
}
